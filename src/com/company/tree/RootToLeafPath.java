package tree;

import leetcode.BinaryTreeNode;
import leetcode.QueueUsingLL;

import java.util.Scanner;
import java.util.Stack;

public class RootToLeafPath {
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
        int sum = scanner.nextInt();
        System.out.println(checkPath(root, sum));
    }

    private static boolean checkPath(BinaryTreeNode root, int sum) {
        if(root==null)
        {
            return false;
        }
        if(root.left==null && root.right==null)
        {
            if( root.data==sum)
            {
                return true;
            }
        }
        boolean b1 = checkPath(root.left,sum-root.data);
        boolean b2 = checkPath(root.right,sum-root.data);
        return b1||b2;
    }





}
