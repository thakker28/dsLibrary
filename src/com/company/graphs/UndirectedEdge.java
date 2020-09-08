package graphs;

public class UndirectedEdge {

  private GraphNode first;
  private GraphNode second;
  private int weight;

  public UndirectedEdge(GraphNode first, GraphNode second, int weight) {
    this.first = first;
    this.second = second;
    this.weight = weight;
  }


  public GraphNode getFirst() {
    return first;
  }

  public void setFirst(GraphNode first) {
    this.first = first;
  }

  public GraphNode getSecond() {
    return second;
  }

  public void setSecond(GraphNode second) {
    this.second = second;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }


  @Override
  public String toString() {
    return ("Taken Edge ( "+first.getName()+" , "+second.getName()+" ) , Weight = "+weight+"");
  }
}
