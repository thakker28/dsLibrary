package graphs;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathUsingBellmanFord {
  private static List<GraphNode> nodeList = new ArrayList<>();

  public ShortestPathUsingBellmanFord(List<GraphNode> nodeList) {
    this.nodeList = nodeList;
    for(GraphNode node : nodeList){
      node.setDistance(Integer.MAX_VALUE/10);
    }
  }

  public static void main(String[] args) {

    for(int i=0;i<5;i++)
    {
      nodeList.add(new GraphNode(""+(char)(i+65)));
    }

    ShortestPathUsingBellmanFord graph = new ShortestPathUsingBellmanFord(nodeList);
    graph.addWeightedEdge(1,3,6); //Add A-> C , weight 6
    graph.addWeightedEdge(1,4,-6); //Add A-> D , weight 3
    graph.addWeightedEdge(2,1,3); //Add B-> A , weight 3
    graph.addWeightedEdge(3,4,2); //Add C-> D , weight 2
    graph.addWeightedEdge(4,3,1); //Add D-> C , weight 1
    graph.addWeightedEdge(4,2,1); //Add D-> B , weight 1
    graph.addWeightedEdge(5,2,4); //Add E-> B , weight 4
    graph.addWeightedEdge(5,4,2); //Add E-> D , weight 2

    shortestPath(nodeList.get(4));
  }

  private static void shortestPath(GraphNode sourceNode) {
    sourceNode.setDistance(0);
    for(int i=0;i<nodeList.size()-1;i++) // loop for v-1 times
    {
      for(GraphNode node : nodeList)
      {
        for(GraphNode neighbour : node.getNeightbours())
        {
          if(node.getDistance() + node.getWeightMap().get(neighbour) < neighbour.getDistance())
          {
            neighbour.setDistance(node.getDistance()+node.getWeightMap().get(neighbour));
            neighbour.setParent(node);
          }
        }
      }
    }

    System.out.println("checking for -ve cycle");
    for(GraphNode node : nodeList)
    {
      for(GraphNode neighbour : node.getNeightbours())
      {
        if(neighbour.getDistance() > node.getDistance() + node.getWeightMap().get(neighbour))
        {
          System.out.println("-ve cycle is found, shortest path cannot be calculated");
          return;
        }
      }
    }
    System.out.println("-ve cycle is not found");

    for(GraphNode node : nodeList)
    {
      System.out.print("Node "+node.getName()+" , Distance : "+node.getDistance()+" path : ");
      printPath(node);
      System.out.println("");
    }


  }

  private static void printPath(GraphNode node) {
    if(node.getParent() != null){
      printPath(node.getParent());
    }
    System.out.print(node.getName()+" ");
  }

  private void addWeightedEdge(int i, int j, int dis) {
    GraphNode vertex1 = nodeList.get(i-1);
    GraphNode vertex2 = nodeList.get(j-1);
    vertex1.getNeightbours().add(vertex2);
    vertex1.getWeightMap().put(vertex2,dis);
  }
}
