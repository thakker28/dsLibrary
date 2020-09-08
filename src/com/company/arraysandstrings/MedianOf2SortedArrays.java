package arraysandstrings;

import java.util.Scanner;

public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[m];
        int i = 0;

        while(i<n)
        {
            arr1[i] = scanner.nextInt();
            i++;
        }
        i=0;
        while (i<m)
        {
            arr2[i] = scanner.nextInt();
            i++;
        }
     //   float f = 2.5f;
        double d = (median(arr1,arr2));
        System.out.println(d);
//        if(f==d)
//        {
//            System.out.println("same");
//        }
    }

    private static double median(int[] arr1, int[] arr2) {
        int medianIndex1;
        int medianIndex2;
        int currentIndex = 0;
        int i = 0; // iterator for array 1
        int j = 0 ; //iterator for array2;
        int median1 = 0; // Median 1 value
        int median2 = 0;  // median 2 value
        if((arr1.length+arr2.length)%2 !=0) // Odd number of elements so there would be only one element contributing to median
        {
             medianIndex1 = (arr1.length+arr2.length-1)/2;
             while (i<arr1.length && j<arr2.length)
             {
                 if(arr1[i]<=arr2[j])
                 {
                    if(currentIndex==medianIndex1)
                    {
                        return arr1[i];
                    }
                     i++;
                 }
                 else
                 {

                    if(currentIndex==medianIndex1)
                    {
                        return arr2[j];
                    }
                     j++;
                 }
                 currentIndex++;
//                 if(currentIndex==medianIndex1)
//                 {
//                     return Math.max(arr1[i-1],arr2[j-1]);
//                 }
             }
             if(i==arr1.length)
             {
                 while(currentIndex<medianIndex1)
                 {
                     currentIndex++;
                     j++;
                 }
                 return arr2[j];
             }
             if(j==arr2.length)
             {
                 while(currentIndex<medianIndex1)
                 {
                     currentIndex++;
                     i++;
                 }
                 return arr1[i];
             }
        }
        else
        {
            double medianIndex = (arr1.length+arr2.length-1)/2.0;
            medianIndex1 = (int) medianIndex;
            medianIndex2 = (int) medianIndex+1;
            while (i<arr1.length && j<arr2.length)
            {

                if(arr1[i]<=arr2[j])
                {
                    median1 = currentIndex==medianIndex1 ? arr1[i] : median1;
                    median2 = currentIndex==medianIndex2 ? arr1[i] : median2;
                    i++;
                }
                else
                {
                    median1 = currentIndex==medianIndex1 ? arr2[j] : median1;
                    median2 = currentIndex==medianIndex2 ? arr2[j] : median2;
                    j++;
                }
                currentIndex++;
                if(currentIndex==medianIndex2+1)
                {
                    return (median1+median2)/2.0;
                }
//                if(currentIndex==medianIndex1)
//                {
//                    median1 = Math.max(arr1[i-1],arr2[j-1]);
//                }
//                if(currentIndex==medianIndex2)
//                {
//                    median2 = Math.max(arr1[i-1],arr2[j-1]);
//                    return (median1+median2)/2.0;
//                }
            }
            if(i==arr1.length)
            {
                while (currentIndex<=medianIndex1 && currentIndex<medianIndex2)
                {
                    if(currentIndex == medianIndex1)
                    {
                        median1  = arr2[j];
                    }
                    currentIndex++;
                    j++;

                }
                median2 = arr2[j];
                return (median1+median2)/2.0;
            }
            if(j==arr2.length)
            {
               // currentIndex++;
                while (currentIndex<=medianIndex1 && currentIndex<medianIndex2)
                {
                    if(currentIndex == medianIndex1)
                    {
                        median1  = arr1[i];
                    }
                    currentIndex++;
                    i++;
                }
                median2 = arr1[i];
                return (median1+median2)/2.0;
            }

        }
        return (median1+median2)/2.0;

    }

}
