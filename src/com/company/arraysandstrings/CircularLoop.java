package arraysandstrings;

import java.util.Scanner;

public class CircularLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        {
                for(int i=0;i<n;i++)
                {
                    arr[i] = scanner.nextInt();
                }
        }
        int i = 0;
        int j=0;
        boolean cycle = false;
        int cycleCount = 0 ;
        int loop = 0;
        while(j!=arr.length)
        {
            int k = i;
            if(arr[i]>=0)
            {
                i = i+arr[i];
                if(i>k)
                {
                    cycle = true;
                    cycleCount++;
                }
                else
                {
                    cycle = false;
                }
            }

          else  if(arr[i]<0)
            {
                i = i+arr[i];
                if(i<k)
                {
                    //cycle = true;
                    cycleCount++;
                }
                if(cycle==true)
                {
                    cycle = false;
                }
                else
                {
                    cycle = true;
                }
                if(i<0)
                {
                    loop++;
                    i = n + i;
                }
            }
          if(i>n)
          {
              j++;
              i=j;
          }

            if(i==n || loop>1 || i==0)
            {
                break;
            }
        }
        if((i==n||i==0) && cycle==true && cycleCount>1)
        {
            System.out.print("1");
        }
        else
        {
            System.out.print("0");
        }
    }
}
