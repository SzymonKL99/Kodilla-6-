package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();

        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Poland", new BigDecimal("37750000")));
        europe.addCountry(new Country("Czech Republic", new BigDecimal("10510000")));
        europe.addCountry(new Country("Germany", new BigDecimal("83200000")));
        world.addContinents(europe);

        Continent asia = new Continent("Asia");
        asia.addCountry(new Country("Japan", new BigDecimal("125700000")));
        asia.addCountry(new Country("China", new BigDecimal("1400000000")));
        asia.addCountry(new Country("Iran", new BigDecimal("87000000")));
        world.addContinents(asia);

        //When
        BigDecimal totalPopulation = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPopulation = new BigDecimal("1744160000");
        assertEquals(expectedPopulation, totalPopulation);

    }
}
