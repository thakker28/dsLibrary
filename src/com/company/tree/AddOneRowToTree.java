package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AddOneRowToTree {
    static Scanner scanner = new Scanner(System.in);
    static class BinaryTreeNode
    {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = takeInput();
        int value = scanner.nextInt();
        int depth = scanner.nextInt();
       BinaryTreeNode updatedRoot =  formTree(root,value,depth);
       displayTree(updatedRoot);

    }

    private static void displayTree(BinaryTreeNode root) {
        if(root==null)
        {
            return ;
        }
        String s ="";
        if(root.left != null)
        {
            s = root.left.data+" "+"<-"+" ";
        }
        else
        {
            s = " <- ";
        }
        s = s + root.data + " " +"-> ";
        if(root.right != null)
        {
            s = s+root.right.data;
        }
        System.out.println(s);
        displayTree(root.left);
        displayTree(root.right);
    }

    private static BinaryTreeNode formTree(BinaryTreeNode root, int value, int depth) {
        if(depth ==1)
        {
            BinaryTreeNode updatedRoot = new BinaryTreeNode(value);
            updatedRoot.left = root;
            return updatedRoot;
        }
        if (root == null) {
            return null;
        }
        int level = 1;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        queue.add(null);
        BinaryTreeNode current = null;
        while (!queue.isEmpty()) {
            try {
                if (level == depth - 1) {
                    while (!queue.isEmpty()) {
                        current = queue.remove();
                        if (current != null) {
                            BinaryTreeNode oldLeft = current.left;
                            BinaryTreeNode oldRight = current.right;
                            BinaryTreeNode newLeft = new BinaryTreeNode(value);
                            BinaryTreeNode newRight = new BinaryTreeNode(value);
                            current.left = newLeft;
                            current.right = newRight;
                            newLeft.left = oldLeft;
                            newRight.right = oldRight;
                        }
                    }
                }

                current = queue.remove();
                if (current == null) {
                    level++;
                    queue.add(null);
                } else {
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }
                }


            }

            catch (Exception e)
            {

            }
        }
        return root;


    }

    private static BinaryTreeNode takeInput()
    {
        int rootData = scanner.nextInt();
        BinaryTreeNode root = new BinaryTreeNode(rootData);

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
