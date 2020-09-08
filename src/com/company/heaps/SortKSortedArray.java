package heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortKSortedArray {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i =0;
    while (i<n){
      arr[i] = scanner.nextInt();
      i++;
    }
    int k = scanner.nextInt();
    System.out.println("Array after sorting is ");
    sortArray (arr , k);
  }

  private static void sortArray(int[] arr, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int element : arr){
      minHeap.add(element);
      if ( minHeap.size() >k)
      {
        System.out.print(minHeap.poll() + " ");
      }
    }
    while (!minHeap.isEmpty()){
      System.out.print(minHeap.poll()+" ");
    }
  }
}
