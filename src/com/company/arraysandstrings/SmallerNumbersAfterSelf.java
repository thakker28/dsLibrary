package arraysandstrings;

import java.util.Scanner;

public class SmallerNumbersAfterSelf {
    static class Pair
    {
        int index;
        int value;
        Pair(int index , int value)
        {
            this.index = index;
            this.value = value;
        }
    }
static int ans[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pair arr[] = new Pair[n];
        ans = new int[n];
        for(int i=0;i<n;i++)
        {
            int index = i;
            int value = scanner.nextInt();
            arr[i] = new Pair(index,value);
        }
        mergeSort(arr,0,arr.length-1);
        for(int i : ans)
        {
            System.out.print(i+" ");
        }
    }

    private static void mergeSort(Pair[] arr, int start, int end) {
        if(start>=end)
        {
            return;
        }
        int mid  = (start+end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    private static void merge(Pair[] arr, int start, int mid, int end) {
        Pair first[] = new Pair[mid-start+1];
        Pair second[] = new Pair[end-mid];
        for(int i=start;i<=mid;i++)
        {
            first[i-start] = arr[i];
        }
        for(int i=mid+1;i<=end;i++)
        {
            second[i-mid-1] = arr[i];
        }
        int i=0 , j=0 , k = start;
        int count=0;

        while(i<first.length && j<second.length)
        {
            if(second[j].value<first[i].value)
            {
                count++;
                arr[k++] = second[j];
                j++;
            }
            else{
                ans[first[i].index] = ans[first[i].index]+count;
                arr[k++] = first[i];
                i++;
            }
        }
        while(i<first.length)
        {
            ans[first[i].index] = ans[first[i].index] + count;
            arr[k++] = first[i++];
        }
        while(j<second.length)
        {
           // ans[first[i].index] = ans[first[i].index] + count;
            arr[k++] = second[j++];
        }

    }

}
