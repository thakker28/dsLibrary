package arraysandstrings;

import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i =0;
        String s[] = new String[n];
        while(i<n)
        {
            s[i]=scanner.next();
            i++;
        }
        System.out.println(longestPrefix(s,0));
    }

    private static String longestPrefix(String s[] , int index)
    {
        if(s==null)
        {
            return "";
        }
        if(index==s.length-1)
        {
            return s[index];
        }
        String smallOutput = longestPrefix(s,index+1);
        if(smallOutput.isEmpty() || smallOutput==null)
        {
            return "";
        }
        int i=0;
        String str = "";
        while(i<smallOutput.length() && i<s[index].length())
        {
            if(s[index].charAt(i)==smallOutput.charAt(i))
            {
                str = str+smallOutput.charAt(i);
            }
            else
            {
                break;
            }
            i++;
        }
        return str;
    }

}
