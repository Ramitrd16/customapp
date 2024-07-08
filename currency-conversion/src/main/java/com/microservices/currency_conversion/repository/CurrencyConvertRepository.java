package com.microservices.currency_conversion.repository;

import com.microservices.currency_conversion.model.CurrencyConversion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConvertRepository extends MongoRepository<CurrencyConversion, Long> {

}
