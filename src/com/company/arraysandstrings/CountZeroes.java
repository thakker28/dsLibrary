package arraysandstrings;

import java.util.Scanner;
/* return the count of trailing zeroes in O(logn) time complexity */
public class CountZeroes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countZero(n));
    }

    private static int countZero(int n) {
        int count  = 0;
        while (n>0)
        {
            n = n/5;
            count = count+n;
        }
        return count;
    }
}
