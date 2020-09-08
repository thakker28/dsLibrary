package dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class DiameterOfTree {
  static class BinaryTreeNode<Integer>{
    int data;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;
    BinaryTreeNode(int data)
    {
      this.data = data;
      left=right=null;
    }

  }
  static  Scanner scanner = new Scanner(System.in);
  public static int diameter = Integer.MIN_VALUE;
  public static void main(String[] args) {
    BinaryTreeNode<Integer> root = takeInput();
    largestDiameter(root,0);
    System.out.println(diameter);
  }

  private static int largestDiameter(BinaryTreeNode<Integer> root, int d) {
    if(root==null)
    {
      return d;
    }

    int leftHeight = largestDiameter(root.left,d);
    int rightHeight = largestDiameter(root.right,d);

    int temp = 1+Math.max(leftHeight,rightHeight); // path does not include node, it moves to
    // upper direction, in short including root.

    int ans = Math.max(temp,1+leftHeight+rightHeight); // longest path doesn;t include root.

    diameter = Math.max(diameter,ans);
    return temp;
  }

  private static BinaryTreeNode<Integer> takeInput() {
    int rootData = scanner.nextInt();
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
    Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
    queue.add(root);
    BinaryTreeNode<Integer> current = null;
    while (!queue.isEmpty())
    {
      try{
        current = queue.remove();
      }
      catch(Exception e)
      {

      }
      int left = scanner.nextInt();
      int right = scanner.nextInt();
      if(left != -1){
        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
        current.left = leftChild;
        queue.add(leftChild);
      }

      if(right != -1){
        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
        current.right = rightChild;
        queue.add(rightChild);
      }
    }
    return root;
  }
}
