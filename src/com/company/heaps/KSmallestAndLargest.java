package heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KSmallestAndLargest {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i = 0;
    while (i<n){
      arr[i] = scanner.nextInt();
      i++;
    }
    int k = scanner.nextInt();

    int smallest = findKSmallest (arr,k);
    int largest = findKLargest (arr,k);
    System.out.println("Kth Smallest number is "+smallest);
    System.out.println("Kth Largest number is "+largest);
  }

  private static int findKLargest(int[] arr, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int a  : arr){
      minHeap.add(a);
      if(minHeap.size() >k){
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }

  private static int findKSmallest(int[] arr, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for(int a  : arr){
      maxHeap.add(a);
      if(maxHeap.size() >k){
        maxHeap.poll();
      }
    }
    return maxHeap.peek();
  }
}
