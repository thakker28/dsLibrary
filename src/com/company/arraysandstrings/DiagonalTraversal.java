package arraysandstrings;

import java.util.Scanner;

public class DiagonalTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n =scanner.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j] = scanner.nextInt();
            }
        }
       // int res[] = diagonalElements(arr,m,n);
        int res[] = diagonalElementsCB(arr);
        for(int a:res)
        {
            System.out.print(a+" ");
        }
    }

    private static int[] diagonalElementsCB(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int res[] = new int[m*n];
        int dir =1;
        int row = 0 ;
        int column = 0;
        for(int i=0;i<res.length;i++)
        {
            res[i] =arr[row][column];
            if(dir==1)
            {
                if(column==n-1)
                {
                    row++;
                    dir = -1;
                }
                else if(row==0)
                {
                    column++;
                    dir=-1;
                }
                else
                {
                    row--;
                    column++;
                }
            }
            else
            {
                if(row==m-1)
                {
                    column++;
                    dir =1;
                }
                else if(column==0)
                {
                    row++;
                    dir = 1;
                }
                else{
                    row++;
                    column--;
                }
            }
        }
        return res;
    }

    private static int[] diagonalElements(int[][] arr,int m , int n) {
        int res[] =new int[m*n];
        int k = 0;
        res[k++] =arr[0][0];
        int i = 0;
        int j=0;
        int direction =-1;

        while(i!=m-1 || j!=n-1)
        {
            if(direction==-1) //Downward Direction
            {
                if(j!=n-1) {
                    j=j+1;
                    res[k++] = arr[i][j]; //starting point
                }
                else
                {
                    i = i+1;
                    res[k++] = arr[i][j];
                }
                while(j>0 && i!=m-1)
                {
                    i =i+1;
                    j=j-1;
                    int nextElement = arr[i][j];
                    res[k++] = nextElement;

                }
                direction = direction * -1;
                if(i==m-1 && j==n-1)
                {
                    break;
                }
            }
            if(direction==1) // Upward Direction
            {
                if(i!=m-1)
                {
                    i =i+1;
                    res[k++] = arr[i][j]; //starting point
                }
                else{
                    j=j+1;
                    res[k++] = arr[i][j];
                }
                while(j<n-1 && i!=0)
                {
                    i =i-1;
                    j=j+1;
                    res[k++] = arr[i][j]; //next element
                }
                direction = direction *-1;
            }
        }

return res;

    }
}
