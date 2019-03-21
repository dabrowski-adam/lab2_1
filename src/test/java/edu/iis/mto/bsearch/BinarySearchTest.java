package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    @Test
    public void searchSucceedsWhenLength1() {
        int[] seq = { 0 };
        int key = 0;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(seq[searchResult.getPosition()], is(key));
    }

    @Test
    public void searchFailsWhenLength1() {
        int[] seq = { 0 };
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test
    public void searchFindsFirstElementWhenLengthOver1() {
        int[] seq = { 0, 1, 2, 3 };
        int key = 0;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(0));
    }

    @Test
    public void searchFindsLastElementWhenLengthOver1() {
        int[] seq = { 0, 1, 2, 4 };
        int key = 4;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(seq.length - 1));
    }

    @Test
    public void searchFindsCenterElementWhenLengthOver1() {
        int[] seq = { 0, 1, 2, 4, 9 };
        int key = 2;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(seq.length / 2));
    }

    @Test
    public void searchFailsWhenLengthOver1() {
        int[] seq = { 0, 1, 2, 4, 9 };
        int key = 100;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchFailsWhenListEmpty() {
        int[] seq = { };
        int key = 100;

        BinarySearch.search(key, seq);
    }
}
