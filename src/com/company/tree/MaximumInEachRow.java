package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumInEachRow {
    static class BinaryTreeNode<Integer>
    {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        BinaryTreeNode(int data)
        {
            this.data = data;
            right = left = null;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        BinaryTreeNode<Integer> current = null;
        queue.add(root);
        while(!queue.isEmpty())
        {
            try
            {
                current = queue.remove();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            if(left!=-1)
            {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                current.left = leftChild;
                queue.add(leftChild);
            }
            if(right != -1)
            {
                BinaryTreeNode<Integer> rightChild  = new BinaryTreeNode<>(right);
                current.right = rightChild;
                queue.add(rightChild);
            }
        }
        printMaxInEachRow(root);
    }

    private static void printMaxInEachRow(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
        queue.add(root);
        queue.add(null);
        int max = -1;
        BinaryTreeNode<Integer> current = null;
        while(!queue.isEmpty())
        {
            try {
                current = queue.remove();
            }
            catch (Exception e)
            {

            }
            if(queue.isEmpty())
            {
                break;
            }
            if(current==null)
            {
                System.out.print(max+" ");
                queue.add(null);
            }
            else
            {
                if(current.left != null)
                {
                    queue.add(current.left);
                }
                if(current.right != null)
                {
                    queue.add(current.right);
                }
                if(max<current.data)
                {
                    max = current.data;
                }
            }
        }
        System.out.print(max);
    }
}
