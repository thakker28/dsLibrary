package dynamicprogramming;

import java.util.Scanner;

public class CountSubsetSum {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i=0;
        int arr[] = new int[n];
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        int sum = scanner.nextInt();
        count  = countSubset(arr,n,sum,0);
        int ans = countSubsetTablulation(arr,n,sum);
        System.out.println(count);
        System.out.println(ans);
    }

    private static int countSubsetTablulation(int[] arr, int n, int sum) {

        int dp[][] = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int j=1;j<dp[0].length;j++)
        {
            dp[0][1] = 0;
        }
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0] = 1;
        }

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
        return dp[n][sum];
    }

    private static int countSubset(int[] arr, int n, int sum, int count) {
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
            count = count +countSubset(arr,n-1,sum-arr[n-1], count);
            count = count + countSubset(arr,n-1,sum, 0);
            return count;
        }
        else
        {
           return countSubset(arr,n-1,sum, 0);
        }
       // return count;
    }
}
