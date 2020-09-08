package arraysandstrings;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosetAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int arr [] = new int[n];
        int i = 0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        System.out.println(threeclosestSum(arr,target));
    }

    private static int threeclosestSum(int[] arr, int target) {
        Arrays.sort(arr);
        int i;
        int j;
        int k;
        int closest_Diff = Integer.MAX_VALUE;
        int closestSum=0;
        int sum = 0;
        for(i=0;i<=arr.length-3;i++)
        {
            j=i+1;
            k=arr.length-1;
            sum = arr[i]+arr[j]+arr[k];
            while(j<k)
            {
                int differnce  = Math.abs(sum-target);
                if(closest_Diff>differnce)
                {
                    closest_Diff = differnce;
                    closestSum = sum;
                }


                if(sum>target)
                {
                    sum = sum-arr[k];
                    k--;
                    sum = sum +arr[k];
                }
                else if(sum<target)
                {
                    sum = sum-arr[j];
                    j++;
                    sum = sum +arr[j];
                }
                else
                {
                    return sum;
                }
            }
        }
return closestSum;
    }
}
