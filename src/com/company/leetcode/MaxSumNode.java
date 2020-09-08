package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class MaxSumNode {
    static class  TreeNode<T>
    {
        int data;
        ArrayList<TreeNode> children;
        TreeNode(int data)
        {
            this.data = data;
            children = new ArrayList<TreeNode>();
        }
    }

    static class FirstAnsSecondLargestPair
    {
        TreeNode<Integer> first;
        TreeNode<Integer> second;
        FirstAnsSecondLargestPair(	TreeNode<Integer> first , TreeNode<Integer> second)
        {
            this.first = first;
            this.second = second;
        }
    }


    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

        // Write your code here
        return secondLargestHelper(root).second;
    }
    private static FirstAnsSecondLargestPair secondLargestHelper(TreeNode<Integer> root)
    {
        if(root==null)
        {
            FirstAnsSecondLargestPair ans = new FirstAnsSecondLargestPair(null,null);
            return ans;
        }
        FirstAnsSecondLargestPair ans = new FirstAnsSecondLargestPair(root,null);
        for(TreeNode child : root.children)
        {
            FirstAnsSecondLargestPair node = secondLargestHelper(child);
            if(ans==null)
            {
                ans = node;
            }
            if(node==null)
            {
                return ans;
            }
            if(ans.first.data>node.first.data)
            {
                if(ans.second==null)
                {
                    ans.second = node.first;
                }
                else
                {
                    ans.second = ans.second.data>node.first.data ? ans.second : node.first;
                }
            }
            else if(ans.first.data<node.first.data)
            {
                if(node.second==null)
                {
                    ans.second = ans.first;
                }
                else
                {
                    ans.second = ans.first.data>node.second.data ? ans.first : node.second;
                }
            }
            else
            {
                ans.second = node.first;
            }
        }
        return ans;
    }

}

