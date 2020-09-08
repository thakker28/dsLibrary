package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WallsAndGates {
  static class Node{
    public Node(int x, int y , int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }

    public int getX() {
      return x;
    }

    public void setX(int x) {
      this.x = x;
    }

    public int getY() {
      return y;
    }

    public void setY(int y) {
      this.y = y;
    }

    public int getDistance() {
      return distance;
    }

    public void setDistance(int distance) {
      this.distance = distance;
    }

    int x;
    int y;
    int distance;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int input[][] = new int[n][m];
    for(int i=0;i<input.length;i++){
      for(int j=0;j<m;j++){
        input[i][j] = scanner.nextInt();
      }
    }
    int output[][] = wallsGates(n,m,input);
    for(int i=0;i<output.length;i++){
      for(int j=0;j<m;j++){
        System.out.print(output[i][j]+" ");
      }
      System.out.println(" ");
    }
  }

  private static int[][] wallsGates(int n, int m, int[][] input) {
    int output[][] = new int[n][m];
    output = input.clone();
    Queue<Node> queue = new LinkedList<>();
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(input[i][j]==0){
          Node shopNode = new Node(i,j,0);
          queue.add(shopNode);
        }
      }
    }
    boolean visited[][] = new boolean[n][m];
    while (!queue.isEmpty()){
      Node current = queue.remove();
      int i = current.x;
      int j = current.y;
      visited[i][j] = true;
      if(j-1>=0 && output[i][j-1] !=-1 && output[i][j-1]==Integer.MAX_VALUE)//Left neighbour
      {
          output[i][j-1] = current.distance+1;
          queue.add(new Node(i,j-1,current.distance+1));

      }
      if(j+1<m && output[i][j+1] !=-1 && output[i][j+1]==Integer.MAX_VALUE) // Right neighbour
      {
        output[i][j+1] = current.distance+1;
        queue.add(new Node(i,j+1,current.distance+1));
      }
      if(i-1>=0 && output[i-1][j] != -1 && output[i-1][j]==Integer.MAX_VALUE){
        output [i-1][j] = current.distance+1;
        queue.add(new Node(i-1,j,current.distance+1));
      }
      if(i+1<n && output[i+1][j] != -1 && output[i+1][j]==Integer.MAX_VALUE){
        output[i+1][j] = current.distance+1;
        queue.add(new Node(i+1,j,current.distance+1));
      }
    }
return output;
  }
}
