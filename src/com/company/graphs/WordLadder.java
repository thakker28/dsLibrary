package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class WordPair{
  public WordPair(String word, int depth) {
    this.word = word;
    this.depth = depth;
  }

  String word;
  int depth;
}
public class WordLadder {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String start = scanner.next();
    String end = scanner.next();
    int n = scanner.nextInt();
    List dic = new ArrayList();
    for(int i=0;i<n;i++)
    {
      dic.add(scanner.next());
    }
   // HashSet<String> set = new HashSet<>(dic);
    System.out.println(minTransformations(start,end,dic));
  }

  private static int minTransformations(String start, String end, List dic) {
    if(start.equals(end)){
      return 0;
    }

    Queue<WordPair> queue = new LinkedList<>();
    queue.add(new WordPair(start,1));
    while (!queue.isEmpty())
    {
      WordPair pair = queue.remove();
      if(pair.word.equals(end))
      {
        return pair.depth;
      }
      List<String> neighbours = getNeighbours(pair.word,dic);
      for(String word : neighbours)
      {
        queue.add(new WordPair(word,pair.depth+1));
      }
    }
    return -1;
  }

  private static List<String> getNeighbours(String word, List dic) {

    StringBuffer sb = new StringBuffer(word);
    List<String> neighbours = new ArrayList<>();
    for(int i=0;i<sb.length();i++)
    {
      char ch = sb.charAt(i);
      for(char c='a';c<='z';c++)
      {
        if(ch==c)
        {
          continue;
        }
        sb.setCharAt(i,c);
        String newWord = sb.toString();
        if(dic.contains(newWord))
        {
          dic.remove(newWord);
          neighbours.add(newWord);
        }
      }
      sb.setCharAt(i,ch);
    }
    return neighbours;
  }
}
