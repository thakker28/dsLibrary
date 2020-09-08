package arraysandstrings;


import java.util.*;

/* Question :

We are given a binary tree having N+1 nodes ,N edges and an integer X. The task is to find the count of the total number of subtrees having total node’s data sum equal to a value X.

Note : Tree can be build using Level Order Traversal, using the iteration over the given string.
Tree is Complete Binary Tree.

Input Format
First line of input contains the number of test cases T. For each T, there will be only a single line of input in the form of string representing the tree.
 */

public class TotalSubTreeWithGivenSum {
    static class BinaryTreeNode<Integer>
    {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        BinaryTreeNode(int data)
        {
            this.data = data;
            right = left =null;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList();
        while(n>0)
        {
            scanner.nextLine();
            String s = scanner.nextLine();
            int sum = scanner.nextInt();
            BinaryTreeNode<Integer> root = formTree(s);
           list.add(countSubTress(root,sum));
            n--;
        }
        for(int i : list)
        {
            System.out.println(i);
        }
    }

    private static int countSubTress(BinaryTreeNode<Integer> root , int sum) {
        if(root==null)
        {
            return 0;
        }
        int ans  = 0;
        if(Sum(root)==sum)
        {
            ans++;
        }
        int leftSubTrees  = countSubTress(root.left,sum);
        int rightSubTrees = countSubTress(root.right,sum);
        return ans + leftSubTrees+rightSubTrees;


    }

    private static int Sum(BinaryTreeNode<Integer> root) {
        if(root==null)
        {
            return 0;
        }
        int leftSum = Sum(root.left);
        int rightSum = Sum(root.right);
        return root.data+leftSum+rightSum;
    }

    private static BinaryTreeNode<Integer> formTree(String s) {
        s = s.replaceAll("\\s+"," ");
        String arr[] = s.split(" ");
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(Integer.parseInt(arr[0]));
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
        BinaryTreeNode<Integer> current  = null;
        queue.add(root);
        int i =1;
        while (i<arr.length)
        {
            current = queue.remove();
            BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(Integer.parseInt(arr[i++]));
            current.left = leftChild;
            queue.add(leftChild);
            BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(Integer.parseInt(arr[i++]));
            current.right = rightChild;
            queue.add(rightChild);
        }
        return root;
    }

}
