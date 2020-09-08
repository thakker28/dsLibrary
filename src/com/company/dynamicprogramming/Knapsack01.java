package dynamicprogramming;

import java.util.Scanner;

public class Knapsack01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int weight[] = new int[n];
        int price[] = new int[n];
        int i = 0;
        while (i < n) {
            weight[i] = scanner.nextInt();
            i++;
        }
        i = 0;
        while (i < n) {
            price[i] = scanner.nextInt();
            i++;
        }

        int capacity = scanner.nextInt();
        //  int ans = maxProfit(weight,price,capacity,0);

        int dp[][] = new int[n + 1][capacity + 1];

        for (i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = maxProfit2(weight, price, capacity, 0, dp);
        ans = maxprofit3(weight, price, capacity, 0);
        System.out.println(ans);
    }


   /* BOTTOM-UP APPROACH OR TABULATION */
    private static int maxprofit3(int[] weight, int[] price, int capacity, int index) {

        int dp[][] = new int[weight.length + 1][capacity + 1];
        for (int j = 0; j < dp[0].length; j++) {
            dp[weight.length][j] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j < dp[i].length; j++) {
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(price[i] + dp[i + 1][j - weight[i]], dp[i + 1][j]);
                } else {
                    dp[i][j] = dp[i + 1][j];
                }

            }
        }
        return dp[0][capacity];
    }


    /*TOP- DOWN APPROACH OR MEMOIZATION */
    private static int maxProfit2(int[] weight, int[] price, int capacity, int index, int[][] dp) {
        if (index == weight.length || capacity == 0) {
            return 0;
        }

        if (dp[index][capacity] > -1) {
            return dp[index][capacity];
        }

        if (weight[index] <= capacity) {
            int x1 = price[index] + maxProfit2(weight, price, capacity - weight[index], index + 1, dp);
            int x2 = maxProfit2(weight, price, capacity, index + 1, dp);
            dp[index][capacity] = Math.max(x1, x2);
            return Math.max(x1, x2);
        } else {
            dp[index][capacity] = maxProfit(weight, price, capacity, index + 1);
            ;
            return dp[index][capacity];
        }
    }


    /* RECURSION SOLUTION */
    private static int maxProfit(int[] weight, int[] price, int capacity, int index) {

        if (index == weight.length || capacity == 0) {
            return 0;
        }

        if (weight[index] <= capacity) {
            int x1 = price[index] + maxProfit(weight, price, capacity - weight[index], index + 1);
            int x2 = maxProfit(weight, price, capacity, index + 1);
            return Math.max(x1, x2);
        } else {
            return maxProfit(weight, price, capacity, index + 1);
        }
    }
}
