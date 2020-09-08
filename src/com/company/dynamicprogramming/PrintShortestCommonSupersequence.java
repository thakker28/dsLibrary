package dynamicprogramming;

import java.util.Scanner;

public class PrintShortestCommonSupersequence {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    String ans = shortestSubsequence(s1,s2,"");
    String ans2 = shortestSubsequenceTabulation(s1,s2);
    System.out.println(ans);
    System.out.println(ans2);
  }

  private static String shortestSubsequenceTabulation(String s1, String s2) {
    String dp[][] = new String[s1.length()+1][s2.length()+1];
    dp[0][0] = "";
    for(int j = 1;j<dp[0].length;j++)
    {
      dp[0][j] = s2.substring(0,j);
    }

    for(int i=1;i<dp.length;i++)
    {
      dp[i][0] = s1.substring(0,i);
    }

    for(int i=1;i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(s1.charAt(i-1)==s2.charAt(j-1))
        {
          dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
        }
        else{
          dp[i][j] = (dp[i-1][j]+s1.charAt(i-1)).length() <= (dp[i][j-1]+s2.charAt(j-1)).length()
                     ? (dp[i-1][j]+s1.charAt(i-1)) : (dp[i][j-1]+s2.charAt(j-1));

        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  private static String shortestSubsequence(String s1, String s2, String outputSoFar) {
    if(s1.length()==0 || s2.length()==0)
    {
      return outputSoFar+s1+s2;
    }

    if(s1.charAt(0)==s2.charAt(0))
    {
      return shortestSubsequence(s1.substring(1),s2.substring(1),
          outputSoFar+s1.charAt(0));
    }
    else
    {
      String output1 = shortestSubsequence(s1.substring(1),s2,outputSoFar+s1.charAt(0));
      String output2 = shortestSubsequence(s1,s2.substring(1),outputSoFar+s2.charAt(0));
      outputSoFar = output1.length()<=output2.length() ? output1 : output2;
      return outputSoFar;
    }

  }
}
