package dynamicprogramming;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n+1];
        int ans2 = fib2(n,arr);
        int ans3 = fib3(n,arr);
        int ans = fib(n);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans);
    }

   /* Bottom up approach */
    private static int fib3(int n, int[] arr) {
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<arr.length;i++)
        {
            arr[i] = arr[i-1] +arr[i-2];
        }
        return arr[n];

    }


    /*  Top down approach.. Chcking for n then going down till 1, so for the first case there won't be any value for n then n-1
    and so on. Eventually we will get the value for n=1 and then we have to go back again. So to avoid moving in both directions,
    bottom up approach is preferred wherein we start from bottom and fill the elements starting from index 0.
     */
    private static int fib2(int n , int [] arr ) {
        if(n==0 || n==1)
        {
            return 1;
        }
        if(arr[n]>0)
        {
            return arr[n];
        }
        int x1 = fib2(n-1 ,arr);
        int x2 = fib2(n-2,arr);
        arr[n] = x1+x2;
        return x1+x2;
    }

    private static int fib(int n) {
        if(n==0 || n==1)
        {
            return 1;
        }
        int x1 = fib(n-1);
        int x2 = fib(n-2);
        return x1+x2;
    }
}
