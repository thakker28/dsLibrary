package heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKsortedArrays {
  static class Pair implements Comparable<Pair>{
    int value ;
    int nextIndex;
    Pair(int value , int index ){
      this.value = value ;
      this.nextIndex = index;
    }

    @Override
    public int compareTo(Pair p){
      return this.value - p.value;
    }
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner (System.in);
    int k = scanner.nextInt();
    int n = scanner.nextInt();
    int arr[] = new int[k*n];
    int output[] = new int[k*n];
    int i =0;
    while(i<k*n){
      arr[i] = scanner.nextInt();
      i++;
    }
    sortArray(arr,k,n,output);
    for(int element : output)
    {
      System.out.print(element+" ");
    }

  }
  private static void sortArray(int[] arr , int k , int n , int[] output)
  {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>();
    for(int i=0;i<arr.length;i=i+n)
    {
      minHeap.add(new Pair(arr[i],i+1));
    }

    int i =0;
    while(minHeap.peek().value!=Integer.MAX_VALUE){
      Pair smallest = minHeap.poll();
      output[i] = smallest.value;
      i++;
      int index = smallest.nextIndex;
      int indexValue = index +1 ;
        if((index) % n==0){
          minHeap.add(new Pair(Integer.MAX_VALUE,indexValue));
        }
        else{
          minHeap.add(new Pair(arr[index],indexValue));
        }
    }
  }
}
