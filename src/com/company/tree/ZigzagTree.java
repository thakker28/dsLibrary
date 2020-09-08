package tree;

import java.util.Scanner;
import java.util.Stack;

public class ZigzagTree {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        ZigzagTree m = new ZigzagTree();
        BinaryTree bt = m.new BinaryTree();
        bt.levelOrderZZ();
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {

            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

            // left
            boolean hlc = scn.nextBoolean();

            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            // right
            boolean hrc = scn.nextBoolean();

            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            // return
            return child;
        }

        public void levelOrderZZ() {
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2= new Stack<Node>();
            Node current = null;
            stack1.push(root);
            while(!(stack1.isEmpty() && stack2.isEmpty()))
            {
                while(!stack1.isEmpty())
                {
                    current = stack1.pop();
                    System.out.print(current.data+" ");
                    if(current.left != null)
                    {
                        stack2.push(current.left);
                    }
                    if(current.right != null)
                    {
                        stack2.push(current.right);
                    }
                }
                while (!stack2.isEmpty())
                {
                    current = stack2.pop();
                    System.out.print(current.data+ " ");
                    if(current.right != null)
                    {
                        stack1.push(current.right);
                    }
                    if(current.left != null)
                    {
                        stack1.push(current.left);
                    }
                }
            }

        }

    }
}
