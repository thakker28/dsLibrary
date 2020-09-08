package dynamicprogramming;

import java.util.Scanner;

public class MaximumSizedSquaresOf1s {
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
    int area = maxAreaOfSquares(arr,n,m);
    System.out.println(area*area);
  }

  private static int maxAreaOfSquares(int[][] arr, int n, int m) {
   int dp[][] = new int[n][m];
   int maxSideLength = 0;

   for(int i=n-1,j=0;j<m;j++)
   {
     dp[i][j] = arr[i][j];
     if(maxSideLength<dp[i][j]){
       maxSideLength = dp[i][j];
     }
   }
   for(int i=0,j=m-1;i<n-1;i++){
     dp[i][j] = arr[i][j];
     if(maxSideLength<dp[i][j]){
       maxSideLength = dp[i][j];
     }
   }

   for(int i=n-2;i>=0;i--)
   {
     for(int j= m-2;j>=0;j--)
     {
       if(arr[i][j] != 0){
         dp[i][j] = 1 +Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1])); // dp[i+1][j] :
         // bottom , dp[i][j+1] : right  , dp[i+1][j+1] : diagonal element contributing to sqaure
       }
       if(dp[i][j]>maxSideLength){
         maxSideLength = dp[i][j];
       }
     }
   }
   return maxSideLength;
  }


}

