package tree;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ModifyWithSumOfGreaterNodes {
    static  Scanner scanner = new Scanner(System.in);
    static class BinarySearchTree
    {
        int data;
        BinarySearchTree left;
        BinarySearchTree right;
        BinarySearchTree(int data)
        {
            this.data = data;
            left=right=null;
        }

    }

    public static void main(String[] args) {
        String s = scanner.nextLine();
        //s=s.replaceAll("[^a-zA-Z0-9]+"," ");
        String arr[] = s.trim().split("\\s+");
        BinarySearchTree root = null;
        int pre[] = new int[arr.length];
        int i =0;
        for(String str : arr)
        {
            pre[i++] = Integer.parseInt(str);
        }
        for(i=0;i<pre.length;i++)
        {
            root = createTree(root,pre[i]);
        }

        modifyNodesData(root,0);
        preorder(root);
}

    private static BinarySearchTree createTree(BinarySearchTree root , int data) {
        if(root==null)
        {
            BinarySearchTree node = new BinarySearchTree(data);
            return node;
        }
        if(data != -1)
        {
            if(data<root.data)
            {
                root.left = createTree(root.left,data);
            }
            else
            {
                root.right = createTree(root.right,data);
            }
        }

        return root;
    }

    private static void preorder(BinarySearchTree root) {
        if(root==null)
        {
            return ;
        }
        String s = "";
        if(root.left !=null)
        {
            s=s+root.left.data+"<--";
        }
        else
        {
            s=s+".<--";
        }

        s= s+(root.data+"-->");
        if(root.right != null)
        {
            s=s+root.right.data;
        }
        else
        {
            s=s+".";
        }
        System.out.println(s);
        preorder(root.left);
        preorder(root.right);
    }

    private static int modifyNodesData(BinarySearchTree root, int sum) {
        if(root == null)
        {
            return sum;
        }
        sum = modifyNodesData(root.right,sum);
        sum = sum +root.data;
        root.data = sum;
        sum = modifyNodesData(root.left,sum);
        return sum;
    }

    private static BinarySearchTree formTree(int[] pre) {
        BinarySearchTree root = new BinarySearchTree(pre[0]);
        Stack<BinarySearchTree> stack = new Stack<BinarySearchTree>();
        stack.push(root);
        int i =1;
        while(i<pre.length)
        {
            if(pre[i] !=-1)
            {
                BinarySearchTree peek = stack.peek();
                BinarySearchTree node = new BinarySearchTree(pre[i]);
                if(peek.left == null && node.data<peek.data)
                {
                    peek.left = node;
                }
                else if(peek.right == null && node.data>peek.data)
                {
                    peek.right = node;
                }
                if(peek.right != null && peek.left != null)
                {
                    stack.pop();
                }
                if(!(pre[i+1] == -1 && pre[i+2] == -1))
                {
                    stack.push(node);
                }
            }
            i++;
        }
        return root;
    }
    }
