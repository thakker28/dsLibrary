package dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumPathSumFromAnyNodeToAnyNode {
  static class BinaryTreeNode
  {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int data){
      this.data = data;
      left = right = null;
    }
  }

  static Scanner scanner = new Scanner(System.in);
  static int largestSum = Integer.MIN_VALUE;

  public static void main(String[] args) {
    BinaryTreeNode root = takeInput();
    maxPathSum(root,0);
    System.out.println(largestSum);
  }

  private static int maxPathSum(BinaryTreeNode root, int sum) {
    if(root == null)
    {
      return sum;
    }

    int leftSum = maxPathSum(root.left,sum);
    int rightSum = maxPathSum(root.right,sum);

    int temp = Math.max(root.data,Math.max(leftSum,rightSum)+root.data); // If leaf node to leaf
    // node path sum needs to be calculated, then we can't ignore left and right sum if they are
    // -ve and  start our path directly from root as we need to take only leaf node's path. So
    // whether the sum is -ve, we have to consider it.

    int ans = Math.max(temp,leftSum+rightSum+root.data);

    largestSum = Math.max(ans,temp);
    return temp;
  }

  private static BinaryTreeNode takeInput() {
    int rootData = scanner.nextInt();
    BinaryTreeNode root = new BinaryTreeNode(rootData);
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    BinaryTreeNode current = null;
    while (!queue.isEmpty()){
      try {
        current = queue.remove();
      }
      catch (Exception e){

      }

      int left = scanner.nextInt();
      int right = scanner.nextInt();

      if(left != -1){
        BinaryTreeNode leftChild = new BinaryTreeNode(left);
        current.left = leftChild;
        queue.add(leftChild);
      }

      if(right != -1){
        BinaryTreeNode rightChild = new BinaryTreeNode(right);
        current.right = rightChild;
        queue.add(rightChild);
      }
    }
    return root;
  }

}
