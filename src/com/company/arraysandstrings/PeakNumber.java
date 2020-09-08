package arraysandstrings;

import java.util.Scanner;

public class PeakNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int  i = 0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        System.out.println(peakNumber(arr));
    }

    private static boolean peakNumber(int[] arr) {
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]>arr[i+1])
            {
                return true;
            }
        }
        return false;
    }
}
