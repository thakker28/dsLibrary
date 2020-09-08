package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {
  private static List<Edge>[] edge;
  public HasPath(List<Edge>[] edge) {
    this.edge = edge;
  }

  static class Edge{
    int src;
    int nbr;
    int wt;

    public Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int vertices = scanner.nextInt();
    List<Edge> edge[] = new ArrayList[vertices];
    for(int i=0;i<vertices;i++){
      edge[i] = new ArrayList<>();
    }
    HasPath graph = new HasPath(edge);

    int edges = scanner.nextInt();
    for(int i=0;i<edges;i++)
    {
      int v1 = scanner.nextInt();
      int v2 = scanner.nextInt();
      int wt = scanner.nextInt();
      addUndirectedEdge(v1,v2,wt);
    }
    int source = scanner.nextInt();
    int destination = scanner.nextInt();
    boolean visited[] = new boolean[vertices];
    boolean ans = hasPath(source,destination , visited);
    System.out.println(ans);
  }

  private static boolean hasPath(int source, int destination, boolean[] visited) {
    if(source==destination){
      return true;
    }
      visited[source] = true;
      for(Edge e : edge[source]){
        if(!visited[e.nbr]){
          boolean ans = hasPath(e.nbr,destination,visited);
          if(ans){
            return ans;
          }
        }
      }

    return false;
  }

  private static void addUndirectedEdge(int v1, int v2, int wt) {
    edge[v1].add(new Edge(v1,v2,wt));
    edge[v2].add(new Edge(v2,v1,wt));
  }
}
