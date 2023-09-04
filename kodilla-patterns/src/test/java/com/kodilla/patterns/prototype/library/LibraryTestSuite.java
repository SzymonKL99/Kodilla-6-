package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {
    @Test
    void testGetBooks() {
        //Given
        Book book1 = new Book("Za zamknietymi drzwiami", "B.A Paris", LocalDate.of(2016, 12, 13));
        Book book2 = new Book("Wybaczam ci", "Remigiusz Mroz", LocalDate.of(2021, 10, 12));
        Book book3 = new Book("Harry Potter i Czara ognia", "J.K Rowling", LocalDate.of(2000, 11, 22));

        Library library = new Library("Bestsellers");

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Bestsellers 2");
        }catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Bestsellers 3");
        }catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book2);


        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), library.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}