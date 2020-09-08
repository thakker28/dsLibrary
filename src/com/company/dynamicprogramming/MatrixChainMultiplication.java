package dynamicprogramming;

import java.util.Scanner;

public class MatrixChainMultiplication {
  private static int minCost = Integer.MAX_VALUE;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i = 0;
    while (i<n)
    {
      arr[i] = scanner.nextInt();
      i++;
    }
    int minMultiplications = mcm(arr,0,arr.length-2);
    int dp[][] = new int[arr.length-1][arr.length-1];
    int ans = mcmTabulation(arr,0,arr.length-2,dp);
    int ans2 = mcmRecursion(arr,1,arr.length-1);
    System.out.println(ans2);
    System.out.println(minMultiplications);
    System.out.println(ans);
  }

  /* Initializing k to i+1 and then dividing it: Matrix calculated as a[i-1]*a[i]*/
  private static int mcmRecursion(int[] arr, int i, int j) {
    if(i>=j)
    {
      return 0;
    }

    int minCost = Integer.MAX_VALUE;
    for(int k=i+1;k<=j;k++)
    {
      int temp1 = mcmRecursion(arr,i,k-1);
      int temp2 = mcmRecursion(arr,k,j);
      int total = temp1+temp2+arr[i-1]*arr[k-1]*arr[j];

      if(minCost>total)
      {
        minCost = total;
      }
    }
    return minCost;
  }

  private static int mcmTabulation(int[] arr, int left, int right, int[][] dp) {
    if(left>=right)
    {
      return 0;
    }
    int minCost = Integer.MAX_VALUE;
    if(dp[left][right]>0)
    {
      return dp[left][right];
    }

    for(int k= left;k<=right;k++)
    {
      int tempAns1 = mcmTabulation(arr,left,k,dp);
      int tempAns2 = mcmTabulation(arr,k+1,right,dp);
      int totalMultiplications = tempAns1+tempAns2+arr[left]*arr[k+1]*arr[right+1];

      if(minCost>totalMultiplications){
        dp[left][right] = minCost = totalMultiplications;
      }

    }
    return minCost;
  }

  private static int mcm(int[] arr, int left, int right) {
    if(left>=right)
    {
      return 0;
    }

    int minCost = Integer.MAX_VALUE;

    for(int k=left;k<right;k++)
    {
      int tempAns = mcm(arr,left,k) + mcm(arr,k+1,right) + (arr[left]*arr[k+1]*arr[right+1]);

      if(minCost>tempAns)
      {
        minCost = tempAns;
      }

    }


return minCost;

  }
}
