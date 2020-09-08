package arraysandstrings;

import java.util.Scanner;

public class MaximumSubArrayProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int arr[] = new int[n];
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        System.out.println(maxProduct(arr));
    }

    private static int maxProduct(int[] arr) {
       int pp = 1;
       int np =1;
       boolean hasPos = false;
       boolean hasZero = false;
       int hasNegative = 0;
       int max = Integer.MIN_VALUE;
       if(arr.length==1)
       {return arr[0];}
       for(int i : arr)
       {
           if(i>0)
           {
               pp = pp * i;
               if(np !=1)
               {
                   np = np*i;
               }
               hasPos = true;
           }
          else if(i<0)
           {
               int temp = pp*i;
               pp = Math.max(1,np*i);
               np = temp;
               hasNegative++;
           }
           else // i==0
           {
               pp=np=1;
               hasZero =  true;
           }
           if(max<pp)
           {
               max = pp;
           }
       }
       if(max==1)
       {
           if(hasPos)
           {
               return max;
           }
           if(hasNegative%2==0)
           {
               return max;
           }
           else if(hasZero)
           {
               return 0;
           }
       }
       return max;
    }

}
