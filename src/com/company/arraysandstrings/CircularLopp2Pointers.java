package arraysandstrings;

import java.util.Scanner;

public class CircularLopp2Pointers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = scanner.nextInt();
        }
        System.out.print(circularArray(arr));
    }

    private static int circularArray(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            int slow = i;
            int fast = i;
            while(arr[slow]*arr[next(arr,slow)]>0 && arr[fast]*arr[next(arr,fast)]>0 && arr[fast]*arr[next(arr,next(arr,fast))]>0)
            {
                slow = next(arr,slow);
                fast = next(arr,next(arr,fast));
                if(slow==fast)
                {
                    if(slow==next(arr,slow))
                    {
                        break;
                    }
                    return 1;
                }
            }
            /* can make the elements as 0 which are breaking the cycle (direction is getting reveresed) */
        }
        return 0;
    }

    private static int next(int[] arr, int slow) {
        return (slow+arr[slow]+arr.length)%arr.length;
    }
}
