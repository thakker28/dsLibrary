package arraysandstrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyAndSellStockAllCases {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while(i<n)
        {
            arr[i] =scanner.nextInt();
            i++;
        }
        System.out.println(maxProfitAnyNumberOfTransactions(arr));
       // System.out.println(maxProfitAtmostOneTransactions(arr));
      // System.out.println(maxProfitAtmostTwoTransactions(arr));
    }

    private static int maxProfitAtmostTwoTransactions(int[] arr) {
        int b1 = Integer.MIN_VALUE, profit1 = 0;
        int b2 = Integer.MIN_VALUE, profit2 = 0;

        for (int i = 0; i < arr.length; i++){
            int cur = arr[i];
            b1 = Math.max(b1, -cur); // -6 -4 -1 -1 0 0
            profit1 = Math.max(profit1, b1 + cur); //0 0 0 6 6 6
            b2 = Math.max(b2, profit1 - cur); // -6 -4 -1 -1 6 6
            profit2 = Math.max(profit2, b2 + cur); // 0 0 0 6 6 11
        }
        return profit2;


        /* Another approach for atmost 2 transactions :

        int min = Integer.MAX_VALUE;
        int max = 0;
        int current  = 0;
        int maxArr[] = new int[arr.length];
        for(int i =0; i<arr.length;i++)
        {
            if(min>arr[i])
            {
                min = arr[i];
            }
            else
            {
                current = arr[i] - min;
                if(current>max)
                {
                    max = current;
                }
            }
            maxArr[i] = max;
        }


        int totalProfit = max;
         max = Integer.MIN_VALUE;
        current = 0;
        for(int i=arr.length-1;i>0;i--)
        {
            if(max<arr[i])
            {
                max = arr[i];
            }
         else
         {
            current = max - arr[i] + maxArr[i-1];
             if(current>totalProfit)
             {
                 totalProfit = current;
             }
         }
        }
        return totalProfit;

         */
    }

    private static int maxProfitAtmostOneTransactions(int[] arr) {
        if(arr.length==0)
        {
            return 0;
        }
        List<Integer> valley = new ArrayList();
        List<Integer> peak = new ArrayList();
        int ans =0;
        int  i =0;
        while(i<arr.length-1)
        {
            while(i<arr.length-1 && arr[i]>=arr[i+1])
            {
                i++;
            }
            valley.add(arr[i]);
            while(i<arr.length-1 && arr[i]<=arr[i+1])
            {
                i++;
            }
            peak.add(arr[i]);
            i++;
            //  ans = Math.max(ans, peak - valley);
        }
        for(i=0;i<valley.size();i++)
        {
            for(int j=i;j<peak.size();j++)
            {
                ans = Math.max(peak.get(j)-valley.get(i),ans);
            }
        }
        return ans;

        /* A much better approach
        if(prices.length <= 1)
            return 0;
        int maxProfit = 0, min = prices[0];
        for(int i = 0; i < prices.length; i++) {
            int profit = prices[i] - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
        */
    }

    private static int maxProfitAnyNumberOfTransactions(int[] arr) {
        int valley = arr[0];
        int peak = arr[0];
        int ans =0;
        int  i =0;
        while(i<arr.length-1)
        {
            while(i<arr.length-1 && arr[i]>=arr[i+1])
            {
                i++;
            }
            valley = arr[i];
            while(i<arr.length-1 && arr[i]<=arr[i+1])
            {
                i++;
            }
            peak = arr[i];
            ans = ans + peak - valley;
        }
        return ans;

    }
    }

