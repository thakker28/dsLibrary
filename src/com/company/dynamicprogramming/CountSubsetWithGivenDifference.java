package dynamicprogramming;

import java.util.Scanner;

public class CountSubsetWithGivenDifference {
    private static int count =0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int arr[] = new int[n];
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        int difference = scanner.nextInt();
        int ans = subsetWithDifferenceRecursion(arr,n,difference);
        int ans2 = subsetWithDifferenceTabulation(arr,n,difference);
        System.out.println(ans);
        System.out.println(ans2);
    }

    private static int subsetWithDifferenceTabulation(int[] arr, int n, int difference) {
        int sum = 0;
        for(int i = 0;i<arr.length;i++)
        {
            sum = sum+arr[i];
        }
        if((sum+difference)%2 !=0)
        {
            return 0;
        }

        return countSubsetTabulation(arr,n,(sum+difference)/2);
    }

    private static int countSubsetTabulation(int[] arr, int n, int sum) {
        int dp[][] = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int j=1;j<dp[0].length;j++)
        {
            dp[0][j]=0;
        }
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    /* We need to find 2 subsets such that s1-s2=difference, s1+s2=sumOfArray , therfore if we can find subset with
            sum = sumOfArray-differnce/2 will solve the problem.

     */
    private static int subsetWithDifferenceRecursion(int[] arr, int n, int difference) {
        int sum = 0;
        for(int i = 0;i<arr.length;i++)
        {
            sum = sum+arr[i];
        }

        if((sum+difference)%2 !=0)
        {
            return 0;
        }
        return countSubset(arr,n,(sum+difference)/2);
    }

    private static int countSubset(int[] arr, int n, int sum) {
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

        if(arr[n-1]<=sum)
        {
            countSubset(arr,n-1,sum-arr[n-1]);
            countSubset(arr,n-1,sum);
            return count;
        }
        else
        {
            countSubset(arr,n-1,sum);
        }
        return count;
    }
}
