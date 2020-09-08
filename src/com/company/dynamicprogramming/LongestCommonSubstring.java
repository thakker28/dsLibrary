package dynamicprogramming;

import java.util.Scanner;

public class LongestCommonSubstring {
  static int max = 0;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    int ans = longestSubstring(s1,s2,0);
    int ans2 = longestSubstringTabulation(s1,s2);
    System.out.println(max);
    System.out.println(ans2);
  }

  private static int longestSubstringTabulation(String s1, String s2) {
    int max = 0;
    int dp[][]= new int[s1.length()+1][s2.length()+1];
    for(int i=0,j=0; i<dp.length;i++)
    {
      dp[i][j] = 0;
    }
    for(int i=0,j=1; j<dp[0].length;j++)
    {
      dp[i][j] = 0;
    }
    for(int i =1; i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(s1.charAt(i-1) == s2.charAt(j-1))
        {
          dp[i][j] = dp[i-1][j-1] +1;
          max = dp[i][j]>max ? dp[i][j] : max;
        }
        else
        {
          dp[i][j] = 0;
        }
      }
    }
    return max;
  }

  private static int longestSubstring(String s1, String s2 , int count) {
    if(s1.length()==0 || s2.length()==0)
    {
      return count;
    }
    if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1))
    {
      count = longestSubstring(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1),count+1);
      if(count>max)
      {
        max = count;
      }
      return count;
    }
    else
    {
      if(count>max)
      {
        max = count;
      }
      count = 0;

    return  Math.max(longestSubstring(s1.substring(0,s1.length()-1),s2,count),
     longestSubstring(s1, s2.substring(0,s2.length()-1), count));

    }

  }
}
