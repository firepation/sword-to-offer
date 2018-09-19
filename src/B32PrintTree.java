package chacpter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class B32PrintTree {
	/*
	 * 题目：不分行从上到下打印二叉树
	 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺
	 * 序打印。 
	 */
	 ArrayList<ArrayList<Integer>> printByLever(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return result;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int remain = 1;
        int nextLeverRemain = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.removeFirst();
            remain--;
            temp.add(cur.val);
            if(cur.left!=null){
                queue.add(cur.left);
                nextLeverRemain++;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                nextLeverRemain++;
            }
            if(remain==0){
                remain=nextLeverRemain;
                nextLeverRemain=0;
                result.add(new ArrayList<Integer>(temp));
                temp.clear();
            }
        }
        return result;
    }
	 /*
	  * 题目：
	  * 之字形打印二叉树，即刚开始从左到右打印二叉树，接着
	  * 从右到左打印二叉树以此类推。
	  */
	 public ArrayList<ArrayList<Integer> > printByZhiTag(TreeNode pRoot) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 if(pRoot==null)
			 return result;
		 ArrayList<Integer> list = new ArrayList<>();
		 LinkedList<TreeNode> queue = new LinkedList<>();
		 boolean leftToRight = true;
		 queue.addLast(null);
		 queue.addLast(pRoot);
		 while(queue.size()!=1){
			 TreeNode node = queue.removeFirst();
			 if(node==null){
				 Iterator<TreeNode> iter = null;
				 if(leftToRight)
					 iter = queue.iterator();
				 else
					 iter = queue.descendingIterator();
				 leftToRight = !leftToRight;
				 while(iter.hasNext()){
					 list.add(iter.next().val);
				 }
				 result.add(new ArrayList<Integer>(list));
				 list.clear();
				 queue.addLast(null);
				 continue;
			 }
			 if(node.left!=null){
				 queue.addLast(node.left);
			 }
			 if(node.right!=null){
				 queue.addLast(node.right);
			 }
		 }
		 return result;
	 }
	 
	 class TreeNode{
		int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
}
