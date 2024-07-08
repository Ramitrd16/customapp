package com.microservices.currency_conversion.feign;

import com.microservices.currency_conversion.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000/api/ce")
public interface CurrencyExchangeProxy {
    @GetMapping("/convert-{from}-currency-{to}-currency")
    ResponseEntity<CurrencyConversion> returnCurrency(@PathVariable String from, @PathVariable String to);
}
