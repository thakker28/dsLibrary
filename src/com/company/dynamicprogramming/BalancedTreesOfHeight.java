package dynamicprogramming;

import java.util.Scanner;

public class BalancedTreesOfHeight {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int height = scanner.nextInt();
    int tress = numberOfBalancedTrees(height);
    System.out.println(tress);
  }

  private static int numberOfBalancedTrees(int height) {
    if(height==0 || height ==1)
    {
      return 1;
    }

    int dp[] = new int[height+1];
    int mod = (int) (Math.pow(10,9)+7);
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2;i<dp.length;i++){
      long temp1 = (long) dp[i-1] * dp[i-1];
      temp1 = temp1 % mod;
      long temp2 = (long) dp[i-1] * dp[i-2] * 2;
      temp2 = temp2 % mod;
      dp[i] = (int) ((temp1+temp2)%mod);

    }
    return dp[height];
  }
}
