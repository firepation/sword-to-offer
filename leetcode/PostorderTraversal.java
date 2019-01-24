import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PostorderTraversal {
	/*
	 * 题目：
	 * 通过迭代的方式对树进行后序遍历
	 */
	public ArrayList<Integer> solution(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root!=null){
        	Stack<TreeNode> nodes = new Stack<TreeNode>();
        	nodes.push(root);
        	TreeNode tempNode;
        	while(!nodes.isEmpty()){
        		tempNode = nodes.pop();
        		result.add(0,tempNode.val);
        		if(tempNode.left!=null){
        			nodes.push(tempNode.left);
        		}
        		if(tempNode.right!=null){
        			nodes.push(tempNode.right);
        		}
        	}
        }
        return result;
    }
	
	@Test
	public void test(){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		System.out.println(solution(root));
	}
	
}
