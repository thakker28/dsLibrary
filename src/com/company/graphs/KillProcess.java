package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class KillProcess {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int killId = scanner.nextInt();
    int id[] = new int[n];
    int parentId[] = new int[n];
    int i = 0;
    while (i<n){
      id[i] = scanner.nextInt();
      i++;
    }
    i = 0;
    while (i<n){
      parentId[i] = scanner.nextInt();
      i++;
    }

    List<Integer> deletedIds = bfsKill(killId , id , parentId);
    Collections.sort(deletedIds);
    for(int ids : deletedIds)
    {
      System.out.print(ids+" ");
    }
  }

  private static List<Integer> bfsKill(int killId, int[] id, int[] parentId) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i=0;i<id.length;i++)
    {
      List<Integer> list = map.getOrDefault(parentId[i],new ArrayList<>());
      list.add(id[i]);
      map.put(parentId[i],list);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(killId);
    List<Integer> deleted = new ArrayList<>();
    while (!queue.isEmpty())
    {
      int current = queue.remove();
      deleted.add(current);
      if(map.get(current) != null){
        deleted.addAll(map.get(current));
      }

    }
    return deleted;
  }
}
