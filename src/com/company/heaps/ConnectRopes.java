package heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectRopes {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i = 0;
    while (i<n){
      arr[i] = scanner.nextInt();
      i++;
    }
    int cost = findMinCost(arr);
    System.out.println(cost);
  }

  private static int findMinCost(int[] arr) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int element : arr){
      minHeap.add(element);
    }
    int cost = 0;
    while (minHeap.size()>1){
      int minRope1 = minHeap.poll();
      int minRope2 = minHeap.poll();
      cost = cost + minRope1 + minRope2;
      minHeap.add(minRope1+minRope2);
    }
    return cost;
  }
}
