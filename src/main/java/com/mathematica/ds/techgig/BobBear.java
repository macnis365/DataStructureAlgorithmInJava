package com.mathematica.ds.techgig;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BobBear {

    private static class Salmon implements Comparable{
        int headPosition;
        int tailPosition;
        int length;

        Salmon(int headPosition, int length){
            this.headPosition = headPosition;
            this.length = length;
            this.tailPosition = this.headPosition+length;
        }

        public int getHeadPosition() {
            return headPosition;
        }

        public int getTailPosition() {
            return tailPosition;
        }

        public int getLength() {
            return length;
        }

        @Override
        public int compareTo(Object obj) {
            Salmon salmon = (Salmon) obj;
            return this.tailPosition - salmon.tailPosition;
        }
    }


    public static void main(String[] args) throws IOException {
        Instant begin = Instant.now();

        int numberOfSalmon = 5;
        int[]  len = {2, 4, 4, 2, 4};
        int[] start = {1, 4, 1, 6, 4};

        Salmon[] salmons = new Salmon[numberOfSalmon];

        for(int i = 0; i<numberOfSalmon; i++){
            salmons[i] = new Salmon(start[i], len[i]);
        }

        Arrays.sort(salmons);

        PriorityQueue<Integer> numberOfSalmonOnEachSelection = new PriorityQueue<>();
        getMaxSalmonCaughtByBob(salmons, numberOfSalmonOnEachSelection);
        Instant end = Instant.now();
        System.out.println("task took "+Duration.between(begin, end).getSeconds()+" second");
    }

    private static int getMaxSalmonCaughtByBob(Salmon[] salmons, PriorityQueue<Integer> numberOfSalmonOnEachSelection) {

        int i = 0, k =i;
        while(k<salmons.length){
            int count = 1;
            int j = k + 1;
            while(j<salmons.length && salmons[j].headPosition <= salmons[k].tailPosition){
                count += 1;
                j++;
            }
            numberOfSalmonOnEachSelection.add(count);
            count = 0;
            k = j;
        }

        for (int value : numberOfSalmonOnEachSelection ) {
            System.out.println("max is "+value);
        }
        return 0;
    }
}
