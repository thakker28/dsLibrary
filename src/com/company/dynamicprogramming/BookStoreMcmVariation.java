package dynamicprogramming;

import java.util.Scanner;

public class BookStoreMcmVariation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n+2];
    arr[0]=arr[n+1]=1;
    for(int i=1;i<=n;i++){
      arr[i] = scanner.nextInt();
    }
    int dp[][] = new int[n+2][n+2];
    for(int i=0;i<dp.length;i++){
      for(int j=0;j<dp[i].length;j++){
        dp[i][j] = -1;
      }
    }
    int ans = maxCost(arr,0,n+1,dp);
    System.out.println(ans);
  }

  private static int maxCost(int[] arr ,int i , int j,int dp[][]) {
    if(j-1<=0){
      return 0;
    }

    if(dp[i][j]!= -1){
      return dp[i][j];
    }

    int ans = 0;
    for(int k=i+1;k<j;k++){
      int temp1 = maxCost(arr,i,k,dp);
      int temp2 = maxCost(arr,k,j,dp);
      int total = temp1 + temp2 + arr[i]*arr[k]*arr[j];
      if(total>ans){
        dp[i][j] = ans = total;
      }
    }
    return ans;
  }
}
