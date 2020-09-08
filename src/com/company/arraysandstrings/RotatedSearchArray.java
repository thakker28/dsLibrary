package arraysandstrings;

import java.util.Scanner;

public class RotatedSearchArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i=0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        int target = scanner.nextInt();
       // System.out.println(targetElement(arr,target));
        System.out.println(targetElementBinarySearch(arr,target));
    }

    private static int targetElementBinarySearch(int[] arr, int target) {
        int left = 0;
        int n = arr.length;
        int right = n - 1;

       while(left<=right)
       {
           int mid = (left + right) / 2;
           if (arr[mid] == target) {
               return mid;
           }
           if (arr[mid] > arr[n - 1]) {
               if (target < arr[0] || arr[mid] < target) {
                   left = mid + 1;
               } else {
                   right=mid-1;
               }
           }
           if (arr[mid] < arr[n - 1]) {
               if (target>arr[n-1] || target<arr[mid]) {
                   right = mid - 1;
               } else {
                   left=mid+1;
               }

           }
       }
       return -1;
    }

    private static int targetElement(int[] arr, int target) {
        if(arr[0]==target)
        {
            return 0;
        }
        if(arr[0]<target)
        {
            int i = 0;
            while(arr[i]<arr[i+1])
            {
                if(arr[i]== target)
                {
                    return i;
                }
                if(arr[i+1]==target)
                {
                    return i+1;
                }
            i++;
            }
            return -1;
        }
        else
        {
          int i=arr.length-1;
          while(arr[i-1]<arr[i])
          {
              if(arr[i]==target)
              {
                  return i;
              }
              if(arr[i-1]==target)
              {
                  return i-1;
              }
              i--;
          }
          return -1;
        }
    }
}
