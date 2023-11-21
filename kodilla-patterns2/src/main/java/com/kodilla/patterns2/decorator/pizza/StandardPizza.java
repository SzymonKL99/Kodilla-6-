package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class StandardPizza implements PizzaOrder {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(15);
    }
    @Override
    public String getIngredients() {
        return "Pizza with: tomato sauce, cheese, ";
    }
}
