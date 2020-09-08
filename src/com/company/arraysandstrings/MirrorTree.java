package arraysandstrings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirrorTree {
    static class BinaryTreeNode<Integer>
    {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        BinaryTreeNode(int data)
        {
            this.data = data;
            right=left=null;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rootData = scanner.nextInt();
        BinaryTreeNode<Integer> root = null;
        if(rootData!=-1)
        {
          root = new BinaryTreeNode<>(rootData);
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
        queue.add(root);
        BinaryTreeNode<Integer> current = null;
        while(!queue.isEmpty() && queue.peek()!=null)
        {
            try
            {
                current = queue.remove();
            }
            catch (Exception e)
            {
                System.out.print(e);
            }
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if(left != -1)
            {
                BinaryTreeNode<Integer> leftchild = new BinaryTreeNode<>(left);
                current.left = leftchild;
                queue.add(leftchild);
            }
            if(right != -1)
            {
                BinaryTreeNode<Integer> rightchild = new BinaryTreeNode<>(right);
                current.right = rightchild;
                queue.add(rightchild);

            }
        }
        if(root==null)
        {
            System.out.println("YES");
        }
       else if(checkMirror(root.left , root.right))
        {
           System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }

    private static boolean checkMirror(BinaryTreeNode<Integer> leftSubtreeRoot , BinaryTreeNode<Integer> rightSubTreeRoot) {
        if(leftSubtreeRoot==null || rightSubTreeRoot==null)
        {
            return leftSubtreeRoot==rightSubTreeRoot;
        }
        if(leftSubtreeRoot.data != rightSubTreeRoot.data)
        {
            return false;
        }
       boolean b1 = checkMirror(leftSubtreeRoot.left,rightSubTreeRoot.right);
       boolean b2 = checkMirror(leftSubtreeRoot.right,rightSubTreeRoot.left);
       return b1 && b2;
    }
}
