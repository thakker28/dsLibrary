package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
  private static List<Node> nodeList;
  public RottenOranges(List<Node> nodeList) {
    this.nodeList = nodeList;
  }

  static class Node{
    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public int getDepth() {
      return depth;
    }

    public void setDepth(int depth) {
      this.depth = depth;
    }

    public List<Node> getNeighbours() {
      return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
      this.neighbours = neighbours;
    }

    int value;
    int depth;
    List<Node> neighbours;

    public Node(int value) {
      this.value = value;
      depth = 0;
      neighbours = new ArrayList<>();
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int i = 0;
    List<Integer> ans = new ArrayList<>();
    while (i<n)
    {
      int rows = scanner.nextInt();
      int columns = scanner.nextInt();
      int arr[][] = new int[rows][columns];
      List<Node> nodeList = new ArrayList<>();
      for(int row = 0;row<rows;row++){
        for(int column = 0 ; column<columns; column++)
        {
          arr[row][column] = scanner.nextInt();
          nodeList.add(new Node(arr[row][column]));

        }
      }
      RottenOranges graph = new RottenOranges(nodeList);
      ans.add(timeToRot(arr , nodeList , columns));
      i++;
    }
    for(int a : ans){
      System.out.print(a+" ");
    }
  }

  private static int timeToRot(int[][] arr ,List<Node> nodeList , int columns ) {
    for(int i=0;i<nodeList.size();i++){
      int up = i - columns;
      int down = i + columns;
      Node current = nodeList.get(i);
      int right ;
      int left ;
      if(i%columns==0) // left neighbour is not possible
      {
        right = i+1;
        current.getNeighbours().add(nodeList.get(right));
      }
     else if((i+1)%columns==0){ //right neighbour is not possible
        left = i-1;
        current.getNeighbours().add(nodeList.get(left));
      }
     else
      {
        left = i-1;
        right = i+1;
        current.getNeighbours().add(nodeList.get(left));
        current.getNeighbours().add(nodeList.get(right));
      }


      if(up>=0){
        current.getNeighbours().add(nodeList.get(up));
      }
      if(down<nodeList.size()){
        current.getNeighbours().add(nodeList.get(down));
      }

    }

    int maxDepth = minTimeToRot(nodeList);
    for(Node node : nodeList){
      if(node.value==1){
        return -1;
      }
    }
    return maxDepth;
  }

  private static int minTimeToRot(List<Node> nodeList) {
    Queue<Node> queue = new LinkedList<>();
    for(Node node : nodeList){
      if(node.value==2){
        queue.add(node);
      }
    }
    int maxDepth = 0;
    while (!queue.isEmpty()){
      Node current = queue.remove();
      for(Node neighbour : current.getNeighbours()){
        if(neighbour.value==1){
          neighbour.value = 2;
          neighbour.depth = current.depth +neighbour.depth;
          maxDepth = Math.max(maxDepth,neighbour.depth);
          queue.add(neighbour);
        }
      }
    }
    return maxDepth;
  }
}
