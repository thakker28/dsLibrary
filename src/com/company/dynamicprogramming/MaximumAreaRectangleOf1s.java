package dynamicprogramming;

import java.util.Scanner;
import java.util.Stack;

public class MaximumAreaRectangleOf1s {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                arr[i][j] = scanner.nextInt();
            }
        }

        int ans = maximumArea(n,m,arr);
        System.out.println(ans);
    }

    private static int maximumArea(int n , int m ,int[][] arr) {
        int dp[] = new int[arr[0].length];
        int maxArea = 0;
        for(int i=0 ;i <n ; i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==1)
                {
                    dp[j] = dp[j]+1;
                }
                else {
                    dp[j] = 0;
                }
            }
            maxArea = Math.max(maxArea,rectangleAreaInAHistogram(dp));
        }
        return maxArea;
    }

    private static int rectangleAreaInAHistogram(int[] dp) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(0);
        int i;
        for(i =1;i<dp.length;i++)
        {

            if(stack.isEmpty())
            {
                stack.push(i);
            }
            else if(dp[i]>dp[stack.peek()])
            {
                stack.push(i);
            }
            else
            {
              while(dp[stack.peek()] > dp[i])
              {
                  int poppedElementIndex = stack.pop();
                  if(stack.isEmpty())
                  {
                      maxArea = Math.max(maxArea,dp[poppedElementIndex]*i);
                      break;
                  }
                  else
                  {
                      maxArea = Math.max(maxArea,dp[poppedElementIndex]*(i-stack.peek()-1));
                  }
              }
              stack.push(i);
            }
        }


            while (!stack.isEmpty())
            {
                int poppedElementIndex = stack.pop();
                if(stack.isEmpty())
                {
                    maxArea = Math.max(maxArea,dp[poppedElementIndex]*i);
                }
                else
                {
                    maxArea = Math.max(maxArea,dp[poppedElementIndex]*(i-stack.peek()-1));
                }
            }
        return maxArea;

    }
}
