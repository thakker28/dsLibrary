package arraysandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LonelyElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while (i < n) {
            arr[i] = scanner.nextInt();
            i++;
        }
      //  System.out.println(lonelyElement(arr, 0));
        System.out.println(lonelyElementLogN(arr));
    }

    private static int lonelyElementLogN(int[] arr) {
        if(arr.length%2==0)
        {
            return -1;
        }
        int left = 0 ;
        int right = arr.length-1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(mid==0 || mid==arr.length-1)
            {
                return arr[mid];
            }
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1])
            {
                return arr[mid];
            }
            if(mid%2==0)
            {
                if(arr[mid-1]==arr[mid])
                {
                    right = mid-1;
                }
//                else if(arr[mid+1]!=arr[mid])
//                {
//                    return arr[mid];
//                }
                else
                {
                    left = mid+1;
                }
            }
            if(mid%2!=0)
            {
                if(arr[mid-1]==arr[mid])
                {
                    left = mid+1;
                }
//                else if(arr[mid+1]!=arr[mid])
//                {
//                    return arr[mid];
//                }
                else
                {
                    right = mid-1;
                }

            }
        }
        return -1;
    }

    /* O(n) complexity and also using O(n) space complexity */
    private static int lonelyElement(int[] arr, int index) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.get(arr[i]) !=null ? map.get(arr[i])+1 : 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
