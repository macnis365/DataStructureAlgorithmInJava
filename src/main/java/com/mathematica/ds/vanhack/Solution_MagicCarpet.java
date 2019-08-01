package com.mathematica.ds.vanhack;

import java.util.List;

public class Solution_MagicCarpet {

    public int makeRoundTrip(List<Integer> magic, List<Integer> dist) {
        int maxSteps = magic.size() - 1;
        int start = 0;
        int end = magic.size() - 1;
        int currentPower = 0;
        int index = 0;
        boolean roundTrip;

        while (start < maxSteps) {
            currentPower += magic.get(index);
            int distance = dist.get(index);
            if (currentPower >= distance) {
                currentPower -= distance;
                index++;
                roundTrip = true;
            } else {
                start++;
                end = start - 1;
                index = start;
                currentPower = 0;
                roundTrip = false;
            }

            if (start > end && index == maxSteps) {
                index = 0;
            }

            if (currentPower >= 0 && start > end && roundTrip && index == start) {
                return start;
            }

            if (currentPower >= 0 && start < end && index > end) {
                return start;
            }
        }
        return -1;
    }

}
