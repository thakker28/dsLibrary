package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class LexicographicUniqueString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = uniqueCharacterString(input);
        System.out.println(output);
    }

    private static String uniqueCharacterString(String input) {
        Stack<Character> stack = new Stack<Character>();
        int lastIndex [] = new int[26];
        for(int i=0;i<input.length();i++)
        {
            lastIndex[input.charAt(i)-'a']=i;
        }
        boolean present[] = new boolean[26];

        for(int i=0;i<input.length();i++)
        {
            if(!present[input.charAt(i)-'a'])
            {

                while(!stack.isEmpty() && stack.peek()-'a'>input.charAt(i)-'a' && lastIndex[stack.peek()-'a']>i)
                {
                    present[stack.peek()-'a']=false;
                    stack.pop();
                }
                stack.push(input.charAt(i));
                present[input.charAt(i)-'a']=true;

            }
        }
        String s ="";
        while (!stack.isEmpty())
        {
            s = stack.pop()+s;
        }
        return s;
    }
}
