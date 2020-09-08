package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIslands {

  static class Node {
    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public boolean isVisited() {
      return isVisited;
    }

    public void setVisited(boolean visited) {
      isVisited = visited;
    }

    public List<Node> getNeighbours() {
      return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
      this.neighbours = neighbours;
    }

    int value;
    boolean isVisited;
    List<Node> neighbours;

    public Node(int value) {
      this.value = value;
      neighbours = new ArrayList<>();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    char arr[][] = new char[n][m];
    for (int i = 0; i < n; i++) {
      String temp = scanner.next();
      for (int j = 0; j < m; j++) {
        arr[i][j] = temp.charAt(j);
      }
    }
    Map<Integer , Node> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        Node node = null;
        Node horizontal = null;
        Node vertical = null;
        int key;
        if (arr[i][j] == '1') {
          key = i * m + j;
          if (!map.containsKey(key)) {
            node = new Node(i * m + j);
            map.put(key, node);
          }
          node = map.get(key);

            if (j + 1 < m && arr[i][j + 1] == '1') {
              key = (i * m) + (j + 1);
              if (!map.containsKey(key)) {
                horizontal = new Node((i * m) + j + 1);
                map.put(key, horizontal);
              }
              horizontal = map.get(key);
              node.getNeighbours().add(horizontal);
            }
          if (j - 1 >= 0 && arr[i][j - 1] == '1') {
            key = (i * m) + (j - 1);
            if (!map.containsKey(key)) {
              horizontal = new Node((i * m) + j - 1);
              map.put(key, horizontal);
            }
            horizontal = map.get(key);
            node.getNeighbours().add(horizontal);
          }
            if (i + 1 < n && arr[i + 1][j] == '1') {
              key = (i + 1) * m + j;
              if (!map.containsKey(key)) {
                vertical = new Node((i + 1) * m + j);
                map.put(key, vertical);
              }
              vertical = map.get(key);
              node.getNeighbours().add(vertical);
            }

          if (i - 1 >= 0 && arr[i - 1][j] == '1') {
            key = (i - 1) * m + j;
            if (!map.containsKey(key)) {
              vertical = new Node((i - 1) * m + j);
              map.put(key, vertical);
            }
            vertical = map.get(key);
            node.getNeighbours().add(vertical);
          }
          }
      }
    }
    int island = 0;
    for(Node node : map.values()){
      if(!node.isVisited){
        island++;
        numberOfIsland(node);
      }
    }
    System.out.println(island);
  }

  private static void numberOfIsland(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()){
      Node current = queue.remove();
      current.setVisited(true);
      for(Node neighbour : current.getNeighbours()){
        if(!neighbour.isVisited){
          queue.add(neighbour);
        }
      }
    }
  }
}
