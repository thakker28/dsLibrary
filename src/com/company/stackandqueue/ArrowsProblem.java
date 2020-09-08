package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class ArrowsProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int number = scanner.nextInt();
            arr[i] = number;
        }
        arrowsState(arr);
    }

    private static void arrowsState(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++)
        {

            if(!stack.isEmpty() && stack.peek()>0 && arr[i]<0) //For collision to happen
            {
                boolean add = true; // to check whether to push the element or not
                while (!stack.isEmpty() && stack.peek()>0 && arr[i]<0)
                {
                    if(Math.abs(stack.peek())==Math.abs(arr[i]))
                    {
                        stack.pop();
                        add = false;
                        break;
                    }
                    else if(Math.abs(stack.peek())< Math.abs(arr[i]))
                    {
                        stack.pop();
                        add = true;
                    }
                    else
                    {
                        add = false;
                        break;
                    }
                }
                if(add)
                {
                    stack.push(arr[i]);
                }

            }
            else
            {
                stack.push(arr[i]);
            }
        }
        int ans[] = new int[stack.size()];
        int size = stack.size();
        int i = 0;
        while(!stack.isEmpty())
        {
            ans[size-1-i] = stack.pop();
            i++;
        }
        for(int a : ans)
        {
            System.out.print(a+" ");
        }
    }
}
