package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    @Test
    public void searchSucceedsWhenLength1() {
        int[] seq = {0};
        int key = 0;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(seq[searchResult.getPosition()], is(key));
    }

    @Test
    public void searchFailsWhenLength1() {
        int[] seq = {0};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test
    public void searchFindsFirstElementWhenLengthOver1() {
        int[] seq = {0, 1, 2, 3};
        int key = 0;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(0));
    }

    @Test
    public void searchFindsLastElementWhenLengthOver1() {
        int[] seq = {0, 1, 2, 4};
        int key = 4;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(seq.length - 1));
    }

    @Test
    public void searchFindsCenterElementWhenLengthOver1() {
        int[] seq = {0, 1, 2, 4, 9};
        int key = 2;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(seq.length / 2));
    }

    @Test
    public void searchFindsCenterRightElementWhenLengthOver1() {
        int[] seq = {0, 1, 2, 4};
        int key = 2;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(seq.length / 2));
    }

    @Test
    public void searchFindsCenterLeftElementWhenLengthOver1() {
        int[] seq = {0, 1, 2, 4};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(seq.length / 2 - 1));
    }

    @Test
    public void searchFailsWhenLengthOver1() {
        int[] seq = {0, 1, 2, 4, 9};
        int key = 100;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchFailsWhenListEmpty() {
        int[] seq = {};
        int key = 100;

        BinarySearch.search(key, seq);
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchFailsWhenListIsNull() {
        int[] seq = null;
        int key = 100;

        BinarySearch.search(key, seq);
    }

    @Test
    public void searchDoesNotModifyInput() {
        int[] seq = {0, 1, 2, 4, 9};
        int[] seqClone = seq.clone();
        int key = 2;

        BinarySearch.search(key, seq);

        assertArrayEquals(seqClone, seq);
    }

    @Test
    public void searchForLargeElementOnlyChecksToTheRight() {
        int[] seq = {9, 9, 0, 1, 2};
        int key = 9;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), is(false));
    }

    @Test
    public void searchForSmallElementOnlyChecksToTheLeft() {
        int[] seq = {1, 2, 3, 0, 0};
        int key = 0;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), is(false));
    }
}
