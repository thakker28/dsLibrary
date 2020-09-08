package arraysandstrings;

import java.util.Scanner;

public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int arr[]  =new int[n];
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        System.out.println(missingPositive(arr));
    }

    private static int missingPositive(int[] arr) {
        int i=0;
        for(i=0; i< arr.length;i++)
        {
            if(arr[i]<=0)
            {
                arr[i] = arr.length+1;
            }
        }
        for(i =0;i<arr.length;i++)
        {
            int index = Math.abs(arr[i]);

            if(index<=arr.length && arr[index-1]>0)
            {
                arr[index-1] = arr[index-1]*-1;
            }
        }
        for(i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                return i+1;
            }
        }
        return i+1;
    }

}
