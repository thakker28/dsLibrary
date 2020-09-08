package arraysandstrings;

import java.util.Scanner;

public class TargetZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int resArr[] = targetZero(n);
        for(int i=0;i<resArr.length;i++)
        {
            System.out.print(resArr[i]+" ");
        }
    }

    private static int[] targetZero(int n) {
        int resArr[] = new int[n];
        int k = 0;
        for(int i = 1;i<=n/2;i++)
        {

            resArr[k++] = -1 *i;
            resArr[k++] = i;

        }
//        if(n%2!=0)
//        {
//            resArr[k] = 0;
//        }
        return resArr;
    }
}
