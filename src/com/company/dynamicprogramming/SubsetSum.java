package dynamicprogramming;

import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i =0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        int sum = scanner.nextInt();

        boolean ans = subsetSumRecursion(arr,sum ,0);
        boolean dp[][] = new boolean[n+1][sum+1];
        ans = subsetSumMemoization(arr,sum,0,dp);
        ans = subsetSumTabulation(arr,sum);
        System.out.println(ans);
    }

    private static boolean subsetSumTabulation(int[] arr, int sum) {
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        dp[arr.length][0] = true;
        for(int j=1;j<=sum;j++)
        {
            dp[arr.length][j] = false;
        }

        for(int i=0;i<dp.length;i++)
        {
            dp[i][0] = true;
        }
       for(int i = dp.length-2;i>=0;i--)
       {
           for(int j=1;j<dp[i].length;j++)
           {
               if(arr[i]<=j)
               {
                   dp[i][j] = dp[i+1][j-arr[i]] || dp[i+1][j];
               }
               else {
                   dp[i][j] = dp[i+1][j];
               }

           }
       }
       return dp[0][sum];
    }

    private static boolean subsetSumMemoization(int[] arr, int sum, int index, boolean[][] dp) {
        if(index==arr.length)
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

        if(dp[index][sum] != false)
        {
            return dp[index][sum];
        }

        boolean b1 = subsetSumRecursion(arr,sum-arr[index],index+1);
        boolean b2 = subsetSumRecursion(arr,sum,index+1);
        dp[index][sum]=b1||b2;
        return b1||b2;
    }

    private static boolean subsetSumRecursion(int[] arr, int sum, int index) {
        if(index==arr.length)
        {
            if(sum==0)
            return true;
            else return false;
        }

        if(arr[index]<=sum)
        {
            boolean b1 = subsetSumRecursion(arr,sum-arr[index],index+1);
            boolean b2 = subsetSumRecursion(arr,sum,index+1);
            return b1||b2;
        }
        else
        {
            return subsetSumRecursion(arr,sum,index+1);
        }


    }
}
