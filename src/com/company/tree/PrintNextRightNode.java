package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintNextRightNode {
   private static class BinaryTreeNode<Integer> {
       int data;
       BinaryTreeNode<Integer> left;
       BinaryTreeNode<Integer> right;
       BinaryTreeNode<Integer> nextRight;

       BinaryTreeNode(int data) {
           this.data = data;
           left = right = null;
       }
   }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
            BinaryTreeNode<Integer> current = null;
            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                try {
                    current = queue.remove();
                } catch (Exception e) {
                    System.out.println(e);
                }
                int left = scanner.nextInt();
                if (left != -1) {
                    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                    current.left = leftChild;
                    queue.add(current.left);
                }
                int right = scanner.nextInt();
                if (right != -1) {
                    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                    current.right = rightChild;
                    queue.add(current.right);
                }
            }
            printNextRightElement(root);
   }

    private static void printNextRightElement(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        BinaryTreeNode<Integer> current = null;
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty())
        {
            try
            {
                current = queue.remove();
            }
            catch (Exception e)
            {
                System.out.print(e);
            }
            if(queue.isEmpty())
            {
                break;
            }
            if(current != null)
            {
                if(current.left != null)
                {
                    queue.add(current.left);
                }
                if(current.right != null)
                {
                    queue.add(current.right);
                }
                if(queue.peek()==null)
                {
                    System.out.print("-1"+" ");
                }
                else
                {
                    System.out.print(queue.peek().data+" ");
                }
            }
            else
            {
                queue.add(null);
            }
        }
    }

}





