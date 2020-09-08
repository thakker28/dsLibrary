package arraysandstrings;

import java.util.Scanner;

public class CompareVersions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.print(expressionValue(s1,s2));
    }

    private static int expressionValue(String s1, String s2) {
            String arr1[] = s1.split("\\.");
            String arr2[] = s2.split("\\.");
            int i = 0;
            while(i<arr1.length && i<arr2.length)
            {
                if(Integer.parseInt(arr1[i])>Integer.parseInt(arr2[i]))
                {
                    return 1;
                }
                if(Integer.parseInt(arr1[i])<Integer.parseInt(arr2[i]))
                {
                    return -1;
                }
                i++;
            }
            if(arr1.length==arr2.length)
            {
                return 0;
            }
           else if(i==arr2.length)
            {
                while(i<arr1.length)
                {
                    if(Integer.parseInt(arr1[i])>0)
                    {
                        return 1;
                    }
                    i++;
                }
                return 0;
            }
        else
        {
            while(i<arr2.length)
            {
                if(Integer.parseInt(arr2[i])>0)
                {
                    return -1;
                }
                i++;
            }
            return 0;
        }

        }

}
