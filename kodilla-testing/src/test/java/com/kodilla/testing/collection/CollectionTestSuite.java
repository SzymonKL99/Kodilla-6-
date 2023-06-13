package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;
import com.kodilla.testing.collection.OddNumbersExterminator;
import java.util.*;
import org.junit.jupiter.api.Assertions;
public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        //When
        List<Integer> listNumbers = OddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing" + listNumbers);
        //Then
        Assertions.assertEquals(emptyList, listNumbers);
    }

    @DisplayName("checks that the class behaves correctly when the list is empty"
    )
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(236, 445, 42, 87, 18, 29, 3, 99));
        ArrayList<Integer> oddList = new ArrayList<Integer>(Arrays.asList(236, 42, 18));

        //When
        List<Integer> listNumbers = OddNumbersExterminator.exterminate(list);
        System.out.println("Testing" + listNumbers);
        //Then
        Assertions.assertEquals(oddList, listNumbers);
    }
}




