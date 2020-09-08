package arraysandstrings;

import java.util.*;

public class Frequency2Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i =0;
        while(i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        Map<Integer,Integer> map = frequency2elements(arr);
//        for(Map.Entry<Integer,Integer> entry : map.entrySet())
//        {
//            if(entry.getValue()==2)
//            {
//                System.out.print(entry.getKey()+" ");
//            }
//        }
        frequency2elementsWithoutUsingMap(arr);
    }

    private static void frequency2elementsWithoutUsingMap(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<arr.length;i++)
        {
            int index  = Math.abs(arr[i]);
            if(arr[index-1]<0)
            {
                list.add(index);
            }
            else
            {
                arr[index-1] = arr[index-1] * -1;
            }
        }
        System.out.println(list);
    }

    private static Map<Integer, Integer> frequency2elements(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.get(arr[i])==null ? 1 : map.get(arr[i])+1);

        }
        return map;
    }
}
