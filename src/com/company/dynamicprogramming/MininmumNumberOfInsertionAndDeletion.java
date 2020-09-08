package dynamicprogramming;

import java.util.Scanner;

public class MininmumNumberOfInsertionAndDeletion {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    int dp[][] = new int[s1.length()+1][s2.length()+1];
    int lcsLength = lcs(s1,s2,0,dp);
    int deletions = s1.length()-lcsLength;
    int insertions = s2.length()-lcsLength;
    System.out.print(insertions+" "+deletions);

  }

  private static int lcs(String s1, String s2, int length ,int[][] dp) {
    if(s1.length()==0 || s2.length()==0)
    {
      return length;
    }
    if(dp[s1.length()][s2.length()]>0)
    {
      return dp[s1.length()][s2.length()];
    }
    if(s1.charAt(s1.length()-1)==s2.charAt(s2.length()-1))
    {
      return dp[s1.length()][s2.length()] = lcs(s1.substring(0,s1.length()-1),s2.substring(0,
        s2.length()-1),
        length+1,dp);
    }
    else{
      int output1 = lcs(s1.substring(0,s1.length()-1),s2,length,dp);
      int output2 = lcs(s1,s2.substring(0,s2.length()-1),length,dp);
      return dp[s1.length()][s2.length()] = Math.max(output1,output2);
    }
  }
}
