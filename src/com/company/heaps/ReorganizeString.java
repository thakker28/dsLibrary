package heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map;

public class ReorganizeString {
  static class Pair implements Comparable<Pair>{
    char c;
    int freq;
    Pair(char c , int freq){
      this.c = c;
      this.freq = freq;
    }

    @Override
    public int compareTo(Pair p){
      return this.freq - p.freq;
    }
  }
  public static void main (String args[]) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    String ans = reorganize(s);
    System.out.println(ans);
  }

  private static String reorganize(String s)
  {
    Map<Character , Integer> map = new HashMap<>();
    for(int i = 0;i<s.length();i++){
      map.put(s.charAt(i) , map.getOrDefault(s.charAt(i),0)+1);
    }
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for(Map.Entry<Character , Integer> entry : map.entrySet())
    {
      maxHeap.add(new Pair(entry.getKey() , entry.getValue()));
    }
    String ans = "";
    while(maxHeap.size()>1){
      Pair first = maxHeap.poll();
      Pair second = maxHeap.poll();
      ans = ans + first.c + second.c;
      first.freq--;
      second.freq--;
      if(first.freq>0){
        maxHeap.add(first);
      }
      if(second.freq>0){
        maxHeap.add(second);
      }
    }

    if(!maxHeap.isEmpty())
    {
      Pair max = maxHeap.poll();
      if(max.freq>1)
      {
        return "";
      }
      ans = ans  + max.c;
    }
    return ans;
  }
}
