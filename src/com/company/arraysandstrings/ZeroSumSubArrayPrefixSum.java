package arraysandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroSumSubArrayPrefixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int resAarr[] = new int[n];
        int i =0;
        while(i<n)
        {
            int size = scanner.nextInt();
            int arr[] = new int[size];
            for(int k=0;k<size;k++)
            {
                arr[k] =scanner.nextInt();
            }

            resAarr[i] = countOfSubArrays(arr);
            i++;
        }
        for(int j=0;j<resAarr.length;j++)
        {
            System.out.println(resAarr[j]);
        }
    }

    private static int countOfSubArrays(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(sum,1);
        for(int i = 0; i<arr.length;i++)
        {
            sum = sum +arr[i];
            map.put(sum,map.get(sum)==null ? 1 : map.get(sum)+1);
        }
        for(int a : map.values())
        {
            if(a>=2)
            {
                count = count + factorial(a)/(factorial(a-2)* 2);
            }
        }
        return count;
    }

    private static int factorial(int a) {
        if(a<=1)
        {
            return 1;
        }
        int output = a*factorial(a-1);
        return output;
    }

}
