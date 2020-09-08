package dynamicprogramming;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParanthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine();
        int ans = longestLength(s);
        System.out.println(ans);
    }

    private static int longestLength(String s) {
        Stack<Character> stack = new Stack<>();
        int i;
        int length = 0;
        int maxLength = 0;
        for(i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='(')
            {
                stack.push('(');
            }
            else if(s.charAt(i)==')')
            {
                if(stack.isEmpty())
                {
                    maxLength = Math.max(maxLength,length);
                    length = 0;
                }
                else
                {
                    length = length+2;
                    stack.pop();
                }

            }
        }
//        if(stack.isEmpty())
//        {
//            return i;
//        }
//        else
//        {
//            return i - stack.size();
//        }
        return Math.max(length,maxLength);
    }
}
