package stackandqueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class OperationalTimeOfFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // scanner.useDelimiter("\n");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String arr[] = new String[2*n];
        int i = 0;
        while(i<arr.length)
        {
            arr[i] = scanner.next();
            i++;
        }
        printOperationalTime(arr);
    }

    private static void printOperationalTime(String[] arr) {
        Stack<String> stack = new Stack();
        int time[] = new int[arr.length/2];
        for(int i= 0; i<arr.length;i++)
        {
            String functionTime[] = arr[i].split(":");
            String id = functionTime[0];
            String startOrEnd = functionTime[1];
            String timeCount = functionTime[2];

            if(startOrEnd.equals("start"))
            {
                if(!stack.isEmpty())
                {
                    time[Integer.parseInt(stack.peek())] = Integer.parseInt(timeCount) - time[Integer.parseInt(stack.peek())];
                   // time[Integer.parseInt(stack.peek())] =  Integer.parseInt(timeCount) - time[Integer.parseInt(stack.peek())];
                }
                stack.push(id);
                time[Integer.parseInt(id)] = Integer.parseInt(timeCount);
            }
            else
            {
                time[Integer.parseInt(stack.peek())] =  Integer.parseInt(timeCount) - time[Integer.parseInt(stack.peek())] + 1;
                stack.pop();
                if(!stack.isEmpty())
                {
                    time[Integer.parseInt(stack.peek())] =  Integer.parseInt(timeCount) - time[Integer.parseInt(stack.peek())] +1;
                }
            }
        }
        Arrays.sort(time);
        for(int a : time)
        {
            System.out.println(a+" ");
        }
    }
}
