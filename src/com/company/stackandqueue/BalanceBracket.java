package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(checkBalanced(s));
    }

    private static boolean checkBalanced(String exp) {
        Stack<Character> stack = new Stack();
        for(int i= 0; i<exp.length(); i++)
        {
            if(exp.charAt(i)=='{' || exp.charAt(i)=='[' || exp.charAt(i)=='(')
            {
                stack.push(exp.charAt(i));
            }

            if(exp.charAt(i)=='}' || exp.charAt(i)==']' || exp.charAt(i)==')')
            {
                if(stack.isEmpty())
                    return false;
                char popped = stack.pop();
                if((popped!='{' && (exp.charAt(i) =='}')) || (popped=='[' && !(exp.charAt(i) ==']'))
                        || (popped=='(' && !(exp.charAt(i) ==')')))
                {
                    return false;
                }
            }

        }
        return true;
    }
}
