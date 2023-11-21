package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testStandardPizzaOrderGetPrice() {
        //Given
        PizzaOrder thePizza = new StandardPizza();
        //When
        BigDecimal calculatedPrice  = thePizza.getPrice();
        //Then
        assertEquals(new BigDecimal(15), calculatedPrice);
    }
    @Test
    public void testStandardPizzaOrderGetIngredients() {
        //Given
        PizzaOrder thePizza = new StandardPizza();
        //When
        String ingredients = thePizza.getIngredients();
        //Then
        assertEquals("Pizza with: tomato sauce, cheese, ", ingredients);
    }
    @Test
    public void testExtraCheesePizzaOrderGetPrice() {
        //Given
        PizzaOrder thePizza = new StandardPizza();
        thePizza = new ExtraCheeseDecorator(thePizza);
        //When
        BigDecimal thePrice = thePizza.getPrice();
        //Then
        assertEquals(new BigDecimal(19), thePrice);
    }
    @Test
    public void testExtraCheesePizzaOrderGetIngredients() {
        //Given
        PizzaOrder thePizza = new StandardPizza();
        thePizza = new ExtraCheeseDecorator(thePizza);
        //When
        String ingredients = thePizza.getIngredients();
        //Then
        assertEquals("Pizza with: tomato sauce, cheese, extra cheese", ingredients);
    }
    @Test
    public void testAllIngredientsPizzaOrderGetPrice() {
        //Given
        PizzaOrder thePizza = new StandardPizza();
        thePizza = new ExtraCheeseDecorator(thePizza);
        thePizza = new HamDecorator(thePizza);
        thePizza = new MushroomsDecorator(thePizza);
        thePizza = new PeperonisDecorator(thePizza);
        //When
        BigDecimal thePrice = thePizza.getPrice();
        //Then
        assertEquals(new BigDecimal(36), thePrice);
    }
    @Test
    public void testAllIngredientsPizzaOrderGetIngredients() {
        //Given
        PizzaOrder thePizza = new StandardPizza();
        thePizza = new ExtraCheeseDecorator(thePizza);
        thePizza = new HamDecorator(thePizza);
        thePizza = new MushroomsDecorator(thePizza);
        thePizza = new PeperonisDecorator(thePizza);
        //When
        String ingredients = thePizza.getIngredients();
        //Then
        assertEquals("Pizza with: tomato sauce, cheese, extra cheese, ham, mushrooms, peperonis", ingredients);
    }
}

