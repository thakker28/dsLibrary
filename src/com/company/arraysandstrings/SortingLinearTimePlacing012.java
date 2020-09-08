package arraysandstrings;

import java.util.Scanner;

public class SortingLinearTimePlacing012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int arr[] = new int[n];
        int i=0;
        while (i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        int resArr[] = sortLinear(arr);
        for(int j=0;j<resArr.length;j++)
        {
            System.out.print(resArr[j]+" ");
        }
    }

    private static int[] sortLinear(int[] arr) {
        int current =0;
        int left =0;
        int right = arr.length-1;
        while(current<right)
        {
            if(arr[current]==0)
            {
                arr[left] = arr[left]+arr[current];
                arr[current] = arr[left] - arr[current];
                arr[left] = arr[left]-arr[current];
                left++;
                current++;
            }
           else if(arr[current]==2)
            {
                arr[current] = arr[current]+arr[right];
                arr[right] = arr[current]-arr[right];
                arr[current] = arr[current]-arr[right];
                right--;
            }
            else
            {
                current++;
            }
        }
        return arr;
    }
}
