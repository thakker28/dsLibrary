package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BstToDll {
    static class BinarySearchTree {
        int data;
        BinarySearchTree left;
        BinarySearchTree right;

        BinarySearchTree(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static class DoublyLinkedList
    {
        int data;
        DoublyLinkedList prev;
        DoublyLinkedList next;
        DoublyLinkedList(int data)
        {
            this.data = data;
            prev = next = null;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String arr[] = s.trim().split("\\s+");
        List<Integer> list = new ArrayList<Integer>();
        for(String str : arr)
        {
            list.add(Integer.parseInt(str));
        }
        BinarySearchTree root = createTree(list);
        List<Integer> inorderList = new ArrayList<>();
        inorder(root,inorderList);
        DoublyLinkedList head = createDoublyLinkedList(inorderList);
        int i = 0;
        while(i<inorderList.size())
        {
            System.out.print(head.data+" ");
            head = head.next;
            i++;
        }

    }


    private static DoublyLinkedList createDoublyLinkedList(List<Integer> inorderList) {
        if(inorderList.size()==0)
        {
            return null;
        }
        DoublyLinkedList head = new DoublyLinkedList(inorderList.get(0));
        DoublyLinkedList current = head;
        DoublyLinkedList last = null;
        DoublyLinkedList prev = null;
        DoublyLinkedList next = null;
        int lastIndex = inorderList.size()-1;
        for(int i= 1; i<inorderList.size();i++)
        {
           // DoublyLinkedList node = new DoublyLinkedList(inorderList.get(i));
            if(i==1)
            {
                prev = new DoublyLinkedList(inorderList.get(lastIndex));
                next = new DoublyLinkedList(inorderList.get(i));
                head.prev = prev;
                head.next = next;
                last = prev;
                prev = head;
                current = next;

            }

//            else if(i==lastIndex-1)
//            {
//                current.next = last;
//                current.prev = prev;
//                prev = current;
//                current = last;
//            }

            else if(i==lastIndex)
            {
                current.next = last;
                current.prev = prev;
                prev = current;
                current = last;
            }

            else {
                current.prev = prev;
                next = new DoublyLinkedList(inorderList.get(i));
                current.next = next;
                prev = current;
                current = next;
            }


        }
        current.next=head;
        current.prev=prev;
        return head;
    }

    private static void inorder(BinarySearchTree root, List<Integer> inorderList) {
        if(root==null)
        {
            return;
        }
        inorder(root.left,inorderList);
        inorderList.add(root.data);
        inorder(root.right,inorderList);
    }

    private static BinarySearchTree createTree(List<Integer> list) {
        BinarySearchTree root = null;
        if(list.size()==0)
        {
            return root;
        }
        for(int i =0;i<list.size();i++)
        {
            root = insert(root,list.get(i));
        }
        return root;
    }

    private static BinarySearchTree insert(BinarySearchTree root, Integer data) {
        if(root == null)
        {
            BinarySearchTree node = new BinarySearchTree(data);
            return node;
        }
        if(data<root.data)
        {
            root.left = insert(root.left,data);
        }
        else
        {
            root.right = insert(root.right,data);
        }
        return root;
    }

}
