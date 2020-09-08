package arraysandstrings;

import java.util.Scanner;

public class EditDistantStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        boolean ans = editDistanceStrig(s1,s2);
        if(ans)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }

    private static boolean editDistanceStrig(String s1, String s2) {
        if(Math.abs(s1.length()-s2.length())>1)
        {
            return false;
        }
        String str1 = s1.length()<s2.length() ? s1 :s2;
        String str2 = s1.length()<s2.length() ? s2 :s1;
        int count = 0;
        if(str1.length()!=str2.length())
        {
            int j = 0;

            for(int i=0;i<str2.length();i++)
            {
                if(str2.charAt(i)==str1.charAt(j))
                {
                    j++;
                    count++;
                }
                if(j==str1.length())
                {
                    break;
                }

            }
        }
        else
        {
            for(int i=0;i<str2.length();i++)
            {
                if(str1.charAt(i)==str2.charAt(i))
                {
                    count++;
                }
            }
        }
        if(count==str2.length()-1)
        {
            return true;
        }
        return false;
    }
}
