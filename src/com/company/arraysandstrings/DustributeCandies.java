package arraysandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DustributeCandies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = scanner.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<n;i++)
        {
            if(map.get(arr[i])==null)
            {
                map.put(arr[i],1);
                count++;
            }
        }
         System.out.println(Math.min(n/2,count));
    }
}
