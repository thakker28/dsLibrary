package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class KnightMoves {
  static class Node{
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
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

    int x ;
   int y;

    public boolean isVisited() {
      return isVisited;
    }

    public void setVisited(boolean visited) {
      isVisited = visited;
    }

    boolean isVisited;
    public int getDistance() {
      return distance;
    }

    public void setDistance(int distance) {
      this.distance = distance;
    }

    public List<Node> getNeighbours() {
      return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
      this.neighbours = neighbours;
    }

    int distance;
   List<Node> neighbours = new ArrayList<>();

  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int startRow = scanner.nextInt();
    int startColumn = scanner.nextInt();
    int endRow = scanner.nextInt();
    int endColumn = scanner.nextInt();
    int moves = knightMoves(n,m,startRow,startColumn,endRow,endColumn);
    System.out.println(moves);
  }

  private static int knightMoves(int n, int m, int startRow, int startColumn, int endRow, int endColumn) {
    Queue<Node> queue = new LinkedList<>();
    Node node = new Node(startRow,startColumn);
    node.setDistance(0);
    queue.add(node);
    node.setVisited(true);
    boolean visited[][] = new boolean[n][m];
    visited[startRow][startColumn]= true;
    int x[] = {-1,1,-2,2,-2,2,-1,1};
    int y[] = {2,2,1,1,-1,-1,-2,-2};
    while (!queue.isEmpty()){
      Node current = queue.remove();
      if(current.x==endRow && current.y==endColumn){
        return current.distance;
      }

      for(int k=0;k<8;k++){//Total 8 possible moves
        int startX = current.x + x[k];
        int startY = current.y + y[k];
        if(startX>=0 && startX<n && startY>=0 && startY<m && !visited[startX][startY]){
          Node newNode = new Node(startX,startY);
          newNode.setDistance(current.distance+1);
          visited[startX][startY] = true;
          queue.add(newNode);
        }
      }
    }
return -1;
  }
}
