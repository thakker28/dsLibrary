package arraysandstrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PancakeSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 0;
       // List<Integer> res = new ArrayList<Integer>();
       int resArr[][] = new int[n][];
        while(k<n)
        {
            int size = scanner.nextInt();
            int arr[] = new int[size];
            for(int i=0;i<arr.length;i++)
            {
                arr[i]=scanner.nextInt();
            }
             resArr[k]=(pancakeFlips(arr));

            k++;
        }
        for(int i=0;i<resArr.length;i++)
        {
            for(int j=0;j<resArr[i].length;j++)
            {
                System.out.print(resArr[i][j]+" ");
            }
            System.out.println(" ");
        }

    }

    private static int[] pancakeFlips(int[] arr) {
        List<Integer> output = new ArrayList<>();
        if(arr==null)
        {
            return null;
        }
        if(arr.length==1)
        {
            return arr;
        }
        int n =arr.length;
        while(n>0)
        {

            int index = findIndex(arr,n);
            if(index != n-1)
            {
                flip(arr,index+1);
                flip(arr,n);
                output.add(index+1);
                output.add(n);
            }
            n--;
        }
        int resArr[] = new int[output.size()];
        int i=0;
        for(int num : output)
        {
            resArr[i++] = num;
        }
        return resArr;
    }

    private static void flip(int[] arr, int index) {
        for(int i=0;i<index/2;i++)
        {
            int t = arr[i];
            arr[i] = arr[index-i-1];
            arr[index-i-1] = t;
        }
    }

    private static int findIndex(int arr[] , int element)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==element)
            {
                return i;
            }
        }
        return -1;
    }
}
