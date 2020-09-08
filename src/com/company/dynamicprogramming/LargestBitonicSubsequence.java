package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestBitonicSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t= scanner.nextInt();
        List<Integer> ans = new ArrayList<>();
        while(t>0)
        {
            int n = scanner.nextInt();
            int arr[] = new int[n];
            int i =0;
            while(i<n)
            {
                arr[i] = scanner.nextInt();
                i++;
            }
            ans.add(bitonSubSequenceLength(n,arr));
            t--;
        }

        for(int a : ans)
        {
            System.out.println(a);
        }
    }

    private static int bitonSubSequenceLength(int n, int[] arr) {
        int leftPart[] = new int[arr.length];
        int rightPart[] = new int[arr.length];
        leftPart[0] = 1;
        rightPart[arr.length-1] = 1;
        for(int i=1 ; i<arr.length ;i++) // Filling the number of smaller elements to the left of cuurent element
        {
            for(int j = 0; j<i; j++)
            {
                if(arr[i]>arr[j])
                {
                    leftPart[i] = Math.max(leftPart[i],leftPart[j]+1);
                }
            }
            if(leftPart[i]==0)
            {
                leftPart[i] =1;
            }
        }

        for(int i=arr.length-2;i>=0;i--) //Filling the number of smaller elements to right of curent element
        {
            for(int j=i+1 ; j<arr.length ; j++)
            {
                if(arr[i]>arr[j])
                {
                    rightPart[i] = Math.max(rightPart[i],rightPart[j]+1);
                }
            }
            if(rightPart[i]==0)
            {
                rightPart[i] =1;
            }
        }
        int max = 0;
        for(int i=0;i<leftPart.length;i++)
        {
            max = Math.max(max,leftPart[i]+rightPart[i]-1);
        }
        return max;
    }
}
