package arraysandstrings;

import java.util.Scanner;

public class OverLappingRectangles {
    public static void main(String[] args) {
        int arr1[] = new int[4];
        int arr2[] = new int[4];
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<4;i++)
        {
            arr1[i] = scanner.nextInt();
        }
        for(int i=0;i<4;i++)
        {
            arr2[i] = scanner.nextInt();
        }
        int res = checkOverlap(arr1,arr2);
        System.out.print(res);
    }

    private static int checkOverlap(int[] arr1, int[] arr2) {
        if(arr1[3]<=arr2[0])
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
