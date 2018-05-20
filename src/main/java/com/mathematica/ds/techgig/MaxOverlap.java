package com.mathematica.ds.techgig;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxOverlap {

    private static class Salmon {
        double headPosition;
        double tailPosition;
        double length;

        Salmon(double headPosition, double length) {
            this.headPosition = headPosition;
            this.length = length;
            this.tailPosition = this.headPosition + length;
        }

        /*@Override
        public int compareTo(Object obj) {
            Salmon salmon = (Salmon) obj;
            return (int) (this.tailPosition - salmon.tailPosition);
        }*/

        @Override
        public String toString() {
            return this.headPosition + ", " + this.tailPosition;
        }
    }


    public static void main(String args[]) {

        int n = 13;
        int start[] = {3, 5, 5, 6, 7, 7, 9, 9, 9, 6, 2, 4, 1};
        int end[] = {4, 6, 6, 7, 8, 8, 10, 10, 10, 8, 6, 9, 10};
        ArrayList<Salmon> salmons = new ArrayList<Salmon>();
        for (int index = 0; index < n; index++) {
            salmons.add(new Salmon(start[index], end[index] - start[index]));
        }

        int[] attemp1 = maxOverlapSalmons(start, end);
//        int[] attemp2 = maxOverlapSalmons(start, end, attemp1[0]);
    }

    private static int[] maxOverlapSalmons(int[] start, int[] end) {
        int maxArrivalTime = Arrays.stream(start).max().getAsInt();
        int maxDepartureTime = Arrays.stream(end).max().getAsInt();
        int auxilaryArrayLength = Math.max(maxArrivalTime, maxDepartureTime);
        int auxilaryArray[] = new int[auxilaryArrayLength+2];
//        Arrays.fill(auxilaryArray, 0);
        for (int index = 0; index < start.length; index++) {
            ++auxilaryArray[start[index]];
            --auxilaryArray[end[index] + 1];
        }
        int maxOverlap = Integer.MIN_VALUE;
        int idx = 0, currentMax = 0;
        for (int i = 0; i <= auxilaryArrayLength; i++) {
            currentMax += auxilaryArray[i];
            if (maxOverlap < currentMax) {
                maxOverlap = currentMax;
                idx = i;
            }
        }
        System.out.println("Time of intersection is "+idx+" and max overlap are "+maxOverlap);
        return new int[]{idx, maxOverlap};
    }
}
