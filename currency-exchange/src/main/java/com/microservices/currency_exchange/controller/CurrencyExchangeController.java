package com.microservices.currency_exchange.controller;

import com.microservices.currency_exchange.model.CurrencyExchange;
import com.microservices.currency_exchange.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ce")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeRepository exchangeRepository;

    /*convert currency from a passed to provided*/
    @GetMapping("/convert-{from}-currency-{to}-currency")
    public ResponseEntity<CurrencyExchange> returnCurrency(
            @PathVariable String from,
            @PathVariable String to
    ){
        CurrencyExchange currencyExchange = exchangeRepository.findByFromAndTo(from, to);
        if(currencyExchange==null){
            throw new RuntimeException();
        }
        currencyExchange.setEnvironment(environment.getProperty("server.port"));
        return ResponseEntity.ok(currencyExchange);

    }

}
