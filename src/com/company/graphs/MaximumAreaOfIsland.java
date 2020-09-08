package graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MaximumAreaOfIsland {
  private static int max = 0;
  static class Node{
    int val;
    List<Node> neighbours;
    boolean isVisited;
    Node(int val){
      this.val = val;
      neighbours = new ArrayList<>();
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int arr[][] = new int[n][m];
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        arr[i][j] = scanner.nextInt();
      }
    }
    HashMap<Integer,Node> map = new HashMap<>();
    Node node = null;
    int key;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(arr[i][j] ==1){
          key = i*m+j;
          node = map.get(key);
          if(node == null){
            node = new Node(key);
            map.put(key,node);
          }

          if(j+1<m && arr[i][j+1]==1){ //right neighbour
            key = i*m+j+1;
            Node neighbour = map.get(key);
            if(neighbour==null){
              neighbour = new Node(key);
              map.put(key,neighbour);
            }
            node.neighbours.add(neighbour);
          }

          if(j-1>=0 && arr[i][j-1]==1){ //left neighbour
            key = i*m+j-1;
            Node neighbour = map.get(key);
            if(neighbour==null){
              neighbour = new Node(key);
              map.put(key,neighbour);
            }
            node.neighbours.add(neighbour);
          }

          if(i-1>=0 && arr[i-1][j]==1){ //up neighbour
            key = (i-1)*m+j;
            Node neighbour = map.get(key);
            if(neighbour==null){
              neighbour = new Node(key);
              map.put(key,neighbour);
            }
            node.neighbours.add(neighbour);
          }

          if(i+1<n && arr[i+1][j]==1){ //down neighbour
            key = (i+1)*m+j;
            Node neighbour = map.get(key);
            if(neighbour==null){
              neighbour = new Node(key);
              map.put(key,neighbour);
            }
            node.neighbours.add(neighbour);
          }
        }
      }
    }

    for(Node vertex : map.values()){
      if(!vertex.isVisited){
        maxArea(vertex);
      }
    }
    System.out.println(max);

  }

  private static void maxArea(Node node) {
    int ans = 0;
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    node.isVisited = true;
    ans++;
    while (!queue.isEmpty()){
      Node current = queue.remove();
      for (Node neighbour : current.neighbours){
        if(!neighbour.isVisited){
          queue.add(neighbour);
          neighbour.isVisited= true;
          ans++;
        }
      }
    }
    max = Math.max(max,ans);
  }
}
