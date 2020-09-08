package dynamicprogramming;

import java.util.Scanner;

/* This problem is exactly same as unbounded knapsack */
public class RodCuttingProblem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int price[] = new int[n];
    int i = 0;
    while(i<n)
    {
      price[i] = scanner.nextInt();
      i++;
    }
    int length[] = new int[n];
    for(i=1;i<=n;i++)
    {
      length[i-1] = i;
    }
    int ans1 = maxProfitByCuttingRodRecursion(length,price,n,n);
    System.out.println(ans1);
    int dp[][] = new int[n+1][n+1];
    int ans2 = maxProfitByCuttingRodMemoization(length,price,n,n,dp);
    System.out.println(ans2);
    int ans3 = maxProfitByCuttingRodTabulation(length,price,n,n);
    System.out.println(ans3);
  }

  private static int maxProfitByCuttingRodTabulation(int[] length, int[] price, int n,
                                                     int rodLength) {
    int dp[][] = new int[n+1][n+1];
    for(int i =1;i<dp.length;i++)
    {
      for(int j = 1;j<dp[i].length;j++)
      {
        if(length[i-1]<=j)
        {
          dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
        }
        else
        {
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    return dp[n][rodLength];
  }

  private static int maxProfitByCuttingRodMemoization(int[] length, int[] price, int n, int rodLength, int[][] dp) {
    if(n==0 || rodLength==0)
    {
      return 0;
    }

    if(dp[n][rodLength]>0)
    {
      return dp[n][rodLength];
    }

    if(length[n-1]<=rodLength)
    {
      int x1 = price[n-1] + maxProfitByCuttingRodRecursion(length,price,n,rodLength-length[n-1]);
      int x2 = maxProfitByCuttingRodRecursion(length,price,n-1,rodLength);
      return dp[n][rodLength] = Math.max(x1,x2);

    }
    else
    {
      return dp[n][rodLength]=maxProfitByCuttingRodRecursion(length,price,n-1,rodLength);
    }
  }

  private static int maxProfitByCuttingRodRecursion(int[] length, int[] price, int n,
                                                    int rodLength) {

    if(n==0 || rodLength==0)
    {
      return 0;
    }


    if(length[n-1]<=rodLength)
    {
      int x1 = price[n-1] + maxProfitByCuttingRodRecursion(length,price,n,rodLength-length[n-1]);
      int x2 = maxProfitByCuttingRodRecursion(length,price,n-1,rodLength);
      return Math.max(x1,x2);
    }
    else
    {
      return maxProfitByCuttingRodRecursion(length,price,n-1,rodLength);
    }
  }
}
