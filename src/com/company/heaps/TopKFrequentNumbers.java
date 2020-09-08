package heaps;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map;
public class TopKFrequentNumbers {
  static class Pair implements Comparable<Pair>{
    int number ;
    int frequency;

    public Pair(int number, int frequency) {
      this.number = number;
      this.frequency = frequency;
    }

    @Override
    public int compareTo(Pair p) {
      if (this.frequency == p.frequency)
      {
        return p.number - this.number;
      }

      return this.frequency - p.frequency;
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i = 0;
    while (i < n)
    {
      arr[i] = scanner.nextInt();
      i++;
    }

    int k = scanner.nextInt();

    System.out.println("Printing first "+k+" frequent numbers in the array");
    printKFrequent(arr,k);
  }

  private static void printKFrequent(int[] arr, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int number : arr)
    {
      map.put(number,map.getOrDefault((number),0)+1);
    }

    PriorityQueue<Pair> minHeap = new PriorityQueue<>();
    for (Map.Entry<Integer,Integer> entry : map.entrySet())
    {
      minHeap.add(new Pair(entry.getKey(), entry.getValue()));
      if(minHeap.size()>k)
      {
        minHeap.remove();
      }
    }
    while (!minHeap.isEmpty())
    {
      System.out.print(minHeap.poll().number+" ");
    }
  }

}
