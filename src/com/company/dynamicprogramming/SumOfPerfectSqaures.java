package dynamicprogramming;

import java.util.Scanner;

public class SumOfPerfectSqaures {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int sqrrt = (int) Math.pow(n,0.5);
    int arr[] = new int[sqrrt];
    for(int i=1;i<=sqrrt;i++){
      arr[i-1] = i*i;
    }
    int ans1 = minWays(arr,arr.length,n);
    int ans2 = minWaysWithoutUsingKnapsackApproach(n);
    int ans3 = minWaysWithoutUsingKnapsackApproachTabulation(n);
    int ans4 = minWaysUsingTabulation(arr,arr.length,n);
    System.out.println(ans1);
    System.out.println(ans2);
    System.out.println(ans3);
    System.out.println(ans4);
  }

  private static int minWaysWithoutUsingKnapsackApproachTabulation(int n) {
    int[] dp = new int[n+1];
    dp[0] = 0;

    for(int i=1;i<dp.length;i++){
      int temp = Integer.MAX_VALUE;
      for(int j=1;j*j<=i;j++){
         temp = Math.min(temp,dp[i-j*j]);
      }
      dp[i] = temp +1;
    }
    return dp[n];
  }

  private static int minWaysWithoutUsingKnapsackApproach(int n) {
    if(n==0)
    {
      return 0;
    }
    int ans = Integer.MAX_VALUE;
    for(int i=1;i*i<=n;i++){
      ans = Math.min(ans,minWaysWithoutUsingKnapsackApproach(n-i*i));
    }
    return ans+1;
  }

  private static int minWaysUsingTabulation(int[] arr, int n, int sum) {
   final long dp[][] = new long[n+1][sum+1];
  dp[0][0] = 0;
    for(int i=0,j=1;j<=sum;j++){
      dp[i][j] = Integer.MAX_VALUE-1;
    }

    for(int i=1,j=0;i<=n;i++){
      dp[i][j] = 0;
    }

    for(int i=1;i<dp.length;i++)
    {
      for(int j=1;j<=sum;j++)
      {
        if(arr[i-1]<=j)
        {
          dp[i][j] = Math.min(1+dp[i][j-arr[i-1]],dp[i-1][j]);
        }
        else{
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    return (int)dp[n][sum];
  }

  private static int minWays(int[] arr, int n,int sum) {
    if(n==0 || sum==0){
      if(sum==0)
      return 0;
      else
        return Integer.MAX_VALUE-1;
    }

    if(arr[n-1]<=sum){
      int includeOption = minWays(arr,n,sum-arr[n-1])+1;
      int excludeOption = minWays(arr,n-1,sum);
      return Math.min(includeOption,excludeOption);
    }
    else{
      return minWays(arr,n-1,sum);
    }
  }
}

