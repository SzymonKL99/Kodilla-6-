package com.kodilla.patterns2.adapter.bookclassifie;

import com.kodilla.patterns2.adapter.bookclassifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void testPublicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author1", "Title1", 2000, "Signature1"));
        bookSet.add(new Book("Author2", "Title2", 1995, "Signature2"));
        bookSet.add(new Book("Author3", "Title3", 2010, "Signature3"));

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2000, median);

    }
}
