package tree;

import java.util.Scanner;

public class CountBinaryTreeNodes {
    static Scanner scanner = new Scanner(System.in);
    static class BinaryTreeNode<Integer>
    {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        BinaryTreeNode(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
        System.out.println(countNodes(root));
    }

    private static int countNodes(BinaryTreeNode<Integer> root) {
        if(root==null)
        {
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    private static BinaryTreeNode<Integer> takeInput() {
        int rootData = scanner.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        boolean hasLeft = scanner.nextBoolean();

        if(hasLeft)
        {
            root.left = takeInput();
        }

        boolean hasRight = scanner.nextBoolean();

        if(hasRight)
        {
            root.right = takeInput();
        }
        return root;
    }

}
