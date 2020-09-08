package stackandqueue;

import java.util.*;

public class AverageOfSlidingWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int x=0;
        while(x != -1)
        {
            x = scanner.nextInt();
            list.add(x);
        }
        printAverageForSlidingWindow(list,n);
    }

    private static void printAverageForSlidingWindow(List<Integer> list, int n) {
        int sum = 0;
        float avg = 0f;
        List<Float> ans = new ArrayList<Float>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0;i<list.size()-1;i++)
        {


            if(i<n)
            {
                 queue.add(list.get(i));
                 sum = sum + list.get(i);
                 avg = (float) sum/queue.size();
                 ans.add(avg);
            }
            else
            {
                sum = sum - queue.remove();
                sum = sum + list.get(i);
                queue.add(list.get(i));
                avg = (float) sum/n; // or queue.size()
                ans.add(avg);
            }
        }
        for(Float a : ans)
        {
            System.out.printf("%.4f",a);
            System.out.print(" ");
        }
    }
}
