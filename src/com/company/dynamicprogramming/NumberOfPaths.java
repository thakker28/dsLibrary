package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfPaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Integer> ans = new ArrayList<>();
        while(t>0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int arr[][] = new int[n+1][m+1];
            int arr1[][] = new int[n][m];
           // ans.add(paths1(n,m,arr));
            ans.add(paths2(n,m,arr1));
            //ans.add(paths(n,m));
            t--;
        }
        for(int a :ans)
        {
            System.out.println(a);
        }
    }

    /* Bottom up approach or tabulation */
    private static int paths2(int n, int m, int[][] arr) {
        for(int j=0 ; j<arr[0].length; j++)
        {
            arr[0][j] = 1;
        }
        for(int i=1;i<n;i++)
        {
            arr[i][0] = 1;
        }

        for(int i=1;i<n;i++)
        {
            for(int j= 1;j<m;j++)
            {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[n-1][m-1];
    }

    /* REURSION SOLUTION */
    private static int paths(int n, int m) {
        if(n==1 || m==1)
        {
            return 1;
        }

        return paths(n-1,m) +paths(n,m-1);
    }

    /* Top Down Approach Or Memoization*/
    private static int paths1(int n, int m , int[][] arr) {
        if(n<=1 || m<=1)
        {
            return 1;
        }

        if(arr[n][m]>0)
        {
            return arr[n][m];
        }

        int x1 = paths1(n-1,m,arr);
        int x2 = paths1(n,m-1,arr);
        arr[n][m] = x1+x2;
        return arr[n][m];
    }
}
