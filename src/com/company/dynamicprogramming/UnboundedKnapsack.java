package dynamicprogramming;

import java.util.Scanner;

public class UnboundedKnapsack {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int weights[] = new int[n];
    int prices[] = new int[n];
    int i = 0;
    while(i<n)
    {
      weights[i] = scanner.nextInt();
      i++;
    }
    i = 0;
    while(i<n)
    {
      prices[i] = scanner.nextInt();
      i++;
    }
    int capacity = scanner.nextInt();
    int ans = unboundedKnapsackRecursion(weights,prices,n,capacity);
    int ans2 = unboundedKnapsackTabulation(weights,prices,n,capacity);
    System.out.println(ans);
    System.out.println(ans2);
  }

  private static int unboundedKnapsackTabulation(int[] weights, int[] prices, int n, int capacity) {
    int dp[][] = new int[n+1][capacity+1];
    dp[0][0] = 0;
    for (int i = 1; i<dp.length;i++)
    {
      dp[i][0] = 0;
    }
    for(int j=1 ; j<dp[0].length; j++)
    {
      dp[0][j] = 0;
    }

    for(int i=1;i<dp.length;i++)
    {
      for (int j = 1;j<dp[i].length;j++)
      {
        if(weights[i-1]<=j)
        {
          dp[i][j] = Math.max(prices[n-1]+dp[i-1][j],dp[i][j-weights[i-1]]);
        }
        else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    return dp[n][capacity];
  }

  private static int unboundedKnapsackRecursion(int[] weights, int[] prices, int n, int capacity) {
    if(n==0 || capacity==0)
    {
      return 0;
    }

    if(weights[n-1]<=capacity)
    {
      int x1 = prices[n-1] + unboundedKnapsackRecursion(weights,prices,n,capacity-weights[n-1]);
      int x2 = unboundedKnapsackRecursion(weights,prices,n-1,capacity);
      return Math.max(x1,x2);
    }
    else
    {
      return unboundedKnapsackRecursion(weights,prices,n-1,capacity);
    }
  }
}
