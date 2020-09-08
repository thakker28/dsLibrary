package arraysandstrings;

import java.util.Scanner;

public class MajorityElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
      int res[] =   majority(arr);
        if(res.length==0)
        {
            System.out.println("No Majority Elements");
        }
        else
        {
            for(int i=0;i<res.length;i++)
            {
                if(res[i] != -1)
                {
                    System.out.print(res[i]+" ");
                }
            }
        }
    }

    private static int[] majority(int[] arr) {
       if(arr.length==0)
       {
           return new int[0];
       }
        int element1 = arr[0];
        int element1Count =1;
        int element2 = 0;
        int element2Count = 0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==element1)
            {
                element1Count++;
            }
            else if(arr[i]==element2)
            {
                element2Count++;
            }
            else if(element1Count==0)
            {
                element1Count++;
                element1 = arr[i];
            }
            else if(element2Count==0)
            {
                element2Count++;
                element2 = arr[i];
            }
            else
            {
                element1Count--;
                element2Count--;
            }
        }
        element1Count = 0 ;
        element2Count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==element1)
            {
                element1Count++;
            }
            else if(arr[i]==element2)
            {
                element2Count++;
            }
        }
        int res[]  = new int[2];

        int k = 0;
        if(element1Count>arr.length/3)
        {
            res[k++] = element1;
        }
        if(element2Count>arr.length/3)
        {
            res[k++] = element2;
        }

            return res;


    }
}
