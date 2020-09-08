package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumPathSum {


    static int ans = Integer.MIN_VALUE;
    static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rootData = scanner.nextInt();
        BinaryTree root = new BinaryTree(rootData);
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(root);
        BinaryTree current = null;
        while(!queue.isEmpty())
        {
            try
            {
                current = queue.remove();
            }
            catch (Exception e)
            {

            }
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if(left != -1)
            {
                BinaryTree leftChild = new BinaryTree(left);
                current.left = leftChild;
                queue.add(leftChild);
            }
            if(right != -1)
            {
                BinaryTree rightChild = new BinaryTree(right);
                current.right = rightChild;
                queue.add(rightChild);
            }
        }
        maxPathSum(root);
        System.out.print(ans);

    }

    private static int maxPathSum(BinaryTree root) {
        if(root==null)
        {
            return 0;
        }

        int leftSum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);
        int returnMax = Math.max(leftSum + root.data,rightSum+root.data);
        int max =  Math.max(returnMax,root.data+leftSum+rightSum);
        if(max>ans)
        {
            ans = max;
        }
        return returnMax;

    }

}
