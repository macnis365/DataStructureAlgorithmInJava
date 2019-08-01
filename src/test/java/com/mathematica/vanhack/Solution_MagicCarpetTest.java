package com.mathematica.vanhack;

import com.mathematica.ds.vanhack.Solution_MagicCarpet;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution_MagicCarpetTest {

    @Test
    public void testMagicCarpetPositive(){
        List magic = Arrays.asList(new Integer[]{2,4,5,2});
        List distance = Arrays.asList(new Integer[]{4,3,1,3});
        Solution_MagicCarpet solution_magicCarpet = new Solution_MagicCarpet();
        int output = solution_magicCarpet.makeRoundTrip(magic, distance);
        System.out.println(output);
        Assert.assertEquals(1, output);
    }

    @Test
    public void testMagicCarpetNegative(){
        List magic = Arrays.asList(new Integer[]{8,4,1,9});
        List distance = Arrays.asList(new Integer[]{10,9,3,5});
        Solution_MagicCarpet solution_magicCarpet = new Solution_MagicCarpet();
        int output = solution_magicCarpet.makeRoundTrip(magic, distance);
        System.out.println(output);
        Assert.assertEquals(-1, output);
    }
}
