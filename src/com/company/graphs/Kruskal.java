package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
  private static List<GraphNode> nodeList;
  private static List<UndirectedEdge> edgeList = new ArrayList<>();
  public Kruskal(List<GraphNode> nodeList) {
    this.nodeList = nodeList;
  }

  public static void main(String[] args) {
    List<GraphNode> nodeList = new ArrayList<>();
    for(int i=0;i<5;i++)
    {
      nodeList.add(new GraphNode(""+(char)(i+65) , i));
    }

    Kruskal graph = new Kruskal(nodeList);
    graph.addWeightedEdge(1,2,15);
    graph.addWeightedEdge(1,3,20);
    graph.addWeightedEdge(2,4,5);
    graph.addWeightedEdge(2,3,13);
    graph.addWeightedEdge(3,4,10);
    graph.addWeightedEdge(3,5,6);
    graph.addWeightedEdge(4,5,8);

    minCost();
  }

  private static void minCost() {
    int cost = 0;
    DisjointSet.makeSet(nodeList);

    Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
      @Override
      public int compare(UndirectedEdge o1, UndirectedEdge o2) {
        return o1.getWeight() - o2.getWeight();
      }
    };
    Collections.sort(edgeList,comparator);
    for(UndirectedEdge edge : edgeList)
    {
      GraphNode first = edge.getFirst();
      GraphNode second = edge.getSecond();
      if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second)))
      {
        System.out.println(edge);
        DisjointSet.union(first,second);
        cost = cost + edge.getWeight();
      }
    }
    System.out.println(cost);
  }

  void addWeightedEdge(int i, int j, int dis) {
    UndirectedEdge edge = new UndirectedEdge(nodeList.get(i-1),nodeList.get(j-1),dis);
    edgeList.add(edge);
    GraphNode vertex1 = nodeList.get(i-1);
    GraphNode vertex2 = nodeList.get(j-1);
    vertex1.getNeightbours().add(vertex2);
    vertex2.getNeightbours().add(vertex1);
    vertex1.getWeightMap().put(vertex2,dis);
    vertex2.getWeightMap().put(vertex1,dis);
  }
}
