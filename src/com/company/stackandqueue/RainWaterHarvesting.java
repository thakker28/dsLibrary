package stackandqueue;

import java.util.Scanner;

public class RainWaterHarvesting {
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
        int ans = collectWater(arr);
        System.out.println(ans);
    }

    private static int collectWater(int[] arr) {
        int leftPart[] = new int[arr.length];
        int rightPart[] = new int[arr.length];

        /* ans would be the min of the max heights to left and right of a building and then subtracting it
        with the current building height

         */
        leftPart[0] = 0;
        rightPart[arr.length-1] = 0;
        for(int i = 1 ; i<arr.length;i++)
        {
            leftPart[i] = Math.max(leftPart[i-1],arr[i-1]);
        }
        for(int i = arr.length-2 ; i>=0 ;i--)
        {
            rightPart[i] = Math.max(rightPart[i+1],arr[i+1]);
        }
        int sum = 0;
        for(int i =0;i<arr.length;i++)
        {
            int waterStored = Math.min(leftPart[i],rightPart[i])-arr[i];
            if(waterStored<0)
            {
                waterStored = 0;
            }
            sum = sum+waterStored;
        }
        return sum;
    }
}
