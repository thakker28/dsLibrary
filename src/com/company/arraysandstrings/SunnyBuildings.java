package arraysandstrings;

import java.util.Scanner;

public class SunnyBuildings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int resArr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int length = scanner.nextInt();
            int arr[] = new int[length];
            for(int j=0;j<length;j++)
            {
                arr[j] = scanner.nextInt();
            }
       resArr[i]=(buildingHeight(arr));
        }
        for(int i=0;i<resArr.length;i++)
        {
            System.out.println(resArr[i]);
        }

    }

    private static int buildingHeight(int[] arr) {
        int max =0;
        int i = 0;
        int j=0 ;
        while(i<arr.length-1 && j!=arr.length)
        {
           for(j=i+1;j<arr.length;j++)
           {
               if(arr[i]<=arr[j])
               {
                   i=j;
                   max++;
                   break;
               }
           }


        }
        return max+1;
    }
}
