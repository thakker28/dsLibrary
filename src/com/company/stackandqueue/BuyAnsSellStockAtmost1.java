package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class BuyAnsSellStockAtmost1 {
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
        maximumProfit(arr);
    }

    private static void maximumProfit(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int max = 0;
        int current = 0;
        for(int i =1 ; i<arr.length; i++)
        {
            if(stack.peek()>arr[i])
            {
                stack.pop();
                stack.push(arr[i]);
            }
            else
            {
                current = arr[i] - stack.peek();
                if(current>max)
                {
                    max = current;
                }
            }
        }
        System.out.println(max);
    }
}
