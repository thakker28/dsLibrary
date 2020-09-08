package arraysandstrings;

import java.util.Scanner;

public class LargerNumber {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
           // Long n = scanner.nextLong();
    //        String s = n+"";
    //        String ans = minFromPermutationOfString(s)[0];
            int n = scanner.nextInt();
            int ans = largerElement(n);
            if(n==ans)
            {
                System.out.println("-1");
            }
            else
            {
                System.out.println(ans);
            }

        }

        private static int largerElement(int n) {
            int arr[] = new int[10];
            int j= 9;
            int i;
            while(n>0)
            {
                arr[j--] = n%10;
                n = n/10;
            }
            int startingPoint = j+1;
            for(i = arr.length-1 ; i>startingPoint ;i--)
            {
                if(arr[i-1]<arr[i])
                {
                  break;
                }
            }
            if(i==startingPoint)
            {
                return -1;
            }
            int pos1 = i-1;
            int pos2 = i;
            for(i=pos2;i<arr.length;i++)
            {
                if(arr[i]>arr[pos1] && arr[i]<arr[pos2])
                {
                    pos2 = i;
                }
            }
            swap(arr,pos1,pos2);
            for(i=pos1+1;i<arr.length;i++)
            {
                for(int k=pos1+1;k<arr.length-1;k++)
                {
                    if(arr[k]>arr[k+1])
                    {
                        swap(arr,k,k+1);
                    }
                }
            }
            return formNumber(arr,startingPoint);
        }

        private static int formNumber(int[] arr , int startingPoint) {
            int ans =0;
            int power = 0;
            for(int i = arr.length-1;i>=startingPoint;i--)
            {
                //ans = ans+ (int)(Math.pow(10,power)) * arr[i];
                int x = (int)(arr[i] * Math.pow(10,power));
                ans = ans +x;
                if(ans<0)
                {
                    return -1;
                }
                power++;
            }
            return ans;
        }

        private static void swap(int[] arr, int pos1, int pos2) {
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
        }

    /* Not the correct solution */
    private static String[] minFromPermutationOfString(String s) {
        Long min = Long.MAX_VALUE;
        if(s.length()==1)
        {
            String res [] = new String[1];
            res[0] = s;
            return res;
        }
        String smallOutput[] = minFromPermutationOfString(s.substring(1));
        for(int i = 0;i<=smallOutput[0].length();i++)
        {
            Long number = Long.valueOf(smallOutput[0].substring(0,i)+s.charAt(0)+smallOutput[0].substring(i));
            if(min>number && number>Long.parseLong(s))
            {
                min = number;
            }
        }
        if(min==Long.MAX_VALUE)
        {
            String arr[] = new String[1];
            arr[0] = s+"";
            return arr;
        }
        else
        {
            String arr[] = new String[1];
            int n = s.length();
            arr[0] = (min+"").length()==s.length() ? min+"" : String.format("%0"+n+"d",min);
            return arr;
        }
    }
}
