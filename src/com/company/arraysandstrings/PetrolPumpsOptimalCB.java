package arraysandstrings;

import java.util.Scanner;

public class PetrolPumpsOptimalCB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int gas[] = new int[n];
        int cost[] = new int[n];
        int i = 0;
        while(i<n)
        {
            gas[i]=scanner.nextInt();
            i++;
        }
        i=0;
        while(i<n)
        {
            cost[i]=scanner.nextInt();
            i++;
        }
        System.out.println(petrolPumpNumber(gas,cost));
    }

    private static int petrolPumpNumber(int[] gas, int[] cost) {
        int net = 0;
        int current = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++)
        {
            net = net + gas[i] - cost[i];
            current = current + gas[i]-cost[i];
            if(current<0)
            {
                current = 0;
                start = i+1;
            }
        }
        if(net<0)
        {
            return -1;
        }
        return start;
    }
}
