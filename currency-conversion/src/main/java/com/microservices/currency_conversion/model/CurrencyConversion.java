package com.microservices.currency_conversion.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.math.BigDecimal;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CurrencyConversion {
    Long id;
    String from;
    String to;
    String conversionMultiple;
    Long quantity;
    BigDecimal totalCalCulatedAmount;
    String environment;
}
