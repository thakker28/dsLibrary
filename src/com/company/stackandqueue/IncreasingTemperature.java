package stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class IncreasingTemperature {
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
        printDaysToWait(arr);
    }

    private static void printDaysToWait(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans[] = new int[arr.length];
        stack.push(0);
        for(int i = 1;i<arr.length;i++)
        {
            if(arr[i]>arr[stack.peek()]) //Found a higer temperature
            {
                while (!stack.isEmpty() && arr[stack.peek()]<arr[i] )  // checking whether it is higher for all elements in stack
                {
                        ans[stack.peek()] = i-stack.peek();
                        stack.pop();

                }
            }
            stack.push(i);
        }

        for(int a : ans)
        {
            System.out.print(a+" ");
        }
    }
}
