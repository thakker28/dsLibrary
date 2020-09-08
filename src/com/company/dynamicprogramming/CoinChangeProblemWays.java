package dynamicprogramming;

import java.util.Scanner;

public class CoinChangeProblemWays {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int coin[] = new int[n];
    int i = 0;
    while(i<n)
    {
      coin[i] = scanner.nextInt();
      i++;
    }
    int sum = scanner.nextInt();
    int ans1 = numberOfWaysRecursion(coin,sum,n , 0);
    int ans2 = numberOfWaysTabulation(coin,sum,n);
    System.out.println(ans1);
    System.out.println(ans2);
  }

  private static int numberOfWaysTabulation(int[] coin, int sum, int n) {
    int dp[][] = new int[n+1][sum+1];
    dp[0][0] = 1;
    for(int i=0,j=1; j<dp[i].length; j++)
    {
      dp[i][j] = 0;
    }
    for(int i=1,j=0;i<dp.length;i++)
    {
      dp[i][j] = 1;
    }

    for(int i=1;i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(coin[i-1]<=j)
        {
          dp[i][j] = dp[i-1][j] + dp[i][j-coin[i-1]];
        }
        else{
          dp[i][j] = dp[i-1][j];
        }

      }
    }
    return dp[n][sum];
  }

  private static int numberOfWaysRecursion(int[] coin, int sum , int n , int count) {
    if(n==0 || sum==0)
    {
      if(sum==0)
      {
        return count+1;
      }
      else {
        return count;
      }
    }
    if(coin[n-1]<=sum)
    {
      count = numberOfWaysRecursion(coin,sum-coin[n-1],n,count);
      count = numberOfWaysRecursion(coin,sum,n-1,count);
      return count;
    }
    else {
      return numberOfWaysRecursion(coin,sum,n-1,count);
    }

  }
}
