package heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SumOfElementsBetweenTwoKSmallestNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i = 0;
    while(i<n){
      arr[i] = scanner.nextInt();
      i++;
    }
    int k1 = scanner.nextInt();
    int k2 = scanner.nextInt();
    int sum = findSumBetweenK1AndK2(arr,k1,k2);
    System.out.println(sum);
  }

  private static int findSumBetweenK1AndK2(int[] arr, int k1, int k2) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    if(k2>arr.length){
      return -1;
    }
    int sum = 0;
    for(int element : arr){
      maxHeap.add(element);
      if(maxHeap.size()>k2-1)
      {
        maxHeap.remove();
      }
    }
    while (maxHeap.size()>k1)
    {
      sum = sum+maxHeap.poll();
    }
    return sum;
  }
}
