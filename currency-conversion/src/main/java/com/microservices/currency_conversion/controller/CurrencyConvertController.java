package com.microservices.currency_conversion.controller;

import com.microservices.currency_conversion.feign.CurrencyExchangeProxy;
import com.microservices.currency_conversion.model.CurrencyConversion;
import com.microservices.currency_conversion.repository.CurrencyConvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cc")
public class CurrencyConvertController {

    private final Environment environment;
    private final CurrencyConvertRepository currencyConvertRepository;
    private final CurrencyExchangeProxy currencyExchangeProxy;


    // MS call by Feign Client
    @GetMapping("/currency-conversion-from-feign/{curr1}/to/{curr2}")
    public ResponseEntity<CurrencyConversion> getCUrrencyAmountFeign(@PathVariable("curr1") String from, @PathVariable("curr2") String to, @RequestParam("quantity") Long quantity){
        ResponseEntity<CurrencyConversion> currencyConversionEntity = currencyExchangeProxy.returnCurrency(from, to);
        CurrencyConversion currencyConversion = currencyConversionEntity.getBody();
        assert currencyConversion != null;
        currencyConversion.setQuantity(quantity);
        currencyConversion.setEnvironment(environment.getProperty("server.port"));
        currencyConversion.setTotalCalCulatedAmount(new BigDecimal(currencyConversion.getConversionMultiple()).multiply(new BigDecimal(quantity)));
        currencyConvertRepository.save(currencyConversion);
        return ResponseEntity.ok(currencyConversion);
    }

    // MS call by Rest Template
    @GetMapping("/currency-conversion-from/{curr1}/to/{curr2}")
    public ResponseEntity<CurrencyConversion> getCUrrencyAmount(@PathVariable("curr1") String from, @PathVariable("curr2") String to, @RequestParam("quantity") Long quantity){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("from", from);
        uriParams.put("to", to);
        ResponseEntity<CurrencyConversion> entity = restTemplate.getForEntity("http://localhost:8000/api/ce/convert-{from}-currency-{to}-currency", CurrencyConversion.class, uriParams);
        CurrencyConversion currencyConversion  = entity.getBody();
        currencyConversion.setEnvironment(environment.getProperty("server.port"));
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalCulatedAmount(new BigDecimal(currencyConversion.getConversionMultiple()).multiply(new BigDecimal(quantity)));
        return ResponseEntity.ok(currencyConversion);
    }
}
