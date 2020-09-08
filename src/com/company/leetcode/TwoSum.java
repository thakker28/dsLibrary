package leetcode;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int result[] =new int[2];
        Map<Integer,Integer> numbers = new HashMap<>();
        for(int i=0; i< nums.length;i++) {
            numbers.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            if (numbers.containsKey(target-nums[i]) && i!=numbers.get(target-nums[i])){
                return new int[]{i,numbers.get(target-nums[i])};
            }
        }
        return new int[]{};

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int array[] = new int[a];
//        for(int i=0;i<a;i++)
//        {
//            array[i] = sc.nextInt();
//        }
        int x = 4;
        int sum[] = new int[2];
        sum[0] = Integer.MIN_VALUE;
        sum[1] = Integer.MIN_VALUE;
        if(x>=4)
        {
            sum[0] = 1;
            sum[1]=1;
        }
        System.out.print("first"+sum[0]);
        System.out.print("second"+sum[1]);
        //System.out.println(Integer.MIN_VALUE);
        int k =0;
        int res[] = new int[2];
        if(x>4)
        {
            res[k++] = 1;
        }
        else if(x<=4)


        {
            res[k++] =2;
        }
            int arr[] = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(arr,target);
    }
}
