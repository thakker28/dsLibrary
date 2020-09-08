package tree;

import jdk.nashorn.internal.runtime.ECMAException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RightSideView {
    static class BinaryTree
    {
        int data;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int data)
        {
            this.data = data;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rootData = scanner.nextInt();
        BinaryTree root = new BinaryTree(rootData);
        Queue<BinaryTree> queue = new LinkedList<>();
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

        printRightSide(root);
    }

    private static void printRightSide(BinaryTree root) {
        if(root==null)
        {
            return;
        }
        System.out.print(root.data+" ");
        printRightSide(root.right);
    }
}
