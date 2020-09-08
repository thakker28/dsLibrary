package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartRobber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int t = scanner.nextInt();
        while(t>0)
        {
            int n = scanner.nextInt();
            int arr[] = new int[n];
            int i = 0;
            while(i<n)
            {
                arr[i] = scanner.nextInt();
                i++;
            }
           // list.add(maxAmount(0,0,arr));
           // list.add(maxAmount2(0,0,arr,new int[n+1]));
            list.add(maxAmount3(n,arr));
            t--;
        }
        for(int a : list)
        {
            System.out.println(a);
        }
    }

    private static int maxAmount3(int n, int[] arr) {
        int ans[] = new int[arr.length+1];
        ans[0] = arr[0];
        ans[1] = Math.max(arr[0],arr[1]);
        int i;
        for(i=2;i<arr.length;i++)
        {
            ans[i] = Math.max(arr[i]+ans[i-2] , ans[i-1]);
        }
        return ans[n-1];

    }

    private static int maxAmount2(int i, int sum, int[] arr, int[] dp) {
        if(i==arr.length-1)
        {
            return sum + arr[i];
        }
        if(i==arr.length-2)
        {
            return sum + Math.max(arr[i],arr[i+1]);
        }
        if(dp[i]>0)
        {
            return dp[i];
        }

        int x1 = maxAmount(sum+arr[i],i+2,arr);
        int x2 = maxAmount(sum,i+1,arr);
        dp[i] =  Math.max(x1,x2);
        return Math.max(x1,x2);

    }

    private static int maxAmount(int sum, int i, int[] arr) {
        if(i==arr.length-1)
        {
            return sum + arr[i];
        }
        if(i==arr.length-2)
        {
            return sum + Math.max(arr[i],arr[i+1]);
        }
        int x1 = maxAmount(sum+arr[i],i+2,arr);
        int x2 = maxAmount(sum,i+1,arr);
        return Math.max(x1,x2);
    }
}
