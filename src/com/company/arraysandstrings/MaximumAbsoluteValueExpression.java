package arraysandstrings;

import java.util.Scanner;

public class MaximumAbsoluteValueExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        while(i<n)
        {
            arr1[i] =scanner.nextInt();
            i++;
        }
        i = 0;
        while(i<n)
        {
            arr2[i] =scanner.nextInt();
            i++;
        }
       // System.out.println(maximumValue(arr1,arr2));
        System.out.println(maximumValueInLinearTime(arr1,arr2));
    }

    private static int maximumValueInLinearTime(int[] arr1, int[] arr2) {
       int a1,a2,b1,b2,c1,c2,d1,d2;
       a1 = b1 = c1 = d1 = Integer.MIN_VALUE;
       a2 = b2 =c2 = d2 = Integer.MAX_VALUE;
       for(int i=0;i<arr1.length;i++)
       {
           int currentSum1 = arr1[i]+arr2[i]+i;
           int currentSum2 = arr1[i] + arr2[i] -i;
           int currentSum3 = arr1[i] - arr2[i] +i;
           int currentSum4 = arr1[i] -arr2[i] -i;
           if(currentSum1>a1)
           {
               a1 = currentSum1;
           }
           if(currentSum1<a2)
           {
               a2 = currentSum1;
           }

           if(currentSum2>b1)
           {
               b1 = currentSum2;
           }
           if(currentSum2<b2)
           {
               b2 = currentSum2;
           }
           if(currentSum3>c1)
           {
               c1 = currentSum3;
           }
           if(currentSum3<c2)
           {
               c2 = currentSum3;
           }
           if(currentSum4>d1)
           {
               d1 = currentSum4;
           }
           if(currentSum4<d2)
           {
               d2 = currentSum4;
           }
       }

int max1 = Math.max(a1-a2,b1-b2);
       int max2 = Math.max(c1-c2,d1-d2);
       return Math.max(max1,max2);
    }

    /* this method takes O(n*2) complexity) */
    private static int maximumValue(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr1.length;j++)
            {
                int currentSum  = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
                if(currentSum>max)
                {
                    max =currentSum;
                }
            }
        }
        return max;
    }
}
