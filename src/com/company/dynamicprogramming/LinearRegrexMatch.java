package dynamicprogramming;

import java.util.Scanner;

public class LinearRegrexMatch {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    String p = scanner.next();
    boolean ans = match(s, p);
    System.out.println(ans);
  }

  private static boolean match(String s, String p) {

    if (s.length() == 0 && p.length() == 0) {
      return true;
    }

    boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0, j = 1; j <= p.length(); j++) {
      if (p.charAt(j - 1) == '*') {
        dp[i][j] = dp[i][j - 2];
      }
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if(p.charAt(j-1)=='*') {
            if (dp[i][j - 2]) {
              dp[i][j] = dp[i][j - 2];
            } else if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
              dp[i][j] = dp[i - 1][j];
            }
          }
        }
      }
    return dp[s.length()][p.length()];
    }


  }

