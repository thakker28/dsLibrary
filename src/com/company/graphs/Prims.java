package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
  static List<GraphNode> nodeList = new ArrayList<>();
    public Prims(List<GraphNode> nodeList) {
      this.nodeList = nodeList;
  }

  public static void main(String[] args) {
    List<GraphNode> nodeList = new ArrayList<>();
    for(int i=0;i<5;i++)
    {
      nodeList.add(new GraphNode(""+(char)(i+65) , i));
    }

    Prims graph = new Prims(nodeList);
    graph.addWeightedEdge(1,2,15);
    graph.addWeightedEdge(1,3,20);
    graph.addWeightedEdge(2,4,5);
    graph.addWeightedEdge(2,3,13);
    graph.addWeightedEdge(3,4,10);
    graph.addWeightedEdge(3,5,6);
    graph.addWeightedEdge(4,5,8);

    minCost(nodeList.get(0));
  }

  private static void minCost(GraphNode sourceNode) {
      int cost = 0;
      for(GraphNode node : nodeList)
      {
        node.setDistance(Integer.MAX_VALUE);
      }
      sourceNode.setDistance(0);

    PriorityQueue<GraphNode> queue = new PriorityQueue<>();
    queue.addAll(nodeList);

    while (!queue.isEmpty())
    {
      GraphNode current = queue.remove();
      for(GraphNode neighbour : current.getNeightbours()){
        if(!neighbour.isVisited)
        {
          if(neighbour.getDistance() > neighbour.getWeightMap().get(current))
          {
            neighbour.setDistance(neighbour.getWeightMap().get(current));
            queue.remove(neighbour);
            queue.add(neighbour);
            neighbour.setParent(current);
          }

        }
        current.setVisited(true);
      }
    }

    for(GraphNode node : nodeList)
    {
      System.out.println("Node "+node+" Distance from SourceNode "+node.getParent()+
          " is"
          + " "+node.getDistance()+"");
      cost = cost + node.getDistance();
    }

    System.out.println("Total cost is :"+cost);

  }

  private void addWeightedEdge(int i, int j, int dis) {
      GraphNode vertex1 = nodeList.get(i-1);
      GraphNode vertex2 = nodeList.get(j-1);
      vertex1.getNeightbours().add(vertex2);
      vertex2.getNeightbours().add(vertex1);
      vertex1.getWeightMap().put(vertex2,dis);
      vertex2.getWeightMap().put(vertex1,dis);
  }

}
