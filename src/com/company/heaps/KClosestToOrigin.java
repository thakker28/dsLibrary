package heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestToOrigin {
  static class Pair implements Comparable<Pair>{
    int index ;
    int distance;

    public Pair(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Pair p) {
      return p.distance - this.distance;
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int arr[][] = new int[n][m];
    for(int i=0 ;i <n; i++)
    {
      for(int j=0;j<m;j++)
      {
        arr[i][j] = scanner.nextInt();
      }
    }
    int k = scanner.nextInt();
    findClosestPoints(arr,k);
  }

  private static void findClosestPoints(int[][] arr, int k) {
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
    for(int i=0;i<arr.length;i++)
    {
      // arr[i][0] : x coordinate
      // arr[i] [1] : y coordinate : Distance from origin : sqrt(x^2 + y^2) or we can exclude sqrt)
      maxHeap.add(new Pair(i , (int) (Math.pow(arr[i][0],2) + Math.pow(arr[i][1],2))));
      if(maxHeap.size()>k)
      {
        maxHeap.remove();
      }
    }

    while (!maxHeap.isEmpty())
    {
      int index = maxHeap.poll().index;
      System.out.print(arr[index][0]+ " "); // x coordinate
      System.out.print(arr[index][1]);      // y coordinate
      System.out.println(" ");
    }
  }
}
