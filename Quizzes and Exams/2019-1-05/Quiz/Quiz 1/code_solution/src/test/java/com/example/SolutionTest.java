package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testSequence(){
        int[] ar = {1,2,3,4,5,6,7,8,9};
        assertEquals(2,Solution.binarySearch(ar,0,ar.length-1,3));
    }
    
    @Test
    public void testMissingTooLarge(){
        int[] ar = {1,2,3,4,5,6,7,8,9};
        assertEquals(-1,Solution.binarySearch(ar,0,ar.length-1,11));
    }
    
    @Test
    public void testSingletonArray(){
        int[] ar = {1};
        assertEquals(0,Solution.binarySearch(ar,0,ar.length-1,1));
    }
    
    @Test
    public void testEmptyArray(){
        int[] ar = {};
        assertEquals(-1,Solution.binarySearch(ar,0,ar.length-1,1));
    }
    
    @Test
    public void testSequenceOutOfOrder(){
        int[] ar = {9,8,7,6,5,4,3,2,1};
        assertEquals(-1,Solution.binarySearch(ar,0,ar.length-1,3));
    }
}