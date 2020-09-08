package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GraphColoring {
  private static int colorsRequired = Integer.MAX_VALUE;
  static class Edge {
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
    int vertexColor[] = new int[vertices];
    Arrays.fill(vertexColor,-1);
    List<Edge> [] graph = new ArrayList[vertices];
    for(int i = 0 ; i<vertices ; i++){
      graph[i] = new ArrayList<>();
    }
    int edges = scanner.nextInt();
    for(int i =0;i<edges;i++){
      int v1 = scanner.nextInt();
      int v2 = scanner.nextInt();
      graph[v1].add(new Edge(v1 , v2));
      graph[v2].add(new Edge(v2 , v1));
    }

    int colors = scanner.nextInt();
    List<Integer> color = new ArrayList<>();
    for(int i =0;i<colors;i++)
    {
      color.add(scanner.nextInt());
    }
    //vertexColor[0] = color.get(0);
    colorGraph(graph , color ,vertexColor , 0 ,vertices);
    int i = 0;
    for(i=0;i<vertexColor.length;i++){
      if (vertexColor[i] !=-1)
      {
        System.out.println("Colors are not sufficient");
        break;
      }
    }

    if(colorsRequired!=Integer.MAX_VALUE)
    {
      System.out.println("Min colors required "+(colorsRequired+1));
    }

  }

  private static void colorGraph(List<Edge>[] graph, List<Integer> colors, int[] vertexColor,
                                 int src , int vertices) {
    boolean temp = false;

    if(src == vertices)
    { int max = 0;
      for (int a : vertexColor)
      {

        max = Math.max(max,a);
        System.out.print(a+" ");
      }
      colorsRequired = Math.min(colorsRequired,max);
      System.out.println(" ");
      return ;
    }

    for(int i=0;i<vertices;i++)
    {
      if(isSafe(src , i , graph , vertexColor)){
        vertexColor[src] = i;

        colorGraph(graph , colors , vertexColor , src+1 , vertices);
        vertexColor[src] = -1;
      }
    }
  }

  private static boolean isSafe(int src, int color, List<Edge>[] graph, int[] vertexColor) {
    for (Edge e : graph[src]){
      if (vertexColor[e.nbr] == color){
        return false;
      }
    }
    return true;
  }
}
