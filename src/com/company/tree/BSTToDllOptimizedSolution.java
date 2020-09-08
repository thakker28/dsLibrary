package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node
{
    int data;
    Node right;
    Node left;

    Node()
    {

    }

    Node(int data)
    {
        this.data = data;
        left = right = null;
    }

    Node(int data, Node left, Node right)
    {
        this.data = data;
        this.right = right;
        this.left = left;
    }
}

class BSTToDllOptimizedSolution {
    static Node first = null;
    static Node last = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String arr[] = s.trim().split("\\s+");
        List<Integer> list = new ArrayList<Integer>();
        for(String str : arr)
        {
            list.add(Integer.parseInt(str));
        }
        Node root = createTree(list);
        treeToDoublyLinkedList(root);
        int i = 0;
        while(i<list.size())
        {
            System.out.print(first.data+" ");
            first = first.right;
            i++;
        }
    }

    private static Node treeToDoublyLinkedList(Node root) {
        if(root == null)
        {
            return null;
        }
        helper(root);
        first.left=last;
        last.right=first;
        return first;
    }

    private static void helper(Node node) {
        if(node==null)
        {
            return ;
        }
        helper(node.left);
        if(last != null)
        {
            last.right = node;
            node.left = last;
        }
        else
        {
            first = node;
        }
        last = node;
        helper(node.right);
    }

    private static Node createTree(List<Integer> list) {
        Node root = null;
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

    private static Node insert(Node root, int data) {
        if(root == null)
        {
            Node node = new Node(data);
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
