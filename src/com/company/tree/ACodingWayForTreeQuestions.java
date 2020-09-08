package tree;
import java.util.*;
public class ACodingWayForTreeQuestions {


        static Scanner scn = new Scanner(System.in);

        public static void main(String[] args) {
            ACodingWayForTreeQuestions m = new ACodingWayForTreeQuestions();
            int[] pre = takeInput();
            int[] in = takeInput();
            BinaryTree bt = m.new BinaryTree(pre, in);
            bt.display();
        }

        public static int[] takeInput() {
            int n = scn.nextInt();

            int[] rv = new int[n];
            for (int i = 0; i < rv.length; i++) {
                rv[i] = scn.nextInt();
            }

            return rv;
        }

        private class BinaryTree {
            private class Node {
                int data;
                Node left;
                Node right;
            }

            private Node root;
            private int size;

            public BinaryTree(int[] pre, int[] in) {
                this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
            }

            private Node construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
                if(inStart>inEnd)
                {
                    return null;
                }
                Node root = new Node();
                root.data = pre[preStart];
                root.left = root.right = null;
                int i = inStart;
                while(i<=inEnd)
                {
                    if(in[i]==pre[preStart])
                    {
                        break;
                    }
                    i++;
                }

                int inLeftStart = inStart;
                int inLeftEnd = i-1;
                int inRightStart = i+1;
                int inRightEnd = inEnd;

                int preLeftStart = preStart+1;
                int leftLength = inLeftEnd-inLeftStart+1;
                int preLeftEnd = preLeftStart+leftLength-1;
                int preRightStart = preLeftEnd +1;
                int preRightEnd = preEnd;

                root.left = construct(pre,preLeftStart,preLeftEnd,in,inLeftStart,inLeftEnd);
                root.right = construct(pre,preRightStart,preRightEnd,in,inRightStart,inRightEnd);
                return root;

            }

            public void display() {
                this.display(this.root);
            }

            private void display(Node node) {
                if (node == null) {
                    return;
                }

                String str = "";

                if (node.left != null) {
                    str += node.left.data;
                } else {
                    str += "END";
                }

                str += " => " + node.data + " <= ";

                if (node.right != null) {
                    str += node.right.data;
                } else {
                    str += "END";
                }

                System.out.println(str);

                this.display(node.left);
                this.display(node.right);
            }

        }

    }


