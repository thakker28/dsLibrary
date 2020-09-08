package dynamicprogramming;

import java.util.Scanner;

public class EggDroppingProblem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int eggs = scanner.nextInt();
    int floors = scanner.nextInt();
    int ans = minWaysForWorstCaseScenario(eggs,floors);
    int dp[][] = new int[eggs+1][floors+1];
    int ans2 = minWaysForWorstCaseScenarioMemoization(eggs,floors,dp);
    int ans3 = minWaysForWorstCaseScenarioTabulation(eggs,floors);
    System.out.println(ans3);
    System.out.println(ans);
    System.out.println(ans2);
  }

  private static int minWaysForWorstCaseScenarioTabulation(int eggs, int floors) {
    int dp[][] = new int[eggs+1][floors+1];
    for(int i=0,j=0;i<dp.length;i++)
    {
      dp[i][j] = 0;
    }

    for(int i=0,j=1;j<dp[i].length;j++)
    {
      dp[i][j] = 0;
    }

    for(int i=0;i<dp.length;i++)
    {
      dp[i][1] = 1;
    }

    for(int j=1;j<=floors;j++)
    {
      dp[1][j] = j;
    }

    for(int i=2;i<dp.length;i++)
    {
      for(int j=2;j<dp[i].length;j++)
      {
        int min = Integer.MAX_VALUE;
        for(int k =1;k<=j;k++)
        {
          int tempAns = 1 + Math.max(dp[i-1][k-1] , dp[i][j-k]);

          if(min>tempAns)
          {
            dp[i][j]=min = tempAns;
          }
        }
        dp[i][j]= min;
      }
    }
    return dp[eggs][floors];
  }

  private static int minWaysForWorstCaseScenarioMemoization(int eggs, int floors, int[][] dp) {
    if(floors<=1 || eggs==1)
    {
      return floors;
    }

    if(dp[eggs][floors]>0)
    {
      return dp[eggs][floors];
    }

    int min = Integer.MAX_VALUE;
    int temp1 = 0;
    int temp2 = 0;

    for(int k =1;k<=floors;k++)
    {
      if(dp[eggs-1][k-1]>0)
      {
        temp1= dp[eggs-1][k-1];
      }
      else{
        temp1 = minWaysForWorstCaseScenarioMemoization(eggs-1,k-1,dp);
        dp[eggs-1][k-1] = temp1;
      }



      if(dp[eggs][floors-k]>0)
      {
        temp2 = dp[eggs][floors-k];
      }
      else{
        temp2 =  minWaysForWorstCaseScenarioMemoization(eggs, floors-k,dp);
        dp[eggs][floors-k] = temp2;
      }



      int tempAns = 1 + Math.max(temp1 ,temp2);

      if(min>tempAns)
      {
       dp[eggs][floors]= min = tempAns;
      }
    }
    return min;

  }

  private static int minWaysForWorstCaseScenario(int eggs, int floors) {

    if(floors<=1 || eggs==1)
    {
      return floors;
    }

    int min = Integer.MAX_VALUE;

    for(int k =1;k<=floors;k++)
    {
      int tempAns =
          1 + Math.max(minWaysForWorstCaseScenario(eggs-1,k-1) , minWaysForWorstCaseScenario(eggs,
          floors-k));

      if(min>tempAns)
      {
        min = tempAns;
      }
    }
    return min;
  }
}
