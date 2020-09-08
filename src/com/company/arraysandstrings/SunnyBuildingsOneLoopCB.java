package arraysandstrings;

import java.util.Scanner;

public class SunnyBuildingsOneLoopCB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int resArr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int length = scanner.nextInt();
            int arr[] = new int[length];
            for(int j=0;j<length;j++)
            {
                arr[j] = scanner.nextInt();
            }
            resArr[i]=(buildingHeight(arr));
        }
        for(int i=0;i<resArr.length;i++)
        {
            System.out.println(resArr[i]);
        }

    }

    private static int buildingHeight(int[] arr) {
        int height = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>=height)
            {
                height = arr[i];
                count++;
            }
        }
        return count;
    }
}
