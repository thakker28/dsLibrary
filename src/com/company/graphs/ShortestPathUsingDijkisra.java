package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPathUsingDijkisra {
  private static List<GraphNode> nodeList;
  public ShortestPathUsingDijkisra(List<GraphNode> nodeList) {
    this.nodeList = nodeList;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<GraphNode> nodeList = new ArrayList<>();
    for(int i=0;i<5;i++){
      nodeList.add(new GraphNode(""+(char)(65+i)));
    }

    ShortestPathUsingDijkisra graph = new ShortestPathUsingDijkisra(nodeList);
    graph.addWeightedEdge(1,3,6); //Add A-> C , weight 6
    graph.addWeightedEdge(1,4,3); //Add A-> D , weight 3
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
    PriorityQueue<GraphNode> queue = new PriorityQueue<>();
    queue.addAll(nodeList);
    while (!queue.isEmpty()){
      GraphNode current = queue.remove();
     // current.setVisited(true);
      for(GraphNode neighbour : current.getNeightbours())
      {

          if(current.getDistance() + current.getWeightMap().get(neighbour) < neighbour.getDistance())
          {
            neighbour.setDistance(current.getDistance() + current.getWeightMap().get(neighbour));
            neighbour.setParent(current);
            queue.remove(neighbour);
            queue.add(neighbour);
          }

       //   neighbour.setVisited(true);
        }

    }

    for(GraphNode node : nodeList){
      System.out.print("Node "+node.getName()+ " , Distance : "+node.getDistance()+ " , Path : " );
      printPath(node);
      System.out.println("");
    }
  }

  private static void printPath(GraphNode node) {
    if(node.getParent() != null)
    {
      printPath(node.getParent());
    }
    System.out.print(node.getName() + " ");
  }


  private void addWeightedEdge(int i, int j, int dis) {
    GraphNode vertex1 = nodeList.get(i-1);
    GraphNode vertex2 = nodeList.get(j-1);
    vertex1.getNeightbours().add(vertex2);
    vertex1.getWeightMap().put(vertex2,dis);
  }
}
