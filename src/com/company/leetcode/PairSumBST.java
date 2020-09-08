package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PairSumBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        BinaryTreeNode<Integer> current = null;
        queue.enqueue(root);
        int numberOfElements = 1;
        while(!queue.isEmpty())
        {
            try
            {
                current = queue.dequeue();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            if(left!=-1)
            {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                current.left = leftChild;
                queue.enqueue(leftChild);
                numberOfElements++;
            }
            if(right != -1)
            {
                BinaryTreeNode<Integer> rightChild  = new BinaryTreeNode<>(right);
                current.right = rightChild;
                queue.enqueue(rightChild);
                numberOfElements++; // total elements in tree
            }
        }
        int sum = scanner.nextInt();
        int arr [] = new int[numberOfElements];
        List<Integer> list = new ArrayList();
        findInorder(root,arr,0);
        pairSum(arr,sum); // This method takes O(n) extra space
        pairSumLessSpace(root,sum); // This method takes only log(n) space

    }

    private static void pairSumLessSpace(BinaryTreeNode<Integer> root, int sum) {
        Stack<BinaryTreeNode<Integer>> inorderStack1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> reverseInorderStack2 = new Stack<>();
        BinaryTreeNode<Integer> temp = root;
        inorderStack1.push(temp);
        while(temp.left != null)
        {
            inorderStack1.push(temp.left);
            temp = temp.left;
        }
        temp = root;
        reverseInorderStack2.push(temp);
        while(temp.right !=null)
        {
            reverseInorderStack2.push(temp.right);
            temp = temp.right;
        }
        int top1 = inorderStack1.peek().data;
        int top2 = reverseInorderStack2.peek().data;
        while (top1 < top2)
        {
            BinaryTreeNode<Integer> poppedElement;
            if(top1+top2==sum)
            {
                System.out.println(top1 + " " +top2);
                poppedElement = inorderStack1.pop();
                if(poppedElement.right != null)
                {
                    inorderStack1.push(poppedElement.right);
                    poppedElement = poppedElement.right;
                    while(poppedElement.left != null)
                    {
                        inorderStack1.push(poppedElement.left);
                        poppedElement = poppedElement.left;
                    }
                }

                poppedElement = reverseInorderStack2.pop();
                if(poppedElement.left != null)
                {
                    reverseInorderStack2.push(poppedElement.left);
                    poppedElement = poppedElement.left;
                    while (poppedElement.right != null)
                    {
                        reverseInorderStack2.push(poppedElement.right);
                        poppedElement = poppedElement.right;
                    }
                }


            }

            else if(top1 + top2 > sum)
            {
                poppedElement = reverseInorderStack2.pop();
                if(poppedElement.left != null)
                {
                    reverseInorderStack2.push(poppedElement.left);
                    poppedElement = poppedElement.left;
                    while (poppedElement.right != null)
                    {
                        reverseInorderStack2.push(poppedElement.right);
                        poppedElement = poppedElement.right;
                    }
                }


            }
            else
            {
                poppedElement = inorderStack1.pop();

                if(poppedElement.right != null)
                {
                    inorderStack1.push(poppedElement.right);
                    poppedElement = poppedElement.right;
                    while(poppedElement.left != null)
                    {
                        inorderStack1.push(poppedElement.left);
                        poppedElement = poppedElement.left;
                    }
                }
            }
             top1 = inorderStack1.peek().data;
             top2 = reverseInorderStack2.peek().data;
        }


    }

    private static void pairSum(int[] arr, int sum) {
        int left = 0;
        int right = arr.length-1;
        while(left<right)
        {
            if(arr[left]+arr[right]==sum)
            {
                System.out.println(arr[left]+" "+arr[right]);
                left++;
                right--;
            }
            else if (arr[left] +arr[right] > sum)
            {
                right--;
            }
            else
            {
                left++;
            }
        }
    }

    private static int findInorder(BinaryTreeNode<Integer> root , int[] arr , int k ) {

        if(root==null)
        {
            return k;
        }
         k = findInorder(root.left , arr,k);
       // list.add(root.data);
        arr[k++] = root.data;
       k = findInorder(root.right,arr,k);
        return k;
    }
}
