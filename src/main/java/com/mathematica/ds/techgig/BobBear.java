package com.mathematica.ds.techgig;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BobBear {

    private static class Salmon implements Comparable{
        double headPosition;
        double tailPosition;
        double length;

        Salmon(double headPosition, double length){
            this.headPosition = headPosition;
            this.length = length;
            this.tailPosition = this.headPosition+length;
        }

        @Override
        public int compareTo(Object obj) {
            Salmon salmon = (Salmon) obj;
            return (int) (this.tailPosition - salmon.tailPosition);
        }
    }


    public static void main(String[] args) throws IOException {
        Instant begin = Instant.now();
        BufferedReader reader = new BufferedReader(new FileReader("G:\\Workspace\\Git_Workspace\\DataStructureAlgorithmInJava\\src\\main\\java\\com\\mathematica\\ds\\techgig\\bob_test_data1.txt"));
        String numberOfSalmon = reader.readLine();

        int n = Integer.parseInt(numberOfSalmon);
        Salmon[] salmons = new Salmon[n];

        for(int i = 0; i<n; i++){
            String input = reader.readLine();
            String[] salmonPosition = input.split(",");
            salmons[i] = new Salmon(Double.parseDouble(salmonPosition[0]), Double.parseDouble(salmonPosition[1]));
        }

        Arrays.sort(salmons);

        PriorityQueue<Integer> numberOfSalmonOnEachSelection = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println(getMaxSalmonCaughtByBob(salmons, numberOfSalmonOnEachSelection));
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

        int countFishCaughtByBob = 0;
        int chances = 0;
        if(numberOfSalmonOnEachSelection.size() > 1){
            while(chances != 2){
                chances += 1;
                countFishCaughtByBob += numberOfSalmonOnEachSelection.poll();
            }
        }else if(numberOfSalmonOnEachSelection.size() == 1){
            countFishCaughtByBob = numberOfSalmonOnEachSelection.poll();
        }

        return countFishCaughtByBob;
    }
}
