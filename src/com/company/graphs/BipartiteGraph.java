package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
class Node
{
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Node> getNeighbours() {
    return neighbours;
  }

  public void setNeighbours(List<Node> neighbours) {
    this.neighbours = neighbours;
  }

  int id;
  List<Node> neighbours;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  String color;

  public Node(int id) {
    this.id = id;
    this.neighbours = new ArrayList<>();
    color = "white";
  }
}

public class BipartiteGraph {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int i =0;
    List<Integer> addedVertices = new ArrayList<>();
    List<Node> nodeList = new ArrayList<>();
    while (i<n)
    {
      int vertex1 = scanner.nextInt();
      int vertex2 = scanner.nextInt();
      if(!addedVertices.contains(vertex1))
      {
        addedVertices.add(vertex1);
        nodeList.add(new Node(vertex1));
      }
      if(!addedVertices.contains(vertex2)){
        addedVertices.add(vertex2);
        nodeList.add(new Node(vertex2));
      }
      BipartiteGraph.addDirectedEdge(vertex1,vertex2,nodeList);
      i++;
    }
    boolean ans = isBipartite(nodeList.get(0));
    System.out.println(ans);
  }

  private static boolean isBipartite(Node sourceNode) {
    Queue<Node> queue = new LinkedList<>();
    sourceNode.setColor("Blue");
    queue.add(sourceNode);

    while (!queue.isEmpty())
    {
      Node current = queue.remove();
      for(Node neighbour : current.getNeighbours()){
        if (neighbour.getColor().equals("white")){
          if(current.getColor()=="Red"){
            neighbour.setColor("Blue");
          }
          else{
            neighbour.setColor("Red");
          }
          queue.add(neighbour);
        }
        else{
          if(neighbour.getColor().equals(current.getColor())){
            return false;
          }
        }
      }
    }
    return true;
  }

  private static void addDirectedEdge(int vertex1, int vertex2, List<Node> nodeList) {
    Node node1 = null;
    Node node2 = null;
    for (Node node : nodeList){
      if(node.getId() == vertex1)
      {
        node1 = node;
      }
      else if(node.getId() == vertex2){
        node2 = node;
      }
    }
    node1.getNeighbours().add(node2);
    node2.getNeighbours().add(node1);
  }
}
