package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setBooks(Set<Book> books) {

        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }
    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }
    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : this.books) {
            clonedLibrary.getBooks().add(new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate()));
        }
        return clonedLibrary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(getName(), library.getName()) && Objects.equals(getBooks(), library.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBooks());
    }

    @Override
    public String toString() {
        return "Library:" + name + "\n" + books;
    }
}