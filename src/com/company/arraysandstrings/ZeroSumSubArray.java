package arraysandstrings;

import java.util.Scanner;

public class ZeroSumSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int resAarr[] = new int[n];
        int i =0;
        while(i<n)
        {
            int size = scanner.nextInt();
            int arr[] = new int[size];
            for(int k=0;k<size;k++)
            {
                arr[k] =scanner.nextInt();
            }

            resAarr[i] = countOfSubArrays(arr,0,0).length;
            i++;
        }
        for(int j=0;j<resAarr.length;j++)
        {
            System.out.println(resAarr[j]);
        }
    }

    private static int[][] countOfSubArrays(int[] arr,int index,int k) {
        if(index == arr.length)
        {
            if(k==0)
            {
                int output[][] = new int[1][0];
                //output[0][0] = arr[index];
                return output;
            }
            else
            {
                return new int[0][0];
            }

        }
        int smallOutput[][] = countOfSubArrays(arr,index+1,k-arr[index]);
        int output1[][] = new int[smallOutput.length+arr.length-index][];
        int a = 0;
        for (int i = 0; i < smallOutput.length; i++)
        {
            output1[a++] = smallOutput[i];
        }
        int j=0;
        for(int i=a;i<output1.length;i++)
        {
            output1[i] = new int[j+1];
            for(j=0;j<output1[i].length;j++)
            {
                output1[i][j]=arr[j+index];
            }
        }

        int smallOutput2[][] = countOfSubArrays(arr,index+1,k);
        int output2[][] = new int[smallOutput2.length+arr.length-index][];
        int b = 0;
        for (int i = 0; i < smallOutput2.length; i++)
        {
            output2[a++] = smallOutput2[i];
        }
         j=0;
        for(int i=a;i<output2.length;i++)
        {
            output2[i] = new int[j+1];
            for(j=0;j<output2[i].length;j++)
            {
                output2[i][j]=arr[j+index];
            }
        }

        int output[][] = new int[output1.length+output2.length][];
        int ind = 0;
        for(int i=0;i<output2.length;i++)
        {
            output[ind++] = output2[i];
        }
        for(int i=0 ; i<output1.length;i++)
        {
            output[ind++]  = new int[output1[i].length+1];
            output[ind][0] = arr[index];
            for(j=1;j<output1.length;j++)
            {
                output[ind][j] = output1[i][j-1];
            }
        }


return output;
    }


}
