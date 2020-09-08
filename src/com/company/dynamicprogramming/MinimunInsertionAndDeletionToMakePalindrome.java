package dynamicprogramming;

import java.util.Scanner;

public class MinimunInsertionAndDeletionToMakePalindrome {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    int longestPalindromelength = longestPalindrome(s);
    int minDeletions = s.length()-longestPalindromelength;
    int minInsertions = minDeletions; // Inserions and deletions are not done simultaneouly on
    // the string. You can either insert or delete to make it a palindrome.
    System.out.print(minInsertions+" ");
    System.out.print(minDeletions);
  }

  private static int longestPalindrome(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(s);
    String reverseString = stringBuilder.reverse().toString();
    return lcs(s,reverseString);
  }

  private static int lcs(String s, String reverseString) {
    if(s.length()==0 || reverseString.length()==0)
    {
      return 0;
    }

    if(s.charAt(0)==reverseString.charAt(0))
    {
      return lcs(s.substring(1),reverseString.substring(1))+1;
    }
    else {
      int count1 = lcs(s.substring(1),reverseString);
      int count2 = lcs(s,reverseString.substring(1));
      return Math.max(count1,count2);
    }
  }
}
