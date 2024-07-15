package ru.mirea.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAuthor {

    @Test
    public void testGetName() {
        Author author = new Author("John Doe", "johndoe@example.com", 'M');
        assertEquals("John Doe", author.getName());
    }

    @Test
    public void testGetEmail() {
        Author author = new Author("Jane Smith", "janesmith@example.com", 'F');
        assertEquals("janesmith@example.com", author.getEmail());
    }

    @Test
    public void testSetEmail() {
        Author author = new Author("Alice Johnson", "alice@example.com", 'F');
        author.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", author.getEmail());
    }

    @Test
    public void testGetGender() {
        Author author = new Author("Bob Brown", "bob@example.com", 'M');
        assertEquals('M', author.getGender());
    }

    @Test
    public void testToString() {
        Author author = new Author("Eve Adams", "eve@example.com", 'F');
        assertEquals("Author [name=Eve Adams, email=eve@example.com, gender=F]", author.toString());
    }
}
