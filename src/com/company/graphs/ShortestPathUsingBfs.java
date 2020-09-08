package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ShortestPathUsingBfs {
  private static List<GraphNode> nodeList = new ArrayList<>();
   public static void main(String[] args) {
    for(int i=1;i<=10;i++){
      nodeList.add(new GraphNode("V"+i,i-1));
    }

    ShortestPathUsingBfs graph = new ShortestPathUsingBfs();
     graph.addUndirectedEdge(1,9);
     graph.addUndirectedEdge(9,3);
     graph.addUndirectedEdge(9,10);
     graph.addUndirectedEdge(3,2);
     graph.addUndirectedEdge(10,2);
     graph.addUndirectedEdge(3,5);
     graph.addUndirectedEdge(2,4);
     graph.addUndirectedEdge(2,8);
     graph.addUndirectedEdge(4,5);
     graph.addUndirectedEdge(4,6);
     graph.addUndirectedEdge(8,7);
     graph.addUndirectedEdge(6,7);

     graph.findPath(nodeList.get(1));
  }

  private void findPath(GraphNode sourceNode) {
    Queue<GraphNode> queue = new LinkedList<>();
    queue.add(sourceNode);
    while (!queue.isEmpty())
    {
      GraphNode current = queue.remove();
      current.setVisited(true);
      System.out.print("printing path for vertex "+current.getName() + ": ");
      printPath(current);
      System.out.println("");
      for(GraphNode neigbour : current.getNeightbours()){
        if(!neigbour.isVisited)
        {
          queue.add(neigbour);
          neigbour.setParent(current);
            neigbour.setVisited(true);
        }
      }
    }
  }

  private void printPath(GraphNode node) {
     if(node.getParent() != null){
       printPath(node.getParent());
     }
     System.out.print(node.getName()+" ");
  }

  private void addUndirectedEdge(int i, int j) {
    GraphNode vertex1 = nodeList.get(i-1);
    GraphNode vertex2 = nodeList.get(j-1);
    vertex1.getNeightbours().add(vertex2);
    vertex2.getNeightbours().add(vertex1);
  }
}
