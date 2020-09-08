package dynamicprogramming;

import java.util.Scanner;

public class LongestCommonSubsequence {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    int ans = longesSubsequence(s1,s2);
    System.out.println(ans);
    int dp[][] = new int[s1.length()+1][s2.length()+1];
    int ans2 = longesSubsequenceMemoization(s1,s2,dp);
    int ans3  = longesSubsequenceTabulation(s1,s2);
    System.out.println(ans2);
    System.out.println(ans3);
  }

  private static int longesSubsequenceTabulation(String s1, String s2) {
    int dp[][] = new int[s1.length()+1][s2.length()+1];
    for(int i=0,j=0; i<dp.length;i++)
    {
      dp[i][j] = 0;
    }
    for(int i=0,j=1;j<dp[0].length;j++)
    {
      dp[i][j] = 0;
    }

    for(int i =1;i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(s1.charAt(i-1)!=s2.charAt(j-1))
        {
          dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
        else
        {
          dp[i][j] = 1+dp[i-1][j-1];
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  private static int longesSubsequenceMemoization(String s1, String s2, int dp[][]) {
    if(s1.length()==0 || s2.length()==0)
    {
      return 0;
    }
    if(dp[s1.length()][s2.length()]>0)
    {
      return dp[s1.length()][s2.length()];
    }

    if(s1.charAt(s1.length()-1)!=s2.charAt(s2.length()-1))
    {
      int x1 = longesSubsequence(s1.substring(0,s1.length()-1),s2);
      int x2 = longesSubsequence(s1,s2.substring(0,s2.length()-1));
      dp[s1.length()][s2.length()] = Math.max(x1,x2);
      return Math.max(x1,x2);

    }
    else
    {
      return dp[s1.length()][s2.length()]= longesSubsequence(s1.substring(0,s1.length()-1),
          s2.substring(0,s2.length()-1))+1;
    }

  }

  private static int longesSubsequence(String s1, String s2) {
    if(s1.length()==0 || s2.length()==0)
    {
      return 0;
    }

    if(s1.charAt(s1.length()-1)!=s2.charAt(s2.length()-1))
    {
      int x1 = longesSubsequence(s1.substring(0,s1.length()-1),s2);
      int x2 = longesSubsequence(s1,s2.substring(0,s2.length()-1));
      return Math.max(x1,x2);

    }
    else
    {
      return longesSubsequence(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1))+1;
    }
  }
}
