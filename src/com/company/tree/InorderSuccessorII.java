package tree;

import java.util.Scanner;

public class InorderSuccessorII {
    static Scanner scanner = new Scanner(System.in);
    private static class BinarySearchTree
    {
        int data;
        BinarySearchTree left ;
        BinarySearchTree right;
        BinarySearchTree parent;
        BinarySearchTree(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int i = 0;
        BinarySearchTree root = null;
        BinarySearchTree parent = null;
        while(i<n)
        {
            int childData = scanner.nextInt();
            root = insert(root,childData,parent);
            i++;
        }
        int p = scanner.nextInt();
        BinarySearchTree node = find(p,root);
        findSuccessor(node,p);
    }

    private static BinarySearchTree find(int p , BinarySearchTree root) {
        if(root == null)
        {
            return null;
        }
        if(root.data == p)
        {
            return root;
        }
        BinarySearchTree left = find(p,root.left);
        if(left != null)
        {
            return left;
        }
        BinarySearchTree right = find(p,root.right);
        if(right != null)
        {
            return right;
        }
        return null;
    }

    private static void findSuccessor(BinarySearchTree node, int p) {
        if(node==null)
        {
            return;
        }
        if( node.right != null)
        {
            BinarySearchTree current = node.right;
            while(current.left != null)
            {
                current = current.left;
            }
          System.out.println(current.data);
        }
        else if(node.right == null)
        {
            BinarySearchTree current = node.parent;
            if(node.data<node.parent.data)
            {
                System.out.println(node.parent.data);
            }
            else
            {
                while(current!=null && current.data<node.data)
                {
                    current = current.parent;
                }
                if(current==null)
                {
                    System.out.println("");
                }
                else
                {
                    System.out.println(current.data);
                }

            }
        }


    }

    private static BinarySearchTree insert(BinarySearchTree root, int childData , BinarySearchTree parent) {
        if(root == null)
        {
            BinarySearchTree node = new BinarySearchTree(childData);
            node.parent = parent;
            return node;
        }
        if(childData<root.data)
        {
            root.left = insert(root.left,childData,root);
        }
        else
        {
            root.right = insert(root.right,childData,root);
        }
        return root;
    }
}
