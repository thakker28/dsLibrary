package leetcode;

import java.util.Scanner;

public class FormTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pre[] = new int[n];
        int post[] = new int[n];
        int in[] = new int[n];
        int i = 0;
        while(i<n)
        {
            pre[i] =scanner.nextInt();
            i++;
        }
        i = 0;
        while(i<n)
        {
            in[i] =scanner.nextInt();
            i++;
        }
        i = 0;
        while(i<n)
        {
            post[i] =scanner.nextInt();
            i++;
        }
        BinaryTreeNode<Integer> root = getTreeFromPreorderAndInorder(pre,in);
        BinaryTreeNode<Integer> root1 = getTreeFromPreorderAndPostorder(pre, post , 0 ,pre.length-1 , 0 , post.length-1);
        BinaryTreeNode<Integer> root2 = getTreeFromInorderAndPostorder(in ,post ,0 , in.length-1 , 0 ,post.length-1);
        printLevelOrderTraversal(root);
        System.out.println(" ");
        printLevelOrderTraversal(root1);
        System.out.println("");
        printLevelOrderTraversal(root2);

    }

    private static BinaryTreeNode<Integer> getTreeFromInorderAndPostorder(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart> inEnd)
        {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(post[postEnd]);
        int i = inStart;
        while(i<=inEnd)
        {
            if(in[i]==post[postEnd])
            {
                break;
            }
            i++;
        }
        int inLeftStart = inStart;
        int inLeftEnd = i-1;
        int inRightStart = i+1;
        int inRightEnd = inEnd;

        int postLeftStart = postStart;
        int leftLength = inLeftEnd - inLeftStart + 1;
        int postLeftEnd = postLeftStart + leftLength - 1;
        int postRightStart = postLeftEnd + 1;
        int postRightEnd = postEnd -1 ;

        root.left = getTreeFromInorderAndPostorder(in,post,inLeftStart,inLeftEnd,postLeftStart,postLeftEnd);
        root.right = getTreeFromInorderAndPostorder(in,post,inRightStart , inRightEnd , postRightStart , postRightEnd);
        return root;
    }

    private static BinaryTreeNode<Integer> getTreeFromPreorderAndPostorder(int[] pre, int[] post ,int preStart, int preEnd ,
                                                                           int postStart , int postEnd)
    {
        if(preStart>preEnd)
        {
            return null;
        }
      BinaryTreeNode<Integer> root = new BinaryTreeNode<>(pre[preStart]);
        int i = preStart;
        while(i<=preEnd)
        {
            if(pre[i]==post[postStart])
            {
                break;
            }
            i++;
        }
        int preLeftStart = preStart+1;
        int preLeftEnd = i;
        int preRightStart = i+1;
        int preRightEnd = preEnd;

        int postLeftStart = postStart;
        int leftLength = preLeftEnd - preLeftStart +1;
        int postLeftEnd = postLeftStart + leftLength -1;
        int postRightStart = postLeftEnd+1;
        int postRightEnd = postEnd -1;

        root.left = getTreeFromPreorderAndPostorder(pre , post , preLeftStart ,preLeftEnd , postLeftStart ,postLeftEnd);
        root.right = getTreeFromPreorderAndPostorder(pre , post , preRightStart , preRightEnd , postRightStart ,postRightEnd);
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

    public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre,
                                                                        int[] in){

        // Write your code here
        return getTreeHelper(pre , in , 0 , pre.length-1 , 0 ,in.length-1);
    }

    private static BinaryTreeNode<Integer> getTreeHelper(int pre[] , int in[] , int preStart , int preEnd , int inStart , int inEnd)
    {
        if(inStart>inEnd)
        {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(pre[preStart]);
        int i = inStart;
        while(i <= inEnd){
            if(in[i] == pre[preStart]){
                break;
            }
            i++;
        }
        int inLeftEnd = i-1;
        int inLeftStart = inStart;
        int inRightStart = i+1;
        int inRightEnd = inEnd;

        int preLeftStart = preStart+1;
        int leftLength = inLeftEnd - inLeftStart +1;
        int preLeftEnd = preLeftStart + leftLength -1;
        int preRightStart = preLeftEnd+1;;
        int preRightEnd = preEnd;

        root.left = getTreeHelper(pre,in,preLeftStart,preLeftEnd,inLeftStart,inLeftEnd);
        root.right = getTreeHelper(pre,in,preRightStart,preRightEnd,inRightStart,inRightEnd);
        return root;

    }
}
