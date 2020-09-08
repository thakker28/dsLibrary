package dynamicprogramming;

import java.util.Scanner;

public class EditDistanceOrEqualizeString {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    //int ans = convertString(s1,s2);
    int ans2 = convertStringUsingTabulation(s1,s2);
    //System.out.println(ans);
    System.out.println(ans2);
  }

  private static int convertStringUsingTabulation(String s1, String s2) {

    int dp[][] = new int[s1.length()+1][s2.length()+1];
    dp[0][0] = 0;
    for(int i=0,j=1;j<=s2.length();j++){
      dp[i][j] = j; //No. of insertions equal to other string length
    }
    for(int i=1,j=0;i<=s1.length();i++){
      dp[i][j] = i;
    }

    for(int i=1;i<=s1.length();i++){
      for(int j=1;j<=s2.length();j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1];
        }
        else{
          int option1 = 1 + dp[i][j-1]; //insert
          int option2 = 1 + dp[i-1][j]; //delete
          int option3 = 1 + dp[i-1][j-1]; // replace
          dp[i][j] = Math.min(option1,Math.min(option2,option3));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  private static int convertString(String s1, String s2) {
    if(s1.length()==0 || s2.length()==0){
      return s1.length()+s2.length();
    }

    if(s1.charAt(0)==s2.charAt(0)){
      return convertString(s1.substring(1),s2.substring(1));
    }
    else{
      int insertOption = 1 + convertString(s1,s2.substring(1));
      int deleteOption = 1+ convertString(s1.substring(1),s2);
      int replaceOption = 1 + convertString(s1.substring(1),s2.substring(1));
      return Math.min(insertOption,Math.min(deleteOption,replaceOption));
    }
  }
}
