package arraysandstrings;

import java.util.Scanner;

public class MinimunInRotatedSearchArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        System.out.println(minimumElement(arr));
    }

    private static int minimumElement(int[] arr) {
        int left =  0;
        int right = arr.length-1;

        /* Alternatively u could have checked while(left<right) and add first condition to check whether array is sorted i.e arr[0]<arr[n-1]
        then return arr[0] and mid == 0 condition can be removed.
         */
        while(left<=right)
        {
            int mid  = (left +right)/2;
            if(mid==0 || mid==arr.length-1)
            {
                return arr[mid];
            }
            if(arr[mid-1]>arr[mid])
            {
                return arr[mid];
            }
            if(arr[mid]>arr[0])
            {
                left=mid+1;
            }
            else if(arr[arr.length-1]>arr[mid])
            {
                right = mid-1;
            }
        }

        return -1;
    }
}
