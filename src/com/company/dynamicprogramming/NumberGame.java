package dynamicprogramming;


import java.util.Scanner;

/*
Gary loves to play with numbers. Today he has an array A of N integers. He came up with a game
and decided to play it.
Given an array A consisting of N integers. The player can make several steps.In a single step he
can choose an element of the array (let's denote it A[k]) and delete it. And then all elements
equal to A[k] + 1 and A[k] - 1 also must be deleted from the array. That step brings A[k] points to the player.
Gary is a perfectionist, so he decided to get as many points as possible. Help him.
 */
 public class NumberGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int arr[] = new int[n];
    int i = 0;
    while(i<n){
      arr[i] = scanner.nextInt();
      i++;
    }
    long ans = maxProfit(arr,n);
    System.out.println(ans);
  }

  private static long maxProfit(int[] arr, int n) {
    int freq[] = frequencyArray(arr,n);
    long dp[] = new long[freq.length];
    dp[0] = 0;
    dp[1] = freq[1];
    for(int i=2;i<dp.length;i++){
      dp[i] = Math.max(dp[i-1],dp[i-2]+i*freq[i]);
    }
return dp[freq.length-1]; /* Instead of taking freq array length, we can return
dp[largestElement] */
  }

  private static int[] frequencyArray(int[] arr, int n) {
    int max = 0;
    for(int i=0;i<n;i++){
      if(max<arr[i]){
        max = arr[i];
      }
    }

    int freq[] = new int[max+1];

    for(int i=0;i<n;i++){
      freq[arr[i]]++;
    }
    return freq;
  }
}
