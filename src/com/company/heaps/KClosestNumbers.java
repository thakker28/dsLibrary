package heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestNumbers {
  static class Pair implements Comparable<Pair>{
    public Pair(int number, int closestValue) {
      this.number = number;
      this.closestValue = closestValue;
    }

    int number;
    int closestValue ;

    @Override
    public int compareTo(Pair p) {
      return this.closestValue - p.closestValue;
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i = 0;
    while (i<n)
    {
      arr[i] = scanner.nextInt();
      i++;
    }
    int x = scanner.nextInt();
    int k = scanner.nextInt();
    System.out.println("First "+k+ " closest numbers to "+x+" are :" );
    findClosestNumbers(arr,k ,x);
  }

  private static void findClosestNumbers(int[] arr, int k, int x) {
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for(int element : arr)
    {
      if(Math.abs(x-element) != 0)
      {
        maxHeap.add(new Pair(element , Math.abs(x-element)));
      }

      if(maxHeap.size()>k)
      {
        maxHeap.remove();
      }
    }
 for(Pair closestNumbers  : maxHeap)
 {
   System.out.print(closestNumbers.number+" ");
 }

  }
}
