package stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParanthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> ans = new ArrayList<>();
        generate(n,0,0,"",ans);
        for(String s : ans)
        {
            System.out.println(s);
        }
    }

    /* we can also create cases by looking at integer value, let's say 2 so we cna have 2 ( and 2 ) brackets. That means 4 charaters
    would be there. At each position, we can either insert a ( or ) . so each position has 2 choices, For n =2 , we would be
    having 4 positions so total combinations would be 2^4 = 16 and then we can check if they are balanced or not.

    TIME COMPLEXITY : 2^N * O(N) : Therefore use recursion.
     */
    private static void generate(int n, int openBracketsCount, int closeBracketsCount, String s, List<String> ans) {
        if(s.length() == 2*n)
        {
            ans.add(s);
            return;
        }

        if(openBracketsCount<n)
        {
            generate(n,openBracketsCount+1,closeBracketsCount,s+"(",ans);
        }
        if(closeBracketsCount<openBracketsCount)
        {
            generate(n,openBracketsCount,closeBracketsCount+1,s+")",ans);
        }
    }
}
