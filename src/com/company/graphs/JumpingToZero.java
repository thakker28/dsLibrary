package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class JumpingToZero {
  static class Node{
    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }

    public int getIndex() {
      return index;
    }

    public void setIndex(int index) {
      this.index = index;
    }

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

    int index;
    int value;
    boolean isVisited;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int start = scanner.nextInt();
    int values[] = new int[n];
    for(int i=0;i<n;i++)
    {
      values[i] = scanner.nextInt();
    }

    List<Node> nodeList = new ArrayList<>();
    for(int i=1;i<=values.length;i++)
    {
      nodeList.add(new Node(i,values[i-1]));
    }
    Node ans = jumpPossible(start,nodeList);
//    if(ans){
//      System.out.println("YES");
//    }
//    else{
//      System.out.println("NO");
//    }
    System.out.println(ans.index);
  }

  private static Node jumpPossible(int start ,List<Node> nodeList) {

    Queue<Node> indexQueue = new LinkedList<>();
    Node startNode = nodeList.get(start-1);
    indexQueue.add(startNode);
    while (!indexQueue.isEmpty())
    {
      Node current = indexQueue.remove();
      current.setVisited(true);
      if(current.value==0){
        return current;
      }
      int currentIndex = current.index;
      int index1 = currentIndex-current.value;
      int index2 = currentIndex + current.value;
      if(index1>0 && !nodeList.get(index1-1).isVisited)
      {
        indexQueue.add(nodeList.get(index1-1));
      }
      if(index2<=nodeList.size() && !nodeList.get(index2-1).isVisited)
      {
        indexQueue.add(nodeList.get(index2-1));
      }
    }
    return null;
  }
}
