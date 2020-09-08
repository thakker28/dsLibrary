package leetcode;

import java.util.Scanner;

public class LargestBST {
    static class Bst
    {
        int min;
        int max;
        boolean isBst;
        int height;
        Bst(int min , int max , boolean isBst , int height)
        {
            this.min = min;
            this.max = max;
            this.isBst = isBst;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
        BinaryTreeNode<Integer> current = null;
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            try {
                current = queue.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }
            int left = scanner.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                current.left = leftChild;
                queue.enqueue(current.left);
            }
            int right = scanner.nextInt();
            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                current.right = rightChild;
                queue.enqueue(current.right);
            }
        }
        System.out.println(helper(root).height);
    }
        private static Bst helper(BinaryTreeNode<Integer> root)
        {
            if(root == null)
            {
                return new Bst(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);
            }
            Bst left = helper(root.left);
            Bst right = helper(root.right);

            if(left.isBst && right.isBst && left.max<root.data && right.min>root.data)
            {
                return new Bst(Math.min(left.min,Math.min(right.min,root.data)) , Math.max(left.max,Math.max(right.max,root.data)),
                        true, Math.max(left.height,right.height)+1);
            }
            else
            {
                return new Bst(Math.min(left.min,Math.min(right.min,root.data)) , Math.max(left.max,Math.max(right.max,root.data)),
                        false, Math.max(left.height,right.height));
            }
        }
    }





