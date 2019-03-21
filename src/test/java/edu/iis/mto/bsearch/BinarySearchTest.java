package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void searchSucceedsWhenLength1() {
        int[] seq = { 0 };
        int key = 0;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(key, seq[searchResult.getPosition()]);
    }

    @Test
    public void searchFailsWhenLength1() {
        int[] seq = { 0 };
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}
