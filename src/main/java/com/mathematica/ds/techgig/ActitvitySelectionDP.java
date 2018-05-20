package com.mathematica.ds.techgig;

public class ActitvitySelectionDP {

    static int n = 13;
    static int start[];
    static int end[];
    static int dp[][] = new int[n][n];

    public static void main(String[] args) {
//        ActitvitySelectionDP selectionDP = new ActitvitySelectionDP();
//        start = new int[][]{{3, 4}, {5, 6}, {5, 6}, {6, 7}, {7, 8}, {7, 8}, {9, 10}, {9, 10}, {6, 8}, {2, 6}, {4, 9}, {9, 10}};
        start = new int[]{3, 5, 5, 6, 7, 7, 9, 9, 9, 6, 2, 4, 1};
        end = new int[]{4, 6, 6, 7, 8, 8, 10, 10, 10, 8, 6, 9, 10};
   /*     for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }*/
     System.out.println(solve(0, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static int solve(int index, int currentFinishTime) {
        if (index == n) return 0;
        int v1 = 0, v2 = 0;
        if (dp[index][currentFinishTime] != 0) return dp[index][currentFinishTime];

        v1 = solve(index + 1, currentFinishTime);

        if (start[index] >= currentFinishTime) {
            v2 = solve(index + 1, end[index]) + 1;
        }
        return dp[index][currentFinishTime] = Math.max(v1, v2);
    }
}
