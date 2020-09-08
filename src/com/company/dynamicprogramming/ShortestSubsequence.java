package dynamicprogramming;

import java.util.Scanner;

public class ShortestSubsequence {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.next();
    String s2 = scanner.next();
    int ans = shortestUncommonSubsequence(s1,s2);
    int ans2 = shortestUncommonSubsequenceUsingTabulation(s1,s2);
    System.out.println(ans);
    System.out.println(ans2);
  }

  private static int shortestUncommonSubsequenceUsingTabulation(String s1, String s2) {
    int dp[][] = new int[s1.length()+1][s2.length()+1];
    dp[0][0] = 0;
    for(int i=0,j=1;j<=s2.length();j++){
      dp[i][j] = Integer.MAX_VALUE -1;
    }

    for(int i=1,j=0;i<=s1.length();i++){
      dp[i][j] = 1;
    }

    for(int i=1;i<dp.length;i++)
    {
      for(int j=1;j<=s2.length();j++){
        int k;
        char ch = s1.charAt(i-1);
        for(k=j-1;k>=0;k--){
          if(s2.charAt(k)==ch)
            break;
        }
        if(k==-1)
        {
          dp[i][j] = 1;
        }
        else{
          dp[i][j] = Math.min(dp[i-1][j],dp[i-1][k+1]+1);
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  private static int shortestUncommonSubsequence(String s1, String s2) {
    if(s1.length()==0){
      return Integer.MAX_VALUE-1;
    }

    if(s2.length()==0){
      return 1;
    }

    if(!s2.contains(s1.charAt(0)+"")){
             return 1;
         }
         else{
             int option1 = shortestUncommonSubsequence(s1.substring(1),s2);
         int option2 = shortestUncommonSubsequence(s1.substring(1),
             s2.substring(s2.indexOf(s1.charAt(0))+1)) +1 ;
         return Math.min(option1,option2);
         }
  }
}
