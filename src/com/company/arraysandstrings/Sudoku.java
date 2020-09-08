package arraysandstrings;

import java.util.Scanner;

public class Sudoku {
    static class SudokuPair
    {
        boolean isSafe;
        int arr[][];
        SudokuPair(boolean isSafe , int arr[][])
        {
            this.isSafe =isSafe;
            this.arr = arr;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n!=9)
        {
            System.out.println("Sudoku works on only 9 rows and 9 columns");
        }
        else
        {
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=scanner.nextInt();
                }
            }
            boolean ans = solveSudoku(arr,0,0).isSafe;
            if(ans)
            {
                int resArr[][] = solveSudoku(arr,0,0).arr;
                for(int i=0;i<resArr.length;i++)
                {
                    for(int j=0;j<resArr.length;j++)
                    {
                        System.out.print(arr[i][j]+" ");
                    }
                    System.out.println(" ");
                }
            }
            else
            {
                System.out.println("Sudoku is not solvable");
            }

        }


    }

    private static SudokuPair solveSudoku(int[][] arr, int i, int j) {
        if(i==arr.length-1 && j==arr.length)
        {
            if(isSafe(arr,i,j-1,arr[i][j-1])) /* what should be the value given here for num in isSafe method */
            {
                /* How to update the array */
                return new SudokuPair(true,arr);
            }
            else
            {
                return new SudokuPair(false,arr);
            }
        }
if(j==9)
{
    i++;
    j=0;
}
        SudokuPair pair = solveSudoku(arr,i,j+1);

        if(pair.isSafe)
        {
            /* checking only for first column (Is this correct way?)*/
            for(int num=1;num<=9;num++)
            {
                if(pair.arr[num-1][0]==0)
                {
                    if(isSafe(arr,i,j,num))
                    {
                        pair.arr[num-1][0]=num;
                    }
                    else
                    {
                        return new SudokuPair(false,arr);
                    }
                }
            }
        }
        return new SudokuPair(true,arr);
    }

    private static boolean isSafe(int[][] arr, int i, int j, int num) {
        for(int a = 0 ; a<arr.length;a++)
        {
            if(arr[i][a]==num || arr[a][j]==num)
            {

                    return false;
            }
        }

        int row = (i/3)*3;
        int column = (j/3)*3;
        for(int k=row;k<row+3;k++)
        {
            for(int m=column;m<column+3;m++)
            {
                if(arr[k][m]==num)
                {
                    return false;
                }
            }
        }
return true;
    }
}
