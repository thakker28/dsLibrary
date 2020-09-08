package dynamicprogramming;

import java.util.Scanner;

public class LongestPalindromeSubsequence {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    int length = longestPalindrome(s);
    int length2 = longestPalindromeTabulation(s);
    System.out.println(length);
    System.out.print(length2);
  }

  private static int longestPalindromeTabulation(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(s);
    String reverseString = stringBuilder.reverse().toString();
    int dp[][] = new int[s.length()+1][s.length()+1];
    for(int i=0,j=0 ;i<dp.length;i++)
    {
      dp[i][j] = 0;
    }
    for(int i=0,j=1;j<dp[0].length;j++)
    {
      dp[i][j] = 0;
    }
    for(int i=1;i<dp.length;i++)
    {
      for(int j=1;j<dp[i].length;j++)
      {
        if(s.charAt(i-1)==reverseString.charAt(j-1))
        {
          dp[i][j] = dp[i-1][j-1] + 1;
        }
        else{
          dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
      }
    }
    return dp[s.length()][reverseString.length()];
  }

  private static int longestPalindrome(String s) {
    StringBuilder s2 = new StringBuilder();
    s2.append(s);
    String reverseString = s2.reverse().toString();
    return lcs(s,reverseString);
  }

  private static int lcs(String s, String reverseString) {
    if(s.length()==0 || reverseString.length()==0)
    {
      return 0;
    }

    if(s.charAt(s.length()-1)==reverseString.charAt(reverseString.length()-1))
    {
      return lcs(s.substring(0,s.length()-1),reverseString.substring(0,reverseString.length()-1))+1;
    }
    else{
      int count1 = lcs(s.substring(0,s.length()-1),reverseString);
      int count2 = lcs(s,reverseString.substring(0,reverseString.length()-1));
      return Math.max(count1,count2);
    }
  }
}
