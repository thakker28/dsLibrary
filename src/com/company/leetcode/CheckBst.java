package leetcode;

import java.util.Scanner;

public class CheckBst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
        BinaryTreeNode<Integer> current = null;
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        while(!queue.isEmpty())
        {
            try {
                current = queue.dequeue();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            int left = scanner.nextInt();
            if(left!=-1)
            {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                current.left = leftChild;
                queue.enqueue(current.left);
            }
            int right = scanner.nextInt();
            if(right!=-1)
            {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                current.right = rightChild;
                queue.enqueue(current.right);
            }
        }
        System.out.println(isBst(root));
    }

    private static boolean isBst(BinaryTreeNode<Integer> root) {
        boolean b1,b2 =true;
        if(root==null || (root.left==null && root.right==null))
        {
            return true;
        }
        if(root.left != null && root.right!= null)
        {
            if(!(root.data>root.left.data && root.data<root.right.data))
            {
                return false;
            }

        }

        if(root.left==null)
        {
            if(!(root.data<root.right.data))
            {
                return false;
            }

        }
        if(root.right==null)
        {
            if(!(root.data>root.left.data))
            {
                return false;
            }
        }
         b1 = isBst(root.left);
         b2 = isBst(root.right);
        return b1 && b2;
    }
}
