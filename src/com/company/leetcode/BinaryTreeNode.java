package leetcode;

public class BinaryTreeNode<Integer> {
    int data;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;
    BinaryTreeNode(int data)
    {
        this.data =data;
        right = left =null;
    }
}
