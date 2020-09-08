package arraysandstrings;

import java.util.Scanner;

public class FindTheRanges {
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
        ranges(arr);
    }

    private static void ranges(int[] arr) {
        if(arr.length==1)
        {
            System.out.print(arr[0]);
        }
        if(arr.length==0)
        {
            System.out.print(" ");
        }
        int start = arr[0];
        int end = arr[0];
        for(int i =0;i<arr.length-1;i++)
        {
            if(arr[i]+1==arr[i+1])
            {
                end  = arr[i+1];
            }
            else
            {
                if(start!=end && end!=arr[0])
                {
                    System.out.print(start+"->"+end+" ");
                }else
                {
                    System.out.print(start+" ");
                }
                start = arr[i+1];
                end = arr[i+1];

            }
        }
        if(end==arr[arr.length-1] )
        {
            if(start==end)
            {
                System.out.print(start);
            }
            else
            {
                System.out.print(start+"->"+end);
            }
        }
    }
}
