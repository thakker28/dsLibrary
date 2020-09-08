package dynamicprogramming;

import java.util.Scanner;

public class EqualPartitionSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        boolean ans = equalPartitionSubsetRecursion(arr,n);
        ans = equalPartitionSubsetMemoization(arr,n);
        ans = equalPartitionSubsetTabulation(arr,n);
        System.out.println(ans);
    }

    private static boolean equalPartitionSubsetTabulation(int[] arr, int n) {
        int sum = 0;
        for(int i : arr)
        {
            sum = sum + i;
        }
        if(sum%2!=0)
        {
            return false;
        }

        return subsetSumTabulation(arr,n,sum/2);
    }

    private static boolean subsetSumTabulation(int[] arr, int n, int sum) {
        boolean dp[][] = new boolean[n+1][sum+1];
        dp[0][0] = true;
        for(int j=1;j<dp[0].length;j++)
        {
            dp[0][j] = false;
        }
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0] = true;
        }

        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    private static boolean equalPartitionSubsetMemoization(int[] arr, int n) {
        int sum = 0;
        for(int i : arr)
        {
            sum = sum + i;
        }
        if(sum%2!=0)
        {
            return false;
        }
        int dp[][] = new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                dp[i][j] = -1;
            }
        }
        return subsetSumMemoization(arr,n,sum/2,dp);
    }

    private static boolean subsetSumMemoization(int[] arr, int n, int sum, int[][] dp) {
        if(n==0)
        {
            if(sum==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        if(dp[n][sum] != -1)
        {
            if(dp[n][sum]==0)
            {
                return false;
            }
          return true;
        }
        if(arr[n-1]<=sum)
        {
            boolean b1 = subsetSum(arr,n-1,sum-arr[n-1]);
            boolean b2 = subsetSum(arr,n-1,sum);
            dp[n][sum] = b1||b2==true ? 1 :0;
            return b1||b2;
        }
        else
        {
            boolean b = subsetSum(arr,n-1,sum);
            dp[n][sum] = b==true ? 1 : 0;
            return b;
        }
    }

    private static boolean equalPartitionSubsetRecursion(int[] arr, int n) {
        int sum = 0;
        for(int elementValue : arr)
        {
            sum = sum+elementValue;
        }
        if(sum%2 != 0)
        {
            return false;
        }
        return subsetSum(arr,n,sum/2);
    }

    private static boolean subsetSum(int[] arr, int n, int sum) {
        if(n==0)
        {
            if(sum==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        if(arr[n-1]<=sum)
        {
            boolean b1 = subsetSum(arr,n-1,sum-arr[n-1]);
            boolean b2 = subsetSum(arr,n-1,sum);
            return b1||b2;
        }
        else
        {
            return subsetSum(arr,n-1,sum);
        }
    }
}
