package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class DecodeString {
    static class Pair
    {
        String temp;
        int digit;
        Pair(String temp , int digit)
        {
            this.temp = temp;
            this.digit = digit;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ans = decodeString(s);
        System.out.println(ans);
    }

    private static String decodeString(String s) {
        Stack<Pair> stack = new Stack<Pair>();
        String temp = "";
        StringBuilder ans = new StringBuilder();
        for(int i =0; i< s.length();i++)
        {
            if(s.charAt(i)-'0'>=1 && s.charAt(i)-'0'<=9)
            {
                int number = 0;

                while(i<s.length() && s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)
                {
                    number = number * 10 + s.charAt(i) - '0';
                    i++;
                }
                Pair pair = new Pair(temp,number);
                stack.push(pair);
                temp = "";
            }
            if(s.charAt(i)-'a'>=0 && s.charAt(i)-'a'<=26)
            {
                temp = temp+s.charAt(i);
            }
            if(s.charAt(i)==']')
            {
                int repetetions = stack.peek().digit;
                String prev = stack.peek().temp;
                int j =0;
               // StringBuilder str = new StringBuilder();
                while(j<repetetions)
                {
                    prev = prev+temp;
                    j++;
                }
                stack.pop();
                if(stack.isEmpty())
                {
                    ans = ans.append(prev);
                    temp = "";
                }
                else
                {
                    temp = prev;
                }

            }


        }

        return ans.append(temp).toString();
    }
}
