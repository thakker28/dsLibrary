package tree;

import java.util.*;

public class Merge2Trees {
    static class BinaryTree
    {
        int data;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int n= scanner.nextInt();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int i =0;
        while(i<n)
        {
            String tree1 = scanner.next();
            String tree2 = scanner.next();
            ans.add(merge(tree1,tree2));
            i++;
        }
        for(List<Integer> list : ans)
        {
            for(int a : list)
            {
                System.out.print(a+" ");
            }
            System.out.println(" ");
        }
    }

    private static List<Integer> merge(String tree1, String tree2) {
        BinaryTree root1 = formTree(tree1);
        BinaryTree root2 = formTree(tree2);
        List<Integer> in1 = findInorder(root1,new ArrayList<Integer>());
        List<Integer> in2 = findInorder(root2,new ArrayList<Integer>());
        int i = 0;
        int j=0;
        List<Integer> ans = new ArrayList<Integer>();
        while(i<in1.size() && j<in2.size())
        {
            if(in1.get(i) <= in2.get(j))
            {
                ans.add(in1.get(i));
                i++;
            }
            else
            {
                ans.add(in2.get(j));
                j++;
            }
        }
        if(i==in1.size())
        {
            while(j<in2.size())
            {
                ans.add(in2.get(j));
                j++;
            }
        }
        if(j==in2.size())
        {
            while (i<in1.size())
            {
                ans.add(in1.get(i));
                i++;
            }
        }
        return ans;
    }

    private static List<Integer> findInorder(BinaryTree root,List<Integer> list) {
        if(root == null)
        {
            return list;
        }
        list = findInorder(root.left,list);
        list.add(root.data);
        list = findInorder(root.right,list);
        return list;

    }

    private static BinaryTree formTree(String tree1) {
        String arr[] = tree1.trim().split("\\s+");
        BinaryTree root = new BinaryTree(Integer.parseInt(arr[0]));
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        BinaryTree current = null;
        queue.add(root);
        int i = 1;
        while(i<arr.length)
        {
            try
            {
                current = queue.remove();
            }
            catch (Exception e)
            {

            }
            String left = arr[i];
            if(!left.equals("N"))
            {
                BinaryTree leftchild = new BinaryTree(Integer.parseInt(left));
                current.left = leftchild;
                queue.add(leftchild);
            }
            if(i==arr.length-1)
            {
                break;
            }
            String right = arr[i+1];
            if(!right.equals("N"))
            {
                BinaryTree rightChild = new BinaryTree(Integer.parseInt(right));
                current.right = rightChild;
                queue.add(rightChild);
            }
            i=i+2;
        }
        return root;
    }
}
