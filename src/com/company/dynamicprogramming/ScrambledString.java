package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScrambledString {
  private static Map<String,Boolean> map = new HashMap<>();
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.next();
    String s2 = scanner.next();
    if(s1.length() != s2.length())
    {
      System.out.println(false);
    }
    else if(s2.isEmpty() && s1.isEmpty())
    {
      System.out.println(true);
    }
    else{

     // boolean ans = isScrambled(s1,s2);
      boolean ans2 = isScrambledMemoization(s1,s2);
     // System.out.println(ans);
     System.out.println(ans2);
    }
  }

  private static boolean isScrambledMemoization(String s1, String s2) {
    if(s1.equals(s2))
    {
      return true;
    }

    if(s1.length()<=1 || s2.length()<=1)
    {
      return false;
    }

    boolean flag = false;

    String key = s1+"_"+s2;


    if(map.get(key) != null)
    {
      return map.get(key);
    }

    for(int k=1 ; k<s1.length();k++)
    {
      boolean swappedCondition1 =  isScrambledMemoization(s1.substring(0,k),s2.substring(0,k));
      map.put(key,swappedCondition1);

      boolean swappedCondition2 = isScrambledMemoization(s1.substring(k),s2.substring(k));
      map.put(key,swappedCondition2);

      boolean swappedConditionAns = swappedCondition1 && swappedCondition2;

      boolean unswappedCondition1 = isScrambledMemoization(s1.substring(0,k),s2.substring(s2.length()-k));
      map.put(key,unswappedCondition1);

      boolean unswappedCondition2 = isScrambledMemoization(s1.substring(k),s2.substring(0,s2.length()-k));
      map.put(key,unswappedCondition2);

      boolean unswappedConditionAns = unswappedCondition1 && unswappedCondition2;

      if(swappedConditionAns || unswappedConditionAns)
      {
        flag = true;
        map.put(key,flag);
        break;
      }
    }
    return flag;
  }

  private static boolean isScrambled(String s1, String s2) {

    if(s1.equals(s2))
    {
      return true;
    }

    if(s1.length()<=1 || s2.length()<=1)
    {
      return false;
    }

    boolean flag = false;
    for(int k=1;k<s1.length();k++)
    {
      boolean unswappedCondition =
          (isScrambled(s1.substring(0,k),s2.substring(0,k)) && isScrambled(s1.substring(k),
              s2.substring(k)));

      boolean swappedCondition =
          isScrambled(s1.substring(0,k),s2.substring(s2.length()-k)) && isScrambled(s1.substring(k),
              s2.substring(0, s1.length()-k));

      if (swappedCondition || unswappedCondition)
      {
        flag = true;
        break;
      }
    }
    return flag;
  }
}
