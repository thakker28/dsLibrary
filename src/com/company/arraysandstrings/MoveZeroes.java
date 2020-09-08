package arraysandstrings;

import java.util.Scanner;

public class MoveZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = scanner.nextInt();
        }
int resArr[] = moveZeroElements(arr);
        for(int i=0;i<resArr.length;i++)
        {
            System.out.print(resArr[i]+" ");
        }
    }

    private static int[] moveZeroElements(int[] arr) {

       /* Below logic works for O(N*2)
        for(int i=0;i<arr.length-1;i++)
        {
           for(int j=i+1;j<arr.length;j++)
           {
               if(arr[i]==0)
               {
                   if(arr[j]>0)
                   {
                       int x = arr[i];
                       arr[i] = arr[j];
                       arr[j] = x;
                       break;
                   }
               }
           }
        }
        return arr; */

       /* o(n) complexity code */
       int slow = 0;
       int fast = 1;
       while(fast<arr.length)
       {
            if(arr[slow]==0 && arr[fast]!=0)
            {
                arr[slow] = arr[slow]+arr[fast];
                arr[fast]=arr[slow]-arr[fast];
                arr[slow] = arr[slow]-arr[fast];
                slow =slow+1;
            }
            fast = fast+1;
            if(arr[slow] !=0)
            {
                slow =slow+1;
            }
       }
       return arr;
    }
}

