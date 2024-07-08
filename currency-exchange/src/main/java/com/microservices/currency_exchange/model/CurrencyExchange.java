package com.microservices.currency_exchange.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "convert_from")
    String from;
    @Column(name = "convert_to")
    String to;
    String conversionMultiple;
    @Transient
    String environment;
}
