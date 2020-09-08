package arraysandstrings;

import java.util.Scanner;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int x = scanner.nextInt();
        int arr[] = new int[size];
        int i = 0;
        while(i<size)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        int res[] = returnIndex(arr,x);
        for(i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
    }

    private static int[] returnIndex(int[] arr, int x) {
        int left  = 0;
        int right = arr.length-1;
        int start = -1;
        int end =-1;
        int res[] = new int[2];
        while(left<=right)
        {
            int mid  = (left+right)/2;
            if(arr[mid]<x)
            {
                left = mid+1;
            }
            else if(arr[mid]>x)
            {
                right = mid-1;
            }
            if(arr[mid]==x)
            {
                start = mid;
                right = mid-1;
            }

        }

        left = 0;
        right  =arr.length-1;

        while(left<=right)
        {
            int mid  = (left+right)/2;
            if(arr[mid]<x)
            {
                left = mid+1;
            }
            else if(arr[mid]>x)
            {
                right = mid-1;
            }
            if(arr[mid]==x)
            {
                end = mid;
                left  = mid+1;
            }
        }
        res[0]= start;
        res[1] = end;
        return res;
    }

}
