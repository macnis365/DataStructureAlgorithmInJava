package com.mathematica.ds.queue;

import org.testng.annotations.Test;

public class DownToZeroTest {

    @Test
    public void testFindFactorPairOf(){
        System.out.println("factor for 24 is "+ DownToZero.findOptimalFactorOf(24));
        System.out.println("factor for 16 is "+ DownToZero.findOptimalFactorOf(16));
        System.out.println("factor for 5 is "+ DownToZero.findOptimalFactorOf(5));
        System.out.println("factor for 4 is "+ DownToZero.findOptimalFactorOf(4));
    }

    @Test
    public void testNumberOfMovesToZero(){
        DownToZero downToZero = new DownToZero();
        System.out.println(downToZero.numberOfMovesToZero(167975));
    }
}
