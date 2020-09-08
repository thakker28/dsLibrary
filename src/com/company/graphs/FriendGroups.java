package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class FriendGroups {
  static class Node {
    public Node(int value) {
      this.value = value;
      neighbours = new ArrayList<>();
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public boolean isVisited() {
      return visited;
    }

    public void setVisited(boolean visited) {
      this.visited = visited;
    }

    public List<Node> getNeighbours() {
      return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
      this.neighbours = neighbours;
    }

    int value;
    boolean visited;
    List<Node> neighbours;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Node> nodeList = new ArrayList<>();
    int n = scanner.nextInt();
    for(int i =0 ; i<n; i++){
      nodeList.add(new Node(i));
    }
    int arr[][] = new int[n][n];
    for( int i =0 ;i <n;i++){
      for(int j = 0 ; j<n; j++){
        arr[i][j] = scanner.nextInt();
        if(arr[i][j] ==1){
          nodeList.get(i).getNeighbours().add(nodeList.get(j));
        }
      }
    }
    int ans = 0;
    for(Node node : nodeList){
      if(!node.isVisited()){
        ans++;
        friendCircle(node);
      }
    }
    System.out.println(ans);
  }

  private static void friendCircle(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()){
      Node current = queue.remove();
      current.setVisited(true);
      for(Node neighbour : current.getNeighbours()){
        if(!neighbour.isVisited()){
          queue.add(neighbour);
        }
      }
    }
  }
}
