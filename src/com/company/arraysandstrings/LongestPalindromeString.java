package arraysandstrings;

import java.util.Scanner;

public class LongestPalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        /* brute force approach : O(n*3) time complexity) */
        String resArr[] = longestPalindrome(s,0); /* O(n*2) time complexity */
        resArr = checkPalindrome(resArr);  /* O(n) time complexity */
        int max = Integer.MIN_VALUE;
        for(String str :resArr)
        {
            if(str!=null && str.length()>max)
            {
                max = str.length();
            }
        }
        for(String str : resArr)
        {
            if(str != null && str.length()==max)
            {
                System.out.println(str);
            }
        }
    }

    private static String[] longestPalindrome(String s,int index) {
//        if(s.length()==1)
//        {
//            String arr[] = {"",s};
//            return arr;
//        }
//        String smallOutput[] = longestPalindrome(s.substring(1));
//        String output[] = new String[smallOutput.length*2];
//        int k=0;
//        for(String str : smallOutput)
//        {
//          output[k++] = s.charAt(0)+str;
//          output[k++] = str;
//        }
//        return output;
        //return checkPalindrome(output);
        if(index == s.length()-1)
        {
            String arr[] = {s.charAt(index)+"","" };
            return arr;
        }
        String smallOutput[] = longestPalindrome(s,index+1);
        String output[] = new String[smallOutput.length+(s.length()-index)];
        int  k = 0;

        for(String str : smallOutput)
        {
            output[k++] = str;
        }
        for(int i=index;i<s.length();i++)
        {
            output[k++] = s.substring(index,i+1);
        }
        return output;
    }

    private static String[] checkPalindrome(String[] output) {
        String arr[] = new String[output.length];
        int k = 0;
        for(String s : output)
        {
            int left =0;
            int right = s.length()-1;
            while(left<right)
            {
                if(s.charAt(left)!=s.charAt(right))
                {
                    break;
                }
                left++;
                right--;
            }
            if(left==right || left>right)
            {
                arr[k++]=s;
            }
        }
        return arr;
    }
}
