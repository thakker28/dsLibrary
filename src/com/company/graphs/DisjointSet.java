package graphs;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

  private List<GraphNode> nodes = new ArrayList<>();

  public List<GraphNode> getNodes() {
    return nodes;
  }

  public void setNodes(List<GraphNode> nodes) {
    this.nodes = nodes;
  }

  public static void main(String[] args) {
    List<GraphNode> nodeList = new ArrayList<>();
    for(int i=0;i<5;i++)
    {
      nodeList.add(new GraphNode(""+(char)(i+65)));
    }

    driver(nodeList);
  }

  /* methos to implement all 3 functionalities : makeset(), findSet() , union() of Disjoint Set */
  public static void driver(List<GraphNode> nodeList) {

    System.out.println("Making sets for each Node");
    makeSet(nodeList);
   for(int i=0;i<nodeList.size()-1;i++)
   {
     GraphNode first = nodeList.get(i);
     GraphNode second = nodeList.get(i+1);
     System.out.println("Nodes in first set "+first.getName()+" ");
     first.getSet().printNodesInSet();
     System.out.println("Nodes in second set "+second.getName()+" " );
     second.getSet().printNodesInSet();
     System.out.println("If Node "+first.getName()+" and Node "+second.getName()+" don't belong "
         + "to same set then union them");
      if(!findSet(first).equals(findSet(second)))
      {
        System.out.println("doing union of Node "+first.getName()+" and Node "+second.getName()+"");
        DisjointSet unionedSet = union(first,second);
        unionedSet.printNodesInSet();
      }
   }
  }

  public static DisjointSet union(GraphNode first, GraphNode second) {
      DisjointSet set1 = first.getSet();
      DisjointSet set2 = second.getSet();
    if(set1.getNodes().size()>set2.getNodes().size()){
      for(GraphNode node : set2.getNodes())
      {
        set1.getNodes().add(node);
        node.setSet(set1);
      }
      return set1;
    }
    else{
      for(GraphNode node : set1.getNodes())
      {
        set2.getNodes().add(node);
        node.setSet(set2);
      }
      return set2;
    }
  }

  public void printNodesInSet() {
    for (GraphNode node : nodes)
    {
      System.out.print(node.getName() + " ");
    }
    System.out.println("");
  }

  public static DisjointSet findSet(GraphNode node) {
    return node.getSet();
  }

  public static void makeSet(List<GraphNode> nodeList) {
    for(GraphNode node : nodeList)
    {
      DisjointSet set = new DisjointSet();
      set.getNodes().add(node);
      node.setSet(set);
    }
  }
}
