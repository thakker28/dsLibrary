package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class HamiltonianPathAndCycle {
  static class Edge{
    int src;
    int nbr;

    public Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int vertices = scanner.nextInt();
    List<Edge> graph[] = new ArrayList[vertices];
    for (int i =0;i<vertices;i++){
      graph[i] = new ArrayList<>();
    }
    int edges = scanner.nextInt();
    for(int i=0;i<edges;i++){
      int v1 = scanner.nextInt();
      int v2 = scanner.nextInt();
      graph[v1].add(new Edge(v1,v2));
      graph[v2].add(new Edge(v2,v1));
    }
    int src = scanner.nextInt();
    HashSet<Integer> visited = new HashSet<>();
    printpathAndCycles(graph,src,visited,src+"" ,src);
  }

  private static void printpathAndCycles(List<Edge>[] graph, int src, HashSet<Integer> visited,
                                         String psf , int oSrc) {
    if(visited.size()==graph.length-1){
      System.out.print(psf);
      boolean cycleFound = false;
      for(Edge edge : graph[oSrc]){
        if(edge.nbr==src){ //Direct edge cycle found
          cycleFound = true;
          break;
        }
      }
      if(cycleFound){
        System.out.println("*");
      }
      else{
        System.out.println(".");
      }
      return;
    }
    visited.add(src);
    for(Edge e : graph[src]){
      if (!visited.contains(e.nbr)){
        printpathAndCycles(graph,e.nbr,visited,psf+e.nbr,oSrc);
      }
    }
    visited.remove(src);

  }
}
