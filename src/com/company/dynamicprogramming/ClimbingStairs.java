package dynamicprogramming;

import java.util.Scanner;

public class ClimbingStairs {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       // int ans = steps(n);
        int arr[] = new int[n+1];
        int ans = climbSteps(n,arr);
        System.out.println(ans);
    }

    private static int climbSteps(int n , int [] arr) {
        arr[0] = 1;
        arr[1] = 1;

        for(int i=2;i<arr.length;i++)
        {
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];

    }

    /* this is similar tio fibonaaci so directly doing bottom up approach to limit the function calls */
    private static int steps(int n) {
        if(n==0)
        {
            return 1;
        }
        if(n<0)
        {
            return 0;
        }
        count = steps(n-1);
        count = count + steps(n-2);
        return count;
    }


}
