package dynamicprogramming;


import java.util.Scanner;

/* Whis and Beerus are playing a new game today . They form a tower of N coins and make a move in
 alternate turns , Beerus being the God plays first . In one move player can remove 1 or X or Y
 coins from the tower . The person to make the last move wins the Game . Can you find out who wins the game ?

 */
public class CoinTower {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    boolean ans = coinTower(n,x,y);
    if(ans){
      System.out.println("Beerus");
    }
    else{
      System.out.println("Whis");
    }


  }

  private static boolean coinTower(int n, int x, int y) {
    if(n==1 || n==x || n==y){
      return true;
    }

    boolean dp[] = new boolean[n+1];
    dp[1] = true;
    dp[x] = true;
    dp[y] = true;

    for(int i=2;i<dp.length;i++)
    {
      boolean option1 = dp[i-1];
      boolean option2 = false;
      boolean option3 = false;
      if(i-x>=0)
      {
        option2 = dp[i-x];
      }
      if(i-y>=0)
      {
        option3 = dp[i-y];
      }
      if(option1==false || option2==false || option3==false)
      {
        dp[i] = true;
      }
      else{
        dp[i] =  false;
      }
    }

return dp[n];
  }
}
