package arraysandstrings;

import java.util.Scanner;

public class CandyDistributionToEachStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i=0;
        int arr[] = new int[n];
        while (i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        System.out.println(candyNumber(arr));
    }

    private static int candyNumber(int[] arr) {
        int ans [] = new int[arr.length];
        ans[0] = 1;
        for(int i=0;i<arr.length-1;i++)
        {
            ans[i+1] = arr[i+1]>arr[i] ? ans[i]+1 : 1;
        }
        for(int i=arr.length-2;i>=0;i--)
        {
            if(arr[i]>arr[i+1] && ans[i] <= ans[i+1])
            {
                ans[i] = ans[i+1]+1;
            }
        }
        int sum =0;
        for(int i : ans)
        {
            sum = sum+i;
        }
       return sum;
    }

}
