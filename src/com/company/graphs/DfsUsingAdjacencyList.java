package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsUsingAdjacencyList {

  private List<GraphNode> nodeList;


  public DfsUsingAdjacencyList(List<GraphNode> nodeList) {
    this.nodeList = nodeList;
  }

  public static void main(String[] args) {

    List<GraphNode> nodeList = new ArrayList<>();
    for(int i=1 ;i<11;i++){
      nodeList.add(new GraphNode("V"+i,i-1));
    }

    DfsUsingAdjacencyList graph = new DfsUsingAdjacencyList(nodeList);

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

    System.out.println("printing dfs using adjacency list ");
    graph.dfs(nodeList);
  }

  private void dfs(List<GraphNode> nodeList) {
    Stack<GraphNode> stack = new Stack<>();
    for(GraphNode node : nodeList)
    {
      if(!node.isVisited){
        stack.push(node);
      }

      while (!stack.isEmpty()){
        GraphNode current = stack.pop();

        System.out.print(current.getName()+" ");

        current.setVisited(true);
        List<GraphNode> neighbourNodes = current.getNeightbours();
        for(GraphNode neighbours : neighbourNodes){
          if(!neighbours.isVisited){
            stack.push(neighbours);
            neighbours.setVisited(true);
          }
        }
      }
    }
  }

  private void addUndirectedEdge(int i, int j) {
    GraphNode vertex1 = nodeList.get(i-1);
    GraphNode vertex2 = nodeList.get(j-1);
    vertex1.getNeightbours().add(vertex2);
    vertex2.getNeightbours().add(vertex1);
  }


}
