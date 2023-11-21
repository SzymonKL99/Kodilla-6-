package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PeperonisDecorator extends AbstractPizzaOrderDecorator {
    public PeperonisDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(7));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", peperonis";
    }
}
