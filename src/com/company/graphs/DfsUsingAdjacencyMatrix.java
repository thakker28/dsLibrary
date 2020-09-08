package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DfsUsingAdjacencyMatrix {

  private List<GraphNode> nodeList;
  private int[][] matrix;

  DfsUsingAdjacencyMatrix(List<GraphNode> nodeList){
    this.nodeList = nodeList;
    matrix = new int[nodeList.size()][nodeList.size()];
  }

  public void addUndirectedEdge(int vertex1 , int vertex2) {
    matrix[vertex1-1][vertex2-1] = 1; // vertex(i) are stored with index as i-1
    matrix[vertex2-1][vertex1-1] = 1;
  }

  public void dfs(List<GraphNode> nodeList) {

    Stack<GraphNode> stack = new Stack<>();
    for(GraphNode node : nodeList){
      if(!node.isVisited)
      {
        stack.push(node);
      }

      while (!stack.isEmpty()){
        GraphNode current = stack.pop();
        if(!current.isVisited){
          System.out.print(current.getName()+" ");
        }
        current.setVisited(true);
        List<GraphNode> neighbourNodes = getNeighbours(current);
        for(GraphNode neighbour : neighbourNodes){
          if(!neighbour.isVisited){
            stack.push(neighbour);
          }
        }
      }
    }
  }

  private List<GraphNode> getNeighbours(GraphNode current) {
    int index = current.getIndex();
    List<GraphNode> neighbourNodes = new ArrayList<>();
    for(int i=0;i<matrix.length;i++){
      if(matrix[index][i]==1)
      {
        neighbourNodes.add(nodeList.get(i));
      }
    }
    return neighbourNodes;
  }
}
