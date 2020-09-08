package arraysandstrings;

import java.util.Arrays;
import java.util.Scanner;

public class PartyHalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        int i = 0;
        while(i<n)
        {
            start[i] = scanner.nextInt();
            end[i] = scanner.nextInt();
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = numberOfPartyHalls(start,end);
        System.out.println(res);
    }

    private static int numberOfPartyHalls(int start[] , int end[]) {
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while(i<start.length && j<end.length)
        {
            if(start[i]<end[j])
            {
                count++;
                i++;
            }
            else
            {
                count--;
                j++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
