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

    @Test
    public void searchFindsFirstElementWhenLengthOver1() {
        int[] seq = { 0, 1, 2, 3 };
        int key = 0;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    public void searchFindsLastElementWhenLengthOver1() {
        int[] seq = { 0, 1, 2, 4 };
        int key = 4;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(seq.length - 1, searchResult.getPosition());
    }

    @Test
    public void searchFindsCenterElementWhenLengthOver1() {
        int[] seq = { 0, 1, 2, 4, 9 };
        int key = 2;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(seq.length / 2, searchResult.getPosition());
    }
}
