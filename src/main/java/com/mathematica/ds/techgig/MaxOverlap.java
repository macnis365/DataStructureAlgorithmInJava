package com.mathematica.ds.techgig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
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
        Instant begin = Instant.now();

        try (BufferedReader reader = new BufferedReader(new FileReader("G:\\Workspace\\Git_Workspace\\DataStructureAlgorithmInJava\\src\\main\\java\\com\\mathematica\\ds\\techgig\\bob_test_data1.txt"))) {
            String numberOfSalmon = reader.readLine();
            int n = Integer.parseInt(numberOfSalmon);
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                String input = reader.readLine();
                String[] salmonPosition = input.split(",");
                start[i] = Integer.parseInt(salmonPosition[0]);
                end[i] = start[i] + Integer.parseInt(salmonPosition[1]);
            }

            int[] attemp1 = maxOverlapSalmons(start, end, -1);
            int[] attemp2 = maxOverlapSalmons(start, end, attemp1[0]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        int n = 13;
//        int start[] = {3, 5, 5, 6, 7, 7, 9, 9, 9, 6, 2, 4, 1};
//        int end[] = {4, 6, 6, 7, 8, 8, 10, 10, 10, 8, 6, 9, 10};
        Instant terminate = Instant.now();
        System.out.println("task took " + Duration.between(begin, terminate).getSeconds() + " second");
    }

    private static int[] maxOverlapSalmons(int[] start, int[] end, int intersection) {
        int maxArrivalTime = Arrays.stream(start).max().getAsInt();
        int maxDepartureTime = Arrays.stream(end).max().getAsInt();
        int auxilaryArrayLength = (int) Math.max(maxArrivalTime, maxDepartureTime);
        int auxilaryArray[] = new int[auxilaryArrayLength + 2];

        for (int index = 0; index < start.length; index++) {
            if (intersection < 0 || !(start[index] <= intersection && intersection <= end[index])) {
                ++auxilaryArray[start[index]];
                --auxilaryArray[end[index] + 1];
            }
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
        System.out.println("Time of intersection is " + idx + " and max overlap are " + maxOverlap);
        return new int[]{idx, maxOverlap};
    }
}
