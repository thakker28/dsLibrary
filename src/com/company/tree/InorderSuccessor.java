package tree;

import java.util.Scanner;

public class InorderSuccessor {
    static Scanner scanner = new Scanner(System.in);
    static boolean check = false;
    static class BinarySearchTree<Integer>
    {
        int data;
        BinarySearchTree<Integer> left;
        BinarySearchTree<Integer> right;
        BinarySearchTree(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> root = null;
        int n = scanner.nextInt();
        int i = 0;
        while(i<n)
        {
            int rootData = scanner.nextInt();
            root = insert(root,rootData);
            i++;
        }

        int p = scanner.nextInt();
//       BinarySearchTree ans = inorderSuccessor(root,p);
//       if(ans== null)
//       {
//           System.out.println("");
//       }
//       else
//       {
//           System.out.println(ans.data);
//       }
        inorderSuccessor(root,p);
        int arr[] = new int[count(root)];
        treeToArray(root,arr,0);
    }

    private static int treeToArray(BinarySearchTree<Integer> root, int[] arr, int i) {
        if(root == null)
        {
            return i;
        }
        arr[i] = root.data;
        i = treeToArray(root.left,arr,i+1);
        i = treeToArray(root.right,arr,i);
        return i;
    }

    private static int count(BinarySearchTree<Integer> root) {
        if(root == null)
        {
            return 0;
        }
        return count(root.left)+count(root.right)+1;
    }

    private static void inorderSuccessor(BinarySearchTree<Integer> root, int p) {
        if(root==null)
        {
            return ;
        }
//        BinarySearchTree<Integer> left = inorderSuccessor(root.left,p);
//        if(left != null)
//        {
//            return left;
//        }
//        if(check==true)
//        {
//            check = false;
//            return root;
//        }
//        if(p==root.data)
//        {
//            check = true;
//        }
//        BinarySearchTree<Integer> right = inorderSuccessor(root.right,p);
//        if(right != null)
//        {
//            return  right;
//        }
//        return null;
        inorderSuccessor(root.left,p);
        if(p==root.data || check==true)
        {
            if(check==true)
            {
                System.out.println(root.data);
                check = false;
            }
            else
            {
                check = true;
            }

        }
        inorderSuccessor(root.right,p);
    }

    private static BinarySearchTree<Integer> insert(BinarySearchTree<Integer> root , int data) {
        if(root == null)
        {
            BinarySearchTree<Integer> node = new BinarySearchTree<Integer>(data);
            return node;
        }
        if(data<root.data)
        {
            root.left = insert(root.left , data);
        }
        else
        {
            root.right = insert(root.right,data);
        }
        return root;
    }

}
