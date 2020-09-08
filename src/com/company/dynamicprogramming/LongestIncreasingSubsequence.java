package dynamicprogramming;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
  private static int ans = Integer.MIN_VALUE;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i = 0;
    while (i<n){
      arr[i] = scanner.nextInt();
      i++;
    }
    ans =  lis(arr,n,0);
    int answer = lisDp(arr);
    System.out.println(answer);

  }

  private static int lisDp(int[] arr) {
    int dp[] = new int[arr.length];
    dp[0] = 1;
    for (int i=1;i<arr.length;i++)
    {
      for(int j=0;j<i;j++){
        if(arr[i]>arr[j]){
          int possibleAns = dp[j]+1;
          dp[i] = Math.max(dp[i],possibleAns);
        }
        else{
          dp[i] = Math.max(dp[i],1);
        }
      }
    }
    int largest = 0;
    for(int i=0;i<dp.length;i++)
    {
      if(largest<dp[i]){
        largest = dp[i];
      }

    }
    return largest;
  }


  /* wrong implementation * :  Add on loop at line 59 to check for all the elements after it,
  each element should be greater not just the next element in order to ensure increasing
  subsequence.
   */
  private static int lis(int[] arr, int n, int count) {
    if(n==0)
    {
      return count;
    }
    if(n==2){
      return arr[n-1]>arr[n-2] ? count+1 : count;
    }

    if(arr[n-1]<arr[n-2]){
      count =  lis(arr,n-1,count);
      return count;
    }
    else{
      int option1 = lis(arr,n-1,count+1);
      int option2 = lis(arr,n-1,count);
      count = Math.max(option1,option2);
      if(count>ans){
        ans = count;
      }
      return count;
    }
  }
}
