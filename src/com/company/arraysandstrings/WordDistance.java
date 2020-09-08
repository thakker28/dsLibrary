package arraysandstrings;

import java.util.Scanner;

public class WordDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String string = scanner.nextLine();
        String str1 = scanner.next();
        String str2 = scanner.next();
        //int ans = wordDistance(string,str1,str2);
        int ans = wordDistance2pointers(string,str1,str2);
        System.out.print(ans);
    }

    private static int wordDistance2pointers(String string, String str1, String str2) {
        string = string.replaceAll("\\s+"," ");
        String arr[] = string.split(" ");
        int i=0;
        int count1=-1;
        int count2=-1;
        int min =Integer.MAX_VALUE;
        while(i<arr.length)
        {
            if(arr[i].equals(str1))
            {
                count1=i;
            }
            else if(arr[i].equals(str2))
            {
                count2 = i;
            }
            if(count1!=-1 && count2!=-1)
            {
                min = Math.min(min,Math.abs(count1-count2));
            }

            i++;
        }
        return min;
    }

    /* using only one pointer */
    private static int wordDistance(String string, String str1, String str2) {
        string = string.replaceAll("\\s+"," ");
        String arr[] = string.split(" ");
        int i=0;
        int count  = 0;
        int min = Integer.MAX_VALUE;
        while(i<arr.length)
        {
            if(count>0)
            {
                count++;
            }

            if(arr[i].equals(str1) || arr[i].equals(str2))
            {
                count++;
                if(count>=2)
                {
                    min = Math.min(min,count-2);
                    count = 1;
                }

            }
            i++;
        }
        return min;
    }
}
