package dynamicprogramming;

import java.util.Scanner;


/* This problem is similar to count of subset with given difference */
public class TargetSum {
    private static int count = 0;
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
        int sum = scanner.nextInt();

        int ans = targetSumMemoization(arr,n,sum);
        int ans2 = targetSumTabulation(arr,n,sum);
        System.out.println(ans);
        System.out.println(ans2);
    }

    private static int targetSumTabulation(int[] arr, int n, int targetSum) {
        int sumArray = 0;
        for(int element : arr)
        {
            sumArray = sumArray + element;
        }

        if(targetSum>sumArray || (targetSum+sumArray)%2 !=0)
        {
            return 0;
        }

        targetSum = (targetSum+sumArray)/2;
        int dp[][] = new int[n+1][targetSum+1];
        dp[0][0] = 1;
        for(int j = 1;j<dp[0].length;j++)
        {
            dp[0][j] = 0;
        }

        /* didn't initialize for first column to target all zero elements */

        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
return dp[n][targetSum];
    }

    private static int targetSumMemoization(int[] arr, int n, int targetSum) {
        int sumArray = 0;
        for(int element : arr)
        {
            sumArray = sumArray + element;
        }

        if(targetSum>sumArray || (targetSum+sumArray)%2 !=0)
        {
            return 0;
        }

        int dp[][] = new int[n+1][((targetSum+sumArray)/2)+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j =0; j<dp[i].length;j++)
            {
                dp[i][j] = -1;
            }
        }
        return countSubsetMemoization(arr,n,(targetSum+sumArray)/2,dp,0);
    }

    private static int countSubsetMemoization(int[] arr, int n, int sum, int[][] dp,int count) {
        if(n==0)
        {
            if(sum==0)
            {
                count++;
                return count;
            }
            else
            {
                return count;
            }
        }
if(dp[n][sum] != -1)
{
    return dp[n][sum];
}

        if(arr[n-1]<=sum)
        {
            count = count + countSubsetMemoization(arr,n-1,sum-arr[n-1],dp,count);
            count = count + countSubsetMemoization(arr,n-1,sum,dp,0);
            dp[n][sum] = count;
            return dp[n][sum];
        }
        else
        {
            return dp[n][sum] = countSubsetMemoization(arr,n-1,sum,dp,0);
        }

    }
}
