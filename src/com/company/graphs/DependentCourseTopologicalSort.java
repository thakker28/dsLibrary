package graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DependentCourseTopologicalSort {
  private static List<Node> nodeList;

  public DependentCourseTopologicalSort(List<Node> nodeList) {
    this.nodeList = nodeList;
  }

  static class Node{
    public Node(int vertexId) {
      this.vertexId = vertexId;
    }

    public int getVertexId() {
      return vertexId;
    }

    public void setVertexId(int vertexId) {
      this.vertexId = vertexId;
    }

    public int getDepth() {
      return depth;
    }

    public void setDepth(int depth) {
      this.depth = depth;
    }

    int vertexId;
    int depth;

    public List<Node> getNeighbours() {
      return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
      this.neighbours = neighbours;
    }

    List<Node> neighbours = new ArrayList<>();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int courses = scanner.nextInt();
    List<Node> nodeList = new ArrayList<>();
    for(int i=0;i<courses;i++){
      nodeList.add(new Node(i));
    }

    DependentCourseTopologicalSort graph = new DependentCourseTopologicalSort(nodeList);
    int edges = scanner.nextInt();
    int i = 0;
    while (i<edges){
      int first = scanner.nextInt();
      int second = scanner.nextInt();
      DependentCourseTopologicalSort.addDirectedEdge(second,first);
      nodeList.get(first).depth++;
      i++;
    }

    System.out.println(canFinish(nodeList,courses));

  }

  private static void addDirectedEdge(int source, int destination){
    nodeList.get(source).getNeighbours().add(nodeList.get(destination));
  }


  private static boolean canFinish(List<Node> nodeList , int courses) {
    Queue<Node> queue = new LinkedList<>();
    for(Node node : nodeList){
      if(node.depth==0){
        queue.add(node);
      }
    }
    int count = queue.size();

    while (!queue.isEmpty()){
      Node current = queue.remove();
      for (Node neighbour : current.getNeighbours()){
        neighbour.depth--;
        if(neighbour.depth==0){
          queue.add(neighbour);
          count++;
        }
      }
    }
    return count == courses;

  }


}
