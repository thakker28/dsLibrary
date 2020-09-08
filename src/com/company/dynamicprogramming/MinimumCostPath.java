package dynamicprogramming;

import java.util.Scanner;

public class MinimumCostPath {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int arr[][] = new int[n][m];
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        arr[i][j] = scanner.nextInt();
      }
    }
    int cost1 = minPathSumUsingRecursion(arr,n-1,m-1);
    int cost2 = minPathSumUsingTabulation(arr,n,m);
    System.out.println(cost2);
    System.out.println(cost1);
  }

  private static int minPathSumUsingTabulation(int[][] arr, int n, int m) {

    int dp[][] = new int[n][m];
    dp[0][0] = arr[0][0];
    for(int i=1,j=0;i<n;i++){
     dp[i][j] = dp[i-1][j]+arr[i][j];
    }

    for(int i=0,j=1;j<m;j++)
    {
      dp[i][j] = dp[i][j-1]+arr[i][j];
    }

    for(int i=1 ;i<n;i++)
    {
      for(int j=1;j<m;j++){
        dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+arr[i][j];
      }
    }

    return dp[n-1][m-1];
  }

  private static int minPathSumUsingRecursion(int[][] arr, int n, int m) {

    if(n<0 || m<0)
    {
      return Integer.MAX_VALUE;
    }
    if(n==0 && m==0)
    {
      return arr[0][0];
    }



    int topOption = minPathSumUsingRecursion(arr,n-1,m);
    int leftOption = minPathSumUsingRecursion(arr,n,m-1);
    return Math.min(leftOption,topOption)+arr[n][m];
  }
}
