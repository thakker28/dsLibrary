package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintAllPaths {
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
    for (int i = 0;i<vertices;i++){
      edge[i] = new ArrayList<>();
    }
    int edges = scanner.nextInt();
    for(int i = 0;i<edges;i++){
      int v1 = scanner.nextInt();
      int v2 = scanner.nextInt();
      int wt = scanner.nextInt();
      edge[v1].add(new Edge(v1,v2,wt));
      edge[v2].add(new Edge(v2,v1,wt));
    }
    int src = scanner.nextInt();
    int dest = scanner.nextInt();
    boolean visited[] = new boolean[vertices];
    printAllPaths(src,dest,edge,visited,src+"");
  }

  private static void printAllPaths(int src, int dest, List<Edge>[] edge, boolean[] visited,
                                    String psf) {

    if(src==dest){
      System.out.println(psf);
      return;
    }
    visited[src] = true;
    for(Edge e : edge[src]){
      if(!visited[e.nbr]){
        printAllPaths(e.nbr , dest ,edge ,visited , psf + e.nbr);
      }
    }
    visited[src] = false;

  }
}
