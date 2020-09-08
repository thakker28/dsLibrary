package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvaluateExpressionToTrue {
 // private static int ans = 0;
  private static Map<String,Integer> map = new HashMap<>();
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    int ans = numberOfWaysToTrue(s,0,s.length()-1,true);
    int ans2 = numberOfWaysToTrueUsingMemoization(s,0,s.length()-1,true);
    System.out.println(ans);
    System.out.println(ans2);
  }

  private static int numberOfWaysToTrueUsingMemoization(String s, int i, int j, boolean isTrue) {

    if(i>j)
    {
      return 1;
    }
    if(i==j)
    {
      if(isTrue && s.charAt(i)=='T' || (!isTrue && s.charAt(i)=='F'))
      {
        return 1;
      }
      else{
        return 0;
      }
    }

    String key = getKey(i,j,isTrue);
    if(map.get(key) != null)
    {
      return map.get(key);
    }
    int ans = 0;
    for(int k=i+1;k<j;k=k+2)
    {
      int leftF = numberOfWaysToTrueUsingMemoization(s,i,k-1,false);
      int leftT = numberOfWaysToTrueUsingMemoization(s,i,k-1,true);
      int rightF = numberOfWaysToTrueUsingMemoization(s,k+1,j,false);
      int rightT = numberOfWaysToTrueUsingMemoization(s,k+1,j,true);

      ans = ans + possibleWays(s,k,leftF,leftT,rightF,rightT,isTrue);
      key = getKey(i,j,isTrue);
      map.put(key,ans);
    }
    return ans;
  }

  private static String getKey(int i, int j, boolean isTrue) {
    StringBuilder sb = new StringBuilder();
    sb.append(i);
    sb.append(j);
    sb.append(isTrue);
    return sb.toString();
  }

  private static int numberOfWaysToTrue(String s, int i, int j, boolean isTrue) {
    if(i>j)
    {
      return 0;
    }
    if(i==j)
    {
      if(isTrue && s.charAt(i)=='T' || (s.charAt(i)=='F' && !isTrue))
      {
        return 1;
      }
      return 0;
    }

    int ans = 0;

    for(int k=i+1;k<j;k=k+2)
    {
      int leftF = numberOfWaysToTrue(s,i,k-1,false);
      int leftT = numberOfWaysToTrue(s,i,k-1,true);
      int rightF = numberOfWaysToTrue(s,k+1,j,false);
      int rightT = numberOfWaysToTrue(s,k+1,j,true);

      ans = ans + possibleWays(s,k,leftF,leftT,rightF,rightT,isTrue);
    }
    return ans;
  }

  private static int possibleWays(String s, int k, int leftF, int leftT, int rightF, int rightT ,
                boolean isTrue) {
    if(s.charAt(k)=='&')
    {
      if(isTrue)
      {
        return leftT * rightT;
      }
      else
      {
        return (leftF*rightT + leftT*rightF + leftF*rightF);
      }
    }
    else if(s.charAt(k)=='|')
    {
      if(isTrue)
      {
        return (leftF*rightT + leftT*rightF + leftT*rightT);
      }
      else{
        return (leftF*rightF);
      }
    }
    else{
      if(isTrue)
      {
        return (leftF*rightT + leftT*rightF);
      }
      else{
        return (leftF*rightF + leftT*rightT);
      }
    }
  }
}
