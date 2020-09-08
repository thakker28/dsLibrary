package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

  private static List<GraphNode> nodeList;
  private static Stack stack = new Stack();
  public TopologicalSort(List<GraphNode> nodeList) {
    this.nodeList = nodeList;
  }

  public static void main(String[] args) {

    List<GraphNode> nodeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int nodes = scanner.nextInt();
    for(int i=1 ;i <=nodes;i++)
    {
      nodeList.add(new GraphNode(scanner.next(),i-1));
    }

    TopologicalSort graph = new TopologicalSort(nodeList);
//    int edges = scanner.nextInt();
//    for(int i=0;i<edges;i++){
//      String edge = scanner.nextLine();
//      graph.addDirectedEdge(edge);
//    }

    graph.addDirectedEdge("1-2");
    graph.addDirectedEdge("2-1");
//    graph.addDirectedEdge("2-3");
//    graph.addDirectedEdge("2-4");
//    graph.addDirectedEdge("3-5");
//    graph.addDirectedEdge("5-8");
//    graph.addDirectedEdge("5-6");
//    graph.addDirectedEdge("4-6");
//    graph.addDirectedEdge("6-7");

    topologicalSort();
    while (!stack.isEmpty()){
      System.out.print(stack.pop()+" ");
    }
  }

  private static void topologicalSort() {
    for(GraphNode node : nodeList){
      if(!node.isVisited)
      {
        topologicalSortVisit(node);
      }
    }
  }

  private static void topologicalSortVisit(GraphNode node) {

    for(GraphNode neighbour : node.getNeightbours())
    {
      if(!neighbour.isVisited){
        topologicalSortVisit(neighbour);
      }

    }

      stack.push(node.getName());
      node.setVisited(true);

  }

  private void addDirectedEdge(String edge) {
    String vertex[] = edge.split("-");
    int index1 = Integer.parseInt(vertex[0]);
    int index2 = Integer.parseInt(vertex[1]);

    GraphNode vertex1 = nodeList.get(index1-1);
    GraphNode vertex2 = nodeList.get(index2-1);
    vertex1.getNeightbours().add(vertex2);
  }

}
