package arraysandstrings;

import java.util.Scanner;

public class SudokuChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char arr[][] = new char[9][9];
        int i = 0;
        int j = 0;
        while (i<9)
        {
            while(j<9)
            {
                arr[i][j] = scanner.next().charAt(0);
                j++;
            }
            i++;
        }
      //  System.out.println(sudokuChecker(arr));
    }

//    private static boolean sudokuChecker(char[][] arr) {
//        for(int i=0;i<arr.length;i++)
//        {
//            for(int j = 0;j<arr.length;j++)
//            {
//                if(arr[i][j]!='.')
//                {
//                    if(arr[i][)
//                }
//            }
//        }
//    }
}
