package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsUsingAdjacencyList {

  private List<GraphNode> nodesList;

  public BfsUsingAdjacencyList(List<GraphNode> nodeList) {
    this.nodesList = nodeList;
  }

  public void addUndirectedEdge(int i, int j) {

    GraphNode vertex1 = nodesList.get(i-1);
    GraphNode vertex2 = nodesList.get(j-1);

    vertex1.getNeightbours().add(vertex2);
    vertex2.getNeightbours().add(vertex1);
  }

  public void bfs(List<GraphNode> nodeList) {
    Queue<GraphNode> queue = new LinkedList<>();
    for(GraphNode node : nodeList){
      if(!node.isVisited)
      {
        queue.add(node);
        while (!queue.isEmpty()){
          GraphNode current = queue.remove();
          if(!current.isVisited){
            System.out.print(current.getName()+" ");
          }
          current.setVisited(true);
          List<GraphNode> neighbourNodes = current.getNeightbours();
          for(GraphNode neighbour : neighbourNodes){
            if(!neighbour.isVisited)
            {
              queue.add(neighbour);
            }
          }
        }
      }
    }
  }
}
