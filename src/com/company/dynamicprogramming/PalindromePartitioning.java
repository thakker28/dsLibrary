package dynamicprogramming;

import java.util.Scanner;

public class PalindromePartitioning {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
   // int ans = numberOfPartitions(s,0,s.length()-1);
    int dp[][] = new int[s.length()][s.length()];
    int ans2 = numberOfPartitionsMemoizations(s,0,s.length()-1,dp);
   // System.out.println(ans);
    System.out.println(ans2);
  }

  private static int numberOfPartitionsMemoizations(String s, int i, int j, int[][] dp) {
    if(i>=j)
    {
      return 0;
    }
    if(isPalindrome(s,i,j))
    {
      return 0;
    }

    if(dp[i][j]>0)
    {
      return dp[i][j];
    }

    int ans = Integer.MAX_VALUE;
    int temp1 = 0;
    int temp2 = 0;
    for(int k=i;k<j;k++)
    {
      if(dp[i][k]>0){
        temp1 = dp[i][k];
      }
      else{
        temp1 = numberOfPartitionsMemoizations(s,i,k,dp);
      }

      if(dp[k+1][j]>0)
      {
        temp2 = dp[k+1][j];
      }
      else{
        temp2 = numberOfPartitionsMemoizations(s,
            k+1,j,dp);
      }

      int tempAns = temp1 + temp2 + 1 ;
      if(ans>tempAns)
      {
        dp[i][j] = ans = tempAns;
      }
    }
    return  ans;
  }

  private static int numberOfPartitions(String s, int i, int j) {
    if(i>=j){
      return 0;
    }
    if(isPalindrome(s,i,j))
    {
      return 0;
    }
    int ans = Integer.MAX_VALUE;
    for(int k=i ; k<j ;k++)
    {
      int tempAns = numberOfPartitions(s,i,k) + numberOfPartitions(s,k+1,j)+1;

      if(ans>tempAns)
      {
        ans = tempAns;
      }

    }
    return ans;
  }

  private static boolean isPalindrome(String s, int i, int j) {

    while(i<j)
    {
      if(s.charAt(i) != s.charAt(j)){
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
