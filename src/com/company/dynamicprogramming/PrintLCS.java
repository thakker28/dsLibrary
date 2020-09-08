package dynamicprogramming;

import java.util.Scanner;

public class PrintLCS {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    String ans = longestSubsequence(s1,s2,"");
    String ans2 = longestSubsequenceTabulation(s1,s2);
    System.out.println(ans);
    System.out.println(ans2);
  }

  private static String longestSubsequenceTabulation(String s1, String s2) {
    String dp[][] = new String[s1.length()+1][s2.length()+1];
    for(int i=0,j=0; i<dp.length;i++)
    {
      dp[i][j]= "";
    }
    for(int i=0,j=1;j<dp[i].length;j++)
    {
      dp[i][j] = "";
    }

    for(int i=1; i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(s1.charAt(i-1)==s2.charAt(j-1))
        {
          dp[i][j] = dp[i-1][j-1] + s2.charAt(j-1);
        }
        else
        {
          dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  private static String longestSubsequence(String s1, String s2, String outputSoFar) {
    if(s1.length()==0 || s2.length()==0)
    {
      return outputSoFar;
    }

    if(s1.charAt(0)==s2.charAt(0))
    {
      String smallOutput = longestSubsequence(s1.substring(1),s2.substring(1),
          outputSoFar+s1.charAt(0));
      return smallOutput;
    }
    else
    {
      String output1 = longestSubsequence(s1.substring(1),s2,outputSoFar);
      String output2 = longestSubsequence(s1,s2.substring(1),outputSoFar);
      outputSoFar = output1.length()>=output2.length() ? output1 : output2;
      return outputSoFar;
    }
  }


}
