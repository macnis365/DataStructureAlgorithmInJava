package com.mathematica.ds.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DownToZero {

    public DownToZero() {
        tableOfMoves = new ArrayList<Integer>(1000001);
        for (int i = 0; i < 1000001; i++) {
            tableOfMoves.add(i, 0);
        }
    }

    static List<Integer> tableOfMoves;

    public static int numberOfMovesToZero(Integer number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        if (number == 2) return 2;

        if (0 != tableOfMoves.get(number)) {
            return tableOfMoves.get(number);
        }

        int currentOptimalFactor = findOptimalFactorOf(number);
        if (currentOptimalFactor == 1) {
            tableOfMoves.add(number, 1 + numberOfMovesToZero(number - 1));
        } else {
            tableOfMoves.add(number, 1 + numberOfMovesToZero(currentOptimalFactor));
        }

        return tableOfMoves.get(number);
    }

    public static int findOptimalFactorOf(Integer number) {
        Integer minimumFactor = Integer.MAX_VALUE;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                int reminder = number / i;
                int divisor = i;
                System.out.println("pair of factor ("+reminder+" ,"+divisor+")");
                minimumFactor = Math.min(minimumFactor, Math.max(reminder, divisor));
            }
        }
        return minimumFactor == Integer.MAX_VALUE ? 1 : minimumFactor;
    }
}
