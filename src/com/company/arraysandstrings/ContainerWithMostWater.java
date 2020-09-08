package arraysandstrings;

import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
//        int arr[] = new int[]{1,8,6,2,5,4,8,3,7};
//        System.out.print(arr.length);
        System.out.print(container(arr));
    }

    private static int container(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int max = 0;
        while(left<right)
        {
            int area = Math.min(arr[left],arr[right]) * (right-left);
            max = Math.max(max,area);
            if(arr[left]<=arr[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return max;
    }
}
