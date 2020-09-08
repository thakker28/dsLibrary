package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int k = scanner.nextInt();
        System.out.println(printSmallestNumber(number,k));
    }

    private static String printSmallestNumber(String number, int k) {
        Stack<Character> stack = new Stack<Character>();
        stack.push(number.charAt(0));
        int count = 0;
        for(int i =1;i<number.length();i++)
        {
            while(!stack.isEmpty() && number.charAt(i)<stack.peek()  && count<k)
            {
                stack.pop();
                count++;
            }
            stack.push(number.charAt(i));
        }
        String s= "";
        while(!stack.isEmpty())
        {
            s = stack.pop()+s;
        }

        s = s.substring(0,s.length()-(k-count));

//        if(s.length()==1 && k==count)
//        {
//            return s;
//        }
//        if(count<k)
//        {
//            String str = s;
//            s = "";
//            for(int i = 0;i<str.length()-(k-count);i++)
//            {
//                s = s + str.charAt(i);
//            }
//        }
//        int i = 0;

        while (!s.isEmpty() && s.charAt(0) =='0')
        {
            s = s.substring(1);
        }
        if(s.length()==0)
        {
            return "0";
        }
        return s;
    }
}
