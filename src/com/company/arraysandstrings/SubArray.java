package arraysandstrings;

import java.util.Scanner;

public class SubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while(i<n)
        {
            arr[i]  =scanner.nextInt();
            i++;
        }
        int resArr[][] = subArray(arr,0);
        for(i=0;i<resArr.length;i++)
        {
            for(int j=0;j<resArr[i].length;j++)
            {
                System.out.print(resArr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static int[][] subArray(int arr[] , int index) {
//        if(index==arr.length-1)
//        {
//            int output[][] = new int[1][1];
//            output[0][0]=arr[index];
//            return output;
//        }
        if(index ==arr.length)
        {
            return new int[0][0];
        }
        int smalloutput[][] = subArray(arr, index + 1);
        int output[][] = new int[smalloutput.length + arr.length - index][];
        int k = 0;
        for (int i = 0; i < smalloutput.length; i++)
        {
            output[k++] = smalloutput[i];
        }
        int j=0;
        for(int i=k;i<output.length;i++)
        {
            output[i] = new int[j+1];
            for(j=0;j<output[i].length;j++)
            {
                output[i][j]=arr[j+index];
            }
        }
        return output;
    }


}
