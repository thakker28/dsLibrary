package tree;

import java.util.Scanner;

public class LcaBST {
    static Scanner scanner = new Scanner(System.in);
    static  class BinaryTreeNode<Integer>
    {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        BinaryTreeNode(int data)
        {
            this.data = data;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        int numberOfNodes = scanner.nextInt();
        int i =0;
        BinaryTreeNode<Integer> root = null;
        while(i<numberOfNodes)
        {
            int childData = scanner.nextInt();
            root = takeInput(root,childData);
            i++;
        }

        int node1 = scanner.nextInt();
        int node2 = scanner.nextInt();

        System.out.println(lowestCommonAncestor(root,node1,node2));
    }

    private static int lowestCommonAncestor(BinaryTreeNode<Integer> root, int node1, int node2) {
        if(root==null)
        {
            return -1;
        }
        if(root.data == node1 || root.data == node2)
        {
            return root.data;
        }
        if(root.data>node1 && root.data> node2)
        {
            return lowestCommonAncestor(root.left,node1,node2);
        }
        else if(root.data<node1 && root.data < node2)
        {
            return lowestCommonAncestor(root.right,node1,node2);
        }
        else
        {
            int ans1 = lowestCommonAncestor(root.left,node1,node2);
            int ans2 = lowestCommonAncestor(root.right,node1,node2);
            if(ans1 !=-1 && ans2 !=-1)
            {
                return root.data;
            }
        if(ans1 ==-1)
        {
            return ans2;
        }
        return ans1;
        }
    }

    private static BinaryTreeNode<Integer> takeInput(BinaryTreeNode root , int data) {
        if (root == null) {
            BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(data);
            return node;
        }
        if (data < root.data) {
            root.left = takeInput(root.left, data);
        }
        else
        {
            root.right = takeInput(root.right , data);
        }
return root;
    }


}
