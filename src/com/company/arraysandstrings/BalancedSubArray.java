package arraysandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalancedSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int arr[] = new int[n];
        int i=0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
      //  System.out.println(balancedLength(arr));
        System.out.println(balancedLengthInLinearTime(arr));
    }

    private static int balancedLengthInLinearTime(int[] arr) {
        int length = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                count++;
            }
            if(arr[i]==0)
            {
                count--;
            }
            if(map.get(count)!=null)
            {
                length = Math.max(length,i-map.get(count));
            }
            else
            {
                map.put(count,i);
            }
        }
        return length;
    }

    /* this method takes o(n*2) time complexity to give the max length of subarray having same o's and 1's */
    private static int balancedLength(int[] arr) {

       int length = 0;
       for(int i=0;i<arr.length;i++)
       {
           int zeroCount = 0;
           int oneCount = 0;
           for(int j=i;j<arr.length;j++)
           {
                if(arr[j]==0)
                {
                    zeroCount++;
                }
                if(arr[j]==1)
                {
                    oneCount++;
                }
                if(zeroCount==oneCount)
                {
                    length = Math.max(length,zeroCount+oneCount);
                }
           }
       }
return length;
    }
}
