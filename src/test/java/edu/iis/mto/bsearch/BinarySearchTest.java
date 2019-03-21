package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void searchSucceedsInLength1() {
        int[] seq = { 0 };
        int key = 0;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(key, seq[searchResult.getPosition()]);
    }
}
