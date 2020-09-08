package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode implements Comparable<GraphNode> {

  GraphNode(String name , int index)
  {
    this.name = name;
    this.index = index;
  }

  public GraphNode(String name){
    this.name = name;
    this.distance = Integer.MAX_VALUE;
  }

  private int index;
  private List<GraphNode> neightbours = new ArrayList<>();
  boolean isVisited;
  private int distance;
  private GraphNode parent;
  private DisjointSet set;

  public DisjointSet getSet() {
    return set;
  }

  public void setSet(DisjointSet set) {
    this.set = set;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private String name;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public List<GraphNode> getNeightbours() {
    return neightbours;
  }

  public void setNeightbours(List<GraphNode> neightbours) {
    this.neightbours = neightbours;
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }

  public Map<GraphNode, Integer> getWeightMap() {
    return weightMap;
  }

  public void setWeightMap(Map<GraphNode, Integer> weightMap) {
    this.weightMap = weightMap;
  }

  private Map<GraphNode,Integer> weightMap = new HashMap<>();

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public GraphNode getParent() {
    return parent;
  }

  public void setParent(GraphNode parent) {
    this.parent = parent;
  }


  @Override
  public int compareTo(GraphNode o) {
    return this.distance - o.distance;
  }

  @Override
  public String toString() {
    return name;
  }
}
