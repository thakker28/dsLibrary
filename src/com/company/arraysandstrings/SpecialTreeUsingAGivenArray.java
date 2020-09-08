package arraysandstrings;

/* QUESTION

Given an integer array with no duplicates. A tree is considered special if it is defined on this array as follow:
1.The root is the maximum number in the array.
2.The left subtree is the special tree constructed from left part subarray divided by the maximum number(ie. from values in the array from 0th index to index of maximum number-1).
3.The right subtree is the special tree constructed from right part subarray divided by the maximum number.(ie. from values in the array from index of maximum number+1 to last index)
Construct the special tree by the given array and print its inorder traversal.

Input Format
The first line of the input represent an interger n -the size of the array.Next line contains n intergers,equal to element of the array.

 */

import java.util.Scanner;

public class SpecialTreeUsingAGivenArray {
    static class BinaryTreeNode<Integer>
    {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        BinaryTreeNode(int data)
        {
            this.data= data;
            left = right = null;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while (i<n)
        {
            arr[i] = scanner.nextInt();
            i++;
        }
        BinaryTreeNode<Integer> root = formTree(arr);
        printInorder(root);

    }

    private static void printInorder(BinaryTreeNode<Integer> root) {
        if(root==null)
        {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    private static BinaryTreeNode<Integer> formTree(int[] arr) {
        if(arr.length==0)
        {
            return null;
        }
        int max = arr[0];
        int index = 0;
        int i = 0;
        while(i<arr.length)
        {
            if(max<arr[i])
            {
                max = arr[i];
                index = i;
            }
            i++;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(max);
        int [] leftArr= new int[index];
        i = 0;
        while(i<leftArr.length)
        {
            leftArr[i] = arr[i];
            i++;
        }
        int[] rightArray = new int[arr.length-1-index];
        i =0;
        while (i<rightArray.length)
        {
            rightArray[i] = arr[index+1+i];
            i++;
        }
        root.left = formTree(leftArr);
        root.right = formTree(rightArray);
        return root;

    }


}
