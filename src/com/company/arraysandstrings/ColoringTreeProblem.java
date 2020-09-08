package arraysandstrings;
import leetcode.QueueUsingLL;

import java.util.Scanner;
import java.util.Stack;


/* QUESTION :

A Binary tree is given . There are 2 players Rajesh Koothrapalli and Howard Wolowitz . We are given the root of this binary tree, and the number of nodes n in the tree. n is odd, and each node has a distinct value from 1 to n.

Initially, Rajesh(first) colors a value x with 1 <= x <= n, and Howard colors a value y with 1 <= y <= n and y != x. Rajesh colors the node with value x red, and Howard colors the node with value y blue.

Then, the players take turns starting with Rajesh who is the first player . In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)

If (and only if) a player cannot choose such a node in this way, they must pass their turn. If both players pass their turn, the game ends, and the winner is the player that colored more nodes.

Howard and Rajesh are best friends . So they are playing this game strategically .

You are Howard. If it is possible to choose such a y to ensure you win the game, print 1. If it is not possible, print 0.

Input Format
First line contains 3 integers ( Total Nodes including leaves which are depicted as -1s , Actual Nodes which are depicted by Natural numbers 1 to Inf , X is the node with natural number X which is marked by the First Person ) Second line Contains T_Nodes space separated integers (-1 is a leaf) in preorder fashion for the tree to be constructed .

Note : You have to construct the tree from the preorder sequence given.


 */

public class ColoringTreeProblem {
    static Scanner scanner = new Scanner(System.in);
    static class BinaryTreeNode<Integer>
    {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        BinaryTreeNode(int data)
        {
            this.data = data;
            left = right =null;
        }

    }
    public static void main(String[] args) {
        int preOrderLength = scanner.nextInt();
        int pre[] = new int[preOrderLength];
        int nodes = scanner.nextInt();
        int selectedNode = scanner.nextInt();
//        for(int i=0;i<preOrderLength;i++)
//        {
//            pre[i] = scanner.nextInt();
//        }
        BinaryTreeNode<Integer> root = createTree();
        printLevelOrderTraversal(root);
        BinaryTreeNode<Integer> root1 = findNode(root,selectedNode);
        System.out.println(winGame(root1,nodes));
    }

    private static BinaryTreeNode<Integer> createTree() {
        int data = scanner.nextInt();
        if(data == -1)
        {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        root.left = createTree();
        root.right = createTree();
        return root;
    }

    private static void printLevelOrderTraversal(BinaryTreeNode<Integer> root) {
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        queue.enqueue(null);
        BinaryTreeNode<Integer> current = null;
        while(!queue.isEmpty())
        {
            current = queue.dequeue();
            if(queue.isEmpty())
            {
                break;
            }

            if(current==null)
            {
                System.out.println(" ");
                queue.enqueue(null);
            }
            else
            {
                System.out.print(current.data+" ");
                if(current.left!=null)
                {
                    queue.enqueue(current.left);
                }
                if(current.right!=null)
                {
                    queue.enqueue(current.right);
                }
            }

        }
    }

    private static int winGame(BinaryTreeNode<Integer> root1 , int totalNodes) {
       int leftSubTreeNodes =  countNodes(root1.left);
       int rightSubTreeNodes = countNodes(root1.right);
       int remaining = totalNodes - (leftSubTreeNodes+rightSubTreeNodes)-1;
       if(leftSubTreeNodes>rightSubTreeNodes+remaining)
       {
           return 1;
       }
        if(rightSubTreeNodes>leftSubTreeNodes+remaining)
        {
            return 1;
        }

        if(remaining>rightSubTreeNodes+leftSubTreeNodes)
        {
            return 1;
        }
return 0;

    }

    private static int countNodes(BinaryTreeNode<Integer> root) {
        if(root==null)
        {
            return 0;
        }
        int leftSubTreeNodes = countNodes(root.left);
        int rightSubTreeNodes = countNodes(root.right);
        return leftSubTreeNodes+rightSubTreeNodes+1;
    }

    private static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int selectedNode) {
        if(root==null)
        {
            return null;
        }
        if(root.data==selectedNode)
        {
            return root;
        }
        BinaryTreeNode<Integer> left = findNode(root.left,selectedNode);
        BinaryTreeNode<Integer> right = findNode(root.right,selectedNode);
        return left==null ? right : left;

    }

    private static BinaryTreeNode<Integer> formTree(int[] pre) {
        int n = pre.length;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(pre[0]);
        Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
        stack.push(root);
        int i = 1;
        while(i<n)
        {
            BinaryTreeNode<Integer> temp = null;
            if(pre[i]!=-1)
            {
                temp = new BinaryTreeNode<Integer>(pre[i]);
                BinaryTreeNode<Integer> peek = stack.peek();
                if (peek.left == null) {
                    peek.left = temp;
                } else if (peek.right == null) {
                    peek.right = temp;
                    stack.pop();
                }
                if(!(pre[i+1]==-1 && pre[i+2]==-1))
                {
                    stack.push(temp);
                }

            }
            i++;
        }
        return root;
    }
}
