package leetcode;

import java.util.*;

public class NodesAtDistanceK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        BinaryTreeNode<Integer> current = null;
        queue.enqueue(root);
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
            }
            if(right != -1)
            {
               BinaryTreeNode<Integer> rightChild  = new BinaryTreeNode<>(right);
                current.right = rightChild;
                queue.enqueue(rightChild);
            }
        }
        int node = scanner.nextInt();
        int k = scanner.nextInt();

        nodesAtDistance(root, node , k );
    }

    private static int nodesAtDistance(BinaryTreeNode<Integer> root, int node, int k ) {
        if(root==null)
        {
            return -1;
        }
        if(root.data == node)
        {
            printAtDepth(root,k);
            return 0;
        }
        int leftDistance = nodesAtDistance(root.left,node,k);
        if(leftDistance != -1)
        {
            if(leftDistance+1==k)
            {
                System.out.println(root.data);
            }
            else
            {
                printAtDepth(root.right,k-leftDistance-2);
            }

            return leftDistance+1;
        }
        else
        {
            int rightDistance = nodesAtDistance(root.right,node,k);
            if(rightDistance !=-1)
            {
                if(rightDistance+1==k)
                {
                    System.out.println(root.data);
                }
                else {
                    printAtDepth(root.left,k-rightDistance-2);
                }
                return rightDistance+1;
            }

        }
        return -1;

    }

    private static void printAtDepth(BinaryTreeNode<Integer> root, int k) {
        int level = 0;
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        queue.enqueue(null);
        BinaryTreeNode<Integer> current = null;
        while (!queue.isEmpty()) {
            try {
                current = queue.dequeue();
                if(queue.isEmpty())
                {
                    break;
                }

                if (current == null) {
                    level++;
                    queue.enqueue(null);
                } else {
                    if (current.left != null) {
                        queue.enqueue(current.left);
                    }
                    if (current.right != null) {
                        queue.enqueue(current.right);
                    }
                }
                if (level == k) {

                        System.out.println(queue.dequeue().data);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

//        if(root==null)
//            return;
//
//        if(k<0)
//            return;
//
//        if(k==0)
//        {
//            System.out.println(root.data);
//            return;
//        }
//
//        printAtDepth(root.left,k-1);
//        printAtDepth(root.right,k-1);
        }
    }

