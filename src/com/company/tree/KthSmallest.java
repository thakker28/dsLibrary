package tree;

import java.util.Scanner;

public class KthSmallest {
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
        String s = scanner.nextLine();
        BinaryTree root = formTree(s);
        int k = scanner.nextInt();
        inorder(root,k);
    }

    private static int inorder(BinaryTree root, int k) {
        if(root==null)
        {
            return k;
        }
        k = inorder(root.left,k);
        if(k-1 ==0)
        {
            System.out.println(root.data);
        }
        k = inorder(root.right,k-1);
        return k;

    }

    private static BinaryTree formTree(String s) {
        String arr[] = s.trim().split("\\s+");
        BinaryTree root = null;
        for(int i =0;i<arr.length;i++)
        {
            root = insert(root,arr[i]);
        }

        return root;
    }

    private static BinaryTree insert(BinaryTree root, String s) {
        if(root==null)
        {
            return new BinaryTree(Integer.parseInt(s));
        }
        if(!s.equals("null"))
        {
            if(Integer.parseInt(s)<root.data)
            {
                root.left = insert(root.left,s);
            }
            else
            {
                root.right = insert(root.right,s);
            }
        }
        return root;
    }
}
