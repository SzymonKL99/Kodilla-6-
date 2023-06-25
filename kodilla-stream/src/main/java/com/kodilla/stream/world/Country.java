package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private String nameCountry;
    private BigDecimal population;

    public Country(String nameCountry, BigDecimal population) {
        this.nameCountry = nameCountry;
        this.population = population;
    }
    public BigDecimal getPeopleQuantity() {
        return population;
    }
}
