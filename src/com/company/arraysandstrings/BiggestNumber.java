package arraysandstrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BiggestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String resArr[] = new String[n];
        for(int i=0;i<n;i++)
        {
            int size = scanner.nextInt();
            String arr[] = new String[size];
            for(int j=0;j<size;j++)
            {
                arr[j]  = scanner.next();
            }

            resArr[i]=biggestNumber(arr);
        }
        for(int i=0;i<resArr.length;i++)
        {
            System.out.println(resArr[i]);
        }
    }

    private static String biggestNumber(String[] arr) {

        Arrays.sort(arr, new Comparator<String>() {

            public int compare(String o1, String o2) {
                if( (o2+o1).compareTo(o1+o2)>1)
                {
                    return 10;
                }
                else
                {
                    return -10;
                }
            }
        });

        String s ="";
        for(String str : arr)
        {
            s =s+str;
        }
        return s;

    }

}
