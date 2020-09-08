package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsUsingAdjacencyMatrix {
  static List<GraphNode> nodesList;
  static int matrix[][];
  public BfsUsingAdjacencyMatrix(List<GraphNode> nodesList) {
    this.nodesList = nodesList;
    matrix = new int[nodesList.size()][nodesList.size()];
  }

  public static void main(String[] args) {
    List<GraphNode> nodesList = new ArrayList<>();
    for(int i=1;i<11;i++)
    {
      nodesList.add(new GraphNode("V"+i,i-1));
    }

    BfsUsingAdjacencyMatrix graph = new BfsUsingAdjacencyMatrix(nodesList);
    graph.addUndirectedEdge(1,2);
    graph.addUndirectedEdge(1,4);
    graph.addUndirectedEdge(2,3);
    graph.addUndirectedEdge(2,5);
    graph.addUndirectedEdge(3,6);
    graph.addUndirectedEdge(3,10);
    graph.addUndirectedEdge(4,7);
    graph.addUndirectedEdge(5,8);
    graph.addUndirectedEdge(6,9);
    graph.addUndirectedEdge(7,8);
    graph.addUndirectedEdge(8,9);
    graph.addUndirectedEdge(9,10);

   System.out.println("Printing the bfs of given graph ");
    bfs(nodesList);
  }

  private void addUndirectedEdge(int vertex1, int vertex2) {
    matrix[vertex1-1][vertex2-1] = 1;  // vertex(i) has index stored as i-1
    matrix[vertex2-1][vertex1-1] = 1;
  }

  private static void bfs(List<GraphNode> nodesList) {


    for (GraphNode node : nodesList) {
      Queue<GraphNode> queue = new LinkedList<>();
      if (!node.isVisited) {
        queue.add(node);


        while (!queue.isEmpty()) {
          GraphNode currentNode = queue.remove();
          if (!currentNode.isVisited) {
            System.out.print(currentNode.getName() + " ");
          }
          currentNode.setVisited(true);
          List<GraphNode> neighbours = getNeighbours(currentNode);
          for (GraphNode neighbourNode : neighbours) {
            if (!neighbourNode.isVisited) {
              queue.add(neighbourNode);
            }
          }
        }
      }
    }
  }
   private  static List<GraphNode> getNeighbours(GraphNode currentNode) {
    int index = currentNode.getIndex();
    List<GraphNode> neighboursList = new ArrayList<>();
    for(int i=0;i<matrix.length;i++)
    {
      if(matrix[index][i]==1)
      {
        neighboursList.add(nodesList.get(i));
      }
    }
    return neighboursList;
  }
}
