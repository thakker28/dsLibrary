package arraysandstrings;

import java.util.Scanner;

public class ProductOfArrayEceptSelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int arr[] = new int[n];
        while (i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        int res[] = productExcludingSelf(arr);
        for(int a : res)
        {
            System.out.print(a+" ");
        }

    }

    private static int[] productExcludingSelf(int[] arr) {
        int res[] = new int[arr.length];
        int product =1;
        int hasZero = 0;
        int productEcludingZero = 1;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                hasZero++;
            }
            else
            {
                product = product*arr[i];
            }

        }
        if(hasZero>1)
        {
            return res;
        }
//        if(product==0)
//        {
//            return res;
//        }
        for(int i=0;i<res.length;i++)
        {
            if(hasZero==1)
            {
                if(arr[i]==0)
                {
                    res[i]= product;
                }
            }
            else
            {
                res[i] = product/arr[i];
            }

        }
         return res;

    }
}
