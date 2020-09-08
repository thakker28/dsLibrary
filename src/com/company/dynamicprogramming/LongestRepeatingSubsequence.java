package dynamicprogramming;

import java.util.Scanner;

public class LongestRepeatingSubsequence {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    int length = longestRepeatingLength(s);
    String longestRS = longestRepeatingString(s);
    String longestRepeating2 = longestRepeatingStringUsingTabulation(s,s);
    System.out.print(length+" ");
    System.out.print(longestRS+" ");
    System.out.print(longestRepeating2);
  }

  private static String longestRepeatingStringUsingTabulation(String s1, String s2) {
    String dp[][] = new String[s1.length()+1][s2.length()+1];
    for(int i=0,j=0;i<dp.length;i++)
    {
      dp[i][j] = "";
    }
    for(int i=0,j=0;j<dp[i].length;j++)
    {
      dp[i][j] = "";
    }

    for(int i=1;i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(s1.charAt(i-1) == s2.charAt(j-1) && i!=j)
        {
          dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
        }
        else{
          dp[i][j] = dp[i-1][j].length()>=dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  private static String longestRepeatingString(String s) {
    return lcsUsingRecursion(s,s,"");
  }

  private static String lcsUsingRecursion(String s1, String s2, String outputSoFar) {
    if(s1.length()==0 || s2.length()==0)
    {
      return outputSoFar;
    }

    if(s1.charAt(0)==s2.charAt(0) && s1.length() != s2.length())
    {
      return lcsUsingRecursion(s1.substring(1),s2.substring(1),outputSoFar+s1.charAt(0));
    }
    else{
      String output1 = lcsUsingRecursion(s1.substring(1),s2,outputSoFar);
      String output2 = lcsUsingRecursion(s1,s2.substring(1),outputSoFar);
      outputSoFar = output1.length()>=output2.length() ? output1 : output2;
      return outputSoFar;
    }
  }

  private static int longestRepeatingLength(String s1) {
    String s2 = s1;
    int dp[][] = new int[s1.length()+1][s2.length()+1];
    for(int i=0,j=0;i<dp.length;i++)
    {
      dp[i][j] = 0;
    }
    for(int i=0,j=0;j<dp[i].length;j++)
    {
      dp[i][j] = 0;
    }

    for(int i=1;i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j)
        {
          dp[i][j] = dp[i-1][j-1]+1;
        }
        else{
          dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }
}
