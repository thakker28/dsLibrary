package arraysandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OverHappyNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        if(checkOverHappy(n , map))
        {
            System.out.println("true");
        }
        else

        {
            System.out.println("false");
        }
    }

    private static boolean checkOverHappy(int n,Map<Integer,Integer> map) {
        if(n==1)
        {
            return true;
        }
        if(map.get(n)!=null)
        {
            return false;
        }
        map.put(n,1);
        n = update(n);
        return checkOverHappy(n,map);
    }

    private static int update(int n) {
        int s = 0;
        while(n>0)
        {
            int last = n%10;
            s = s+last*last;
            n=n/10;
        }
        return s;
    }

}
