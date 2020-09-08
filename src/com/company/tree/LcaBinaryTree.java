package tree;

import java.util.Scanner;
import java.util.Stack;

public class LcaBinaryTree {
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
        Scanner scanner = new Scanner(System.in);
        String preOrder = scanner.nextLine();
        preOrder = preOrder.replaceAll("\\s+"," ");
        String arr[] = preOrder.split(" ");
        Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(Integer.parseInt(arr[0]));
        stack.push(root);
        int i =1;
        while(i<arr.length-1)
        {
            if(arr[i].equalsIgnoreCase("true"))
            {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(Integer.parseInt(arr[i+1]));
                if(stack.peek().left==null)
                {
                    stack.peek().left = child;
                }
                else
                {
                    stack.peek().right = child;
                }

                if(stack.peek().left != null && stack.peek().right != null)
                {
                    stack.pop();
                }
                stack.push(child);
                i=i+2;
            }
         else if(arr[i] .equalsIgnoreCase("false")&& arr[i+1].equalsIgnoreCase("false"))
            {
                stack.pop();
                i=i+2;
            }
         else if(arr[i].equalsIgnoreCase("false"))
            {
                if(stack.peek().left!=null || stack.peek().right!=null)
                {
                    stack.pop();
                }
                i=i+1;
            }

        }
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        BinaryTreeNode<Integer> ans = lca(root,n1,n2);
        if(ans==null) {
            System.out.println("-1");
        }
        else
        {
            System.out.println(ans.data);
        }
}

/* Instead of returning root we can directly return root.data */
    private static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root , int node1 , int node2) {
        if(root==null)
        {
            return null;
        }
        if(root.data==node1 || root.data==node2)
        {
            return root;
        }
        BinaryTreeNode<Integer> ans1 = lca(root.left,node1,node2);
        BinaryTreeNode<Integer> ans2 = lca(root.right,node1,node2);

        if(ans1==null && ans2==null)
        {
            return null;
        }
        if(ans1 != null && ans2!=null)
        {
            return root;
        }
        if(ans1==null)
        {
            return ans2;
        }
        return ans1;

    }
    }
