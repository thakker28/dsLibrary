package arraysandstrings;

import java.util.Scanner;

public class PetrolPumps {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int  i = 0;
        int gas[] = new int[n];
        int cost[] = new int[n];
        while(i<n)
        {
            gas[i] = scanner.nextInt();
            i++;
        }
        i=0;
        while(i<n)
        {
            cost[i] = scanner.nextInt();
            i++;
        }
        System.out.println(petrolPumpNumber(gas,cost));
    }

    private static int petrolPumpNumber(int[] gas, int[] cost) {
        int i = 0;
        int j=0;
        int totalGas = 0;
        int totalCost = 0;
        int gasleft = 0;
        for(i=0;i<cost.length;i++)
        {
            totalCost =totalCost+cost[i];
            totalGas =totalGas+gas[i];
        }
        if(totalGas<totalCost)
        {
            return -1;
        }

        for(i = 0;i<gas.length;i++)
        {
            gasleft = 0;
            for(j=i;j<cost.length;j++)
            {
                 gasleft = gasleft+ gas[j]-cost[j];

                if(gasleft<0)
                {
                    break;
                }


//                else if( gasleft + gas[j+1]<cost[j+1])
//                    {
//                        break;
//                    }
            }
            if(gasleft>0 && j==cost.length)
            {
                break;
            }
        }

        return i;
    }
}
