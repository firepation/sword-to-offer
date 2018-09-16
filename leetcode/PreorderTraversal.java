package leetcode;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class PreorderTraversal {
	/*
	 * 题目：
	 * 使用前序遍历的方式对树进行遍历
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if(root!=null){
			stack.push(root);
			TreeNode curNode = null;
			while(!stack.isEmpty()){
				curNode = stack.pop();
				result.add(curNode.val);
				if(curNode.right!=null)
					stack.push(curNode.right);
				if(curNode.left!=null)
					stack.push(curNode.left);
			}
		}
		return result;
    }
	
	@Test
	public void test(){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(7);
		System.out.println(preorderTraversal(root));
	}
}
