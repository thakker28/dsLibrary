package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfPalindromeString {
  private static List<Integer> lengths= new ArrayList<>();
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    //palindromeNumber(s);
    int ans = numberOfPalindrome(s);
    System.out.println(ans);
  }

  private static int numberOfPalindrome(String s) {
    int count = 0;
    boolean dp[][] = new boolean[s.length()][s.length()];
    for(int i=0;i<dp.length;i++){
      dp[i][i] = true;
      count++;
    }

    for(int i=0;i<dp.length-1;i++){
      if(s.charAt(i)==s.charAt(i+1)){
        dp[i][i+1] = true;
        count++;
      }
    }

    for(int k=2;k<dp.length;k++){
      int j=k;
      int i = 0;
      while (j<s.length()){
        if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
          dp[i][j] = true;
          count++;
        }
        i++;
        j++;
      }

    }
    return count;
  }


 /* Using LCS to find longest palindrome and finding the number of palindromes through it */

  private static int palindromeNumber(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(s);
    String reversed = stringBuilder.reverse().toString();
    return lcs(s,reversed,0);
  }

  private static int lcs(String s, String reversed , int count) {
    if(s.length()==0 || reversed.length()==0){
      return count;
    }

    if(s.charAt(s.length()-1)==reversed.charAt(reversed.length()-1)){
      count = lcs(s.substring(0,s.length()-1),reversed.substring(0,reversed.length()-1),count+1);
      return count;
    }
    else{
      count = 0;
      int option1 = lcs(s.substring(0,s.length()-1),reversed,count);
      int option2 = lcs(s,reversed.substring(0,reversed.length()-1),count);
      if(option1 >1){
        lengths.add(option1);
      }
      if(option2>1){
        lengths.add(option2);
      }
      count = Math.max(option1,option2);
      return count;

    }

  }
}
