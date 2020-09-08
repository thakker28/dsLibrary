package arraysandstrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AttendAllMeeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[][] = new int[n][2];
        int k=0;
        for(int i = 0;i<n;i++)
        {
          int start = scanner.nextInt();
          int end = scanner.nextInt();
          arr[i][0] = start;
          arr[i][1] = end;
        }
    System.out.println(meeting(arr));
    }

    private static boolean meeting(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0])
                {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });
        for(int i=1;i<arr.length;i++)
        {

                if(arr[i-1][1]>arr[i][0])
                {
                    return false;
                }

        }
        return true;
    }
}
