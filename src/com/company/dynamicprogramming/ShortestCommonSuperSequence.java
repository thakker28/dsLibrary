package dynamicprogramming;

import java.util.Scanner;

public class ShortestCommonSuperSequence {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    int ans = shortestSequence(s1,s2,0);
    int ans2 = shortestSequenceTabulation(s1,s2);
    System.out.println(s1.length()+s2.length()-ans);
    System.out.println(s1.length()+s2.length()-ans2);
  }

  private static int shortestSequenceTabulation(String s1, String s2) {
    int dp[][] = new int[s1.length()+1][s2.length()+1];
    for(int i=0,j=0;i<dp.length;i++)
    {
      dp[i][j] = 0;
    }
    for(int i=0,j=1;j<dp[i].length;j++)
    {
      dp[i][j] = 0;
    }
    for(int i=1;i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(s1.charAt(i-1)==s2.charAt(j-1))
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

  /* Finding LCS length and then subtracting the lcs length from combined strings length */
  private static int shortestSequence(String s1, String s2, int length) {

    if(s1.length()==0 || s2.length()==0)
    {
      return length;
    }

    if(s1.charAt(0)==s2.charAt(0))
    {
      return  shortestSequence(s1.substring(1),s2.substring(1),length+1);
    }
    else{
      int lengthofLCSIncludingString1 = shortestSequence(s1.substring(1),s2,length);
      int lengthOfLCSIncludingString2 = shortestSequence(s1,s2.substring(1),length);
      length = Math.max(lengthofLCSIncludingString1,lengthOfLCSIncludingString2);
      return length;
    }
  }
}
