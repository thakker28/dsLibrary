package arraysandstrings;

import java.util.Scanner;

public class WordDistance2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
//        String arr[] = new String[n];
//        int i =0;
//        while (i<n)
//        {
//            arr[i] = scanner.next();
//            i++;
//        }
        String string = scanner.nextLine();
        String str1 = scanner.next();
        String str2 = scanner.next();
        System.out.println(shortestDistance(string , str1 ,str2));
    }

    private static int shortestDistance(String string , String word1 , String word2) {
        string = string.replaceAll("\\s+"," ");
        String arr[] = string.split(" ");
        int i =0;
        int index1 =-1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        while (i<arr.length)
        {
            if(arr[i].equals(word1) && index1==-1)
            {
                index1 = i;
               // index2=-1;
            }
           else if(arr[i].equals(word2) && index2==-1 )
            {
                index2 = i;
                //index1 = -1;
            }
            if(index1!=-1 && index2!=-1)
            {
                min = Math.min(min,Math.abs(index1-index2));
                if(index1<index2)
                {
                    index1 = -1;
                }
                else
                {
                    index2 =-1;
                }

            }
            i++;
        }
        return min;
    }
}
