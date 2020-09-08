package arraysandstrings;

import java.util.*;

public class KClosetToX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while (i < n) {
            arr[i] = scanner.nextInt();
            i++;
        }
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int res[] = printClosest(arr, k, x);
       // Arrays.sort(res);
        for(int a :res)
        {
            System.out.print(a+" ");
        }
    }

    private static int[] printClosest(int[] arr, int k, int x) {
        int currentSum = 0 ;
        int sum = 0;
        int pos = 0;
        int res[] = new int[k];
        for(int i=0;i<k;i++)
        {
            currentSum = currentSum + Math.abs(x-arr[i]);
            sum = currentSum;
        }
         for(int i=1;i<=arr.length-k;i++)
         {
             currentSum  = currentSum - Math.abs(x-arr[i-1]);
             currentSum = currentSum + Math.abs(x-arr[i+k-1]);
             if(currentSum<sum)
             {
                 sum = currentSum;
                 pos = i;
             }
         }
         for(int  i = 0;i<k;i++)
         {
             res[i] = arr[pos+i];

         }
         return res;
    }
}
