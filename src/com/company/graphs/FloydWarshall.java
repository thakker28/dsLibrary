package graphs;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
  private static List<GraphNode> nodeList;
  private static int[][] matrix;
  public FloydWarshall(List<GraphNode> nodeList) {
    this.nodeList = nodeList;
    matrix = new int[nodeList.size()][nodeList.size()];
  }

  public static void main(String[] args) {
     List<GraphNode> nodeList = new ArrayList<>();
     for(int i=0;i<4;i++)
     {
       nodeList.add(new GraphNode(""+(char)(65+i) , i));
     }

     FloydWarshall graph = new FloydWarshall(nodeList);

     graph.addWeightedEdge(1,2,8);
     graph.addWeightedEdge(1,4,1);
     graph.addWeightedEdge(4,3,9);
     graph.addWeightedEdge(4,2,2);
     graph.addWeightedEdge(3,1,4);
     graph.addWeightedEdge(2,3,1);

     for(int i=0;i<matrix.length;i++)
     {
       for(int j=0;j<matrix.length;j++)
       {
         if(i==j)
         {
           matrix[i][j] = 0;
         }
        else if(nodeList.get(i).getWeightMap().get(nodeList.get(j)) != null)
         {
           matrix[i][j] = nodeList.get(i).getWeightMap().get(nodeList.get(j));
         }
         else{
           matrix[i][j] = Integer.MAX_VALUE/10;
         }
       }
     }


    for(GraphNode node : nodeList){
      shortestPath(node);
    }


    for(int i=0;i<matrix.length;i++)
    {
      System.out.println(" Shortest distance via Node "+nodeList.get(i).getName()+" : ");
      for(int j = 0;j<matrix.length ;j++)
      {
         System.out.print(nodeList.get(j).getName() + " : "+ matrix[i][j]+" ");
      }
      System.out.println(" ");
    }

  }

  private static void shortestPath(GraphNode sourceNode) {

    for(int i=0;i<matrix.length;i++)
    {
      for(int j=0;j<matrix.length;j++)
      {
        if(matrix[i][j] > matrix[i][sourceNode.getIndex()] + matrix[sourceNode.getIndex()][j])
        {
          matrix[i][j] = matrix[i][sourceNode.getIndex()] + matrix[sourceNode.getIndex()][j];
        }
      }
    }
  }

  private void addWeightedEdge(int i, int j, int dis) {
    GraphNode vertex1 = nodeList.get(i-1);
    GraphNode vertex2 = nodeList.get(j-1);
    vertex1.getNeightbours().add(vertex2);
    vertex1.getWeightMap().put(vertex2,dis);
  }
}
