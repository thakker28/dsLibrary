package graphs;

import java.util.Scanner;

public class FloodFill {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int image[][] = new  int[n][m];
    for(int i=0;i<n;i++)
    {
      for(int j = 0;j<m;j++){
        image[i][j] = scanner.nextInt();
      }
    }
    int sr = scanner.nextInt();
    int sc = scanner.nextInt();
    int newColor = scanner.nextInt();

    floodFill(image , sr , sc , newColor);
    for(int i=0;i<image.length;i++)
    {
      for(int a : image[i])
      {
        System.out.print(a+" ");
      }
      System.out.println(" ");
    }

  }

  private static void floodFill(int[][] image, int sr, int sc, int newColor) {
    if(image[sr][sc] == newColor)
    {
      return;
    }
    helper(image , sr,sc,newColor , image[sr][sc]);
  }

  private static void helper(int[][] image, int sr, int sc, int newColor , int source) {
    if(sr<0 || sr>= image.length || sc<0 || sc>=image[0].length){
      return;
    }

    if(image[sr][sc] != source)
    {
      return;
    }

    image[sr][sc] = newColor;

    helper(image , sr-1 , sc , newColor , source); //top
    helper(image , sr+1 , sc , newColor , source); //bottom
    helper(image , sr , sc-1 , newColor , source); //left
    helper(image , sr , sc+1 , newColor , source); //right
  }
}
