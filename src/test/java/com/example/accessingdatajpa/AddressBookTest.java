package com.example.accessingdatajpa;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressBookTest {

    AddressBook testBook;
    BuddyInfo Yahia;
    BuddyInfo Aleeza;

    @Before
    public void setUp() throws Exception{
        testBook = new AddressBook();
        Yahia = new BuddyInfo("Yahia", "2725 Pimlico Dr", "6138791680");
        Aleeza = new BuddyInfo("Aleeza", "921 Rotary Way", "3432016670");
    }

    @Test
    public void size() {
        assertEquals(0, testBook.size());

        testBook.addBuddy(Aleeza);
        assertEquals(1, testBook.size());
    }

    @Test
    public void clear() {
        testBook.addBuddy(Yahia);
        testBook.addBuddy(Aleeza);
        testBook.clear();

        assertEquals(0, testBook.size());
    }

    @Test
    public void addBuddy() {
        testBook.addBuddy(Yahia);
        assertEquals(1, testBook.size());
    }

    @Test
    public void removeBuddy() {
        testBook.addBuddy(Aleeza);
        testBook.addBuddy(Yahia);
        assertEquals(2, testBook.size());
        testBook.removeBuddy(1);
        assertEquals(1, testBook.size());
    }

    @Test
    public void getBuddy() {
        testBook.addBuddy(Yahia);
        BuddyInfo getBuddyTest = testBook.getBuddy(0);
        assertEquals(getBuddyTest, Yahia);
    }
}