package dynamicprogramming;

import java.util.Scanner;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        int ans = minimunDifferenceRecursion(arr,n);
        int ans2 = minimunDifferenceTabulation(arr,n);
        System.out.println(ans);
        System.out.println(ans2);
    }

    private static int minimunDifferenceTabulation(int[] arr, int n) {
        int sum = 0;
        for(int i : arr)
        {
            sum = sum+i;
        }
        boolean dp[][] = new boolean[n+1][sum+1];
        tabulationHelper(arr,n,sum,dp);

        for(int j=sum/2;j>=0;j--)
        {
            if(dp[arr.length][j])
            {
                return sum - 2*j;
            }
        }
        return -1;
    }

    private static void tabulationHelper(int[] arr, int n, int sum , boolean[][] dp) {
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
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    private static int minimunDifferenceRecursion(int[] arr, int n) {
        int sum = 0;
        for(int i : arr)
        {
            sum = sum+i;
        }
        for(int i=sum/2;i>=0;i--)
        {
            if(subsetSum(arr,n,i))
            {
                return sum - 2*i;
            }
        }
        return -1;
    }

    private static boolean subsetSum(int[] arr, int n, int sum) {
        if(n==0)
        {
            if(sum==0)
            {
                return true;
            }
            else {
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
