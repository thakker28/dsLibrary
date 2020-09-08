package arraysandstrings;

import java.util.Scanner;

public class MaximumSubarray {
    static class SumIndexPair
    {
        int count;
        int sum;
        SumIndexPair(int sum , int count)
        {
            this.sum =sum;
            this.count =count;
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int resArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            int arr[] = new int[size];
            int j = 0;
            while (j < size) {
                arr[j] = scanner.nextInt();
                j++;
            }
            resArr[i] = subArray(arr, 0,Integer.MIN_VALUE).count;
          //  resArr[i] = kadane(arr);
        }
        for (int i = 0; i < resArr.length; i++) {
            System.out.println(resArr[i]);
        }
    }



    private static int kadane(int[] arr) {
        int currentSum =0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            currentSum = currentSum+arr[i];
            if(maxSum<=currentSum)
            {
                maxSum = currentSum;
            }
            if(currentSum<0)
            {
                currentSum=0;
            }
        }
        return maxSum;
    }

    private static SumIndexPair subArray(int[] arr, int index,int count) {

        if (index == arr.length) {
            SumIndexPair pair = new SumIndexPair(0,count);
            return pair;
        }
        SumIndexPair pair = subArray(arr, index + 1 , count );
        int smallOutput = pair.sum;
         count =pair.count;
      //   count  = subArray(arr, index + 1 ,count).count;
        if(smallOutput<0)
        {
            count = Math.max(arr[index],count);
            return new SumIndexPair(arr[index],count);
        }
       count = Math.max(arr[index]+smallOutput,count);

       return new SumIndexPair(arr[index]+smallOutput,count);
//        if(index==arr.length-1)
//        {
//            SumIndexPair pair = new SumIndexPair(index,sum);
//            return pair;
//        }
//        SumIndexPair excludingFirst = subArray(arr,index+1,sum+arr[index+1]);
//        int sumExcludingFirst = excludingFirst.sum;
//        SumIndexPair includingFirst =subArray(arr,index+1,sum+arr[index]);
//        int sumIncludingFirst = includingFirst.sum;
//        return new SumIndexPair(index,Math.max(sumExcludingFirst,sumIncludingFirst));
    }
}
