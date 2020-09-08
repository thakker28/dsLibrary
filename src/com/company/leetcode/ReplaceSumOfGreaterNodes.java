package leetcode;

import java.util.Scanner;

public class ReplaceSumOfGreaterNodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rootData = scanner.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        BinaryTreeNode<Integer> current = null;
        while(!queue.isEmpty())
        {
            try
            {
                current = queue.dequeue();
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
                queue.enqueue(leftChild);
            }
            if(right !=-1)
            {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                current.right = rightChild;
                queue.enqueue(rightChild);
            }
        }
        replaceSum(root,0);
        printLevelOrderTraversal(root);
    }

    private static void printLevelOrderTraversal(BinaryTreeNode<Integer> root) {
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        queue.enqueue(null);
        BinaryTreeNode<Integer> current = null;
        while(!queue.isEmpty())
        {
            try
            {
                current = queue.dequeue();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            if(queue.isEmpty())
            {
                break;
            }
            if(current==null)
            {
                System.out.println(" ");
                queue.enqueue(null);
            }
            else
            {
                System.out.print(current.data+" ");
                if(current.left != null)
                {
                    queue.enqueue(current.left);
                }
                if(current.right != null)
                {
                    queue.enqueue(current.right);
                }
            }
        }
    }

    private static int replaceSum(BinaryTreeNode<Integer> root, int sum) {
        if(root == null)
        {
            return sum;
        }
        sum = replaceSum(root.right,sum);
        sum = sum + root.data;
        root.data = sum;
        sum =  replaceSum(root.left,sum);
        return sum;
    }
}
