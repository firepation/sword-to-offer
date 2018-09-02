class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val){
		this.val = val;
	}
}

public class B55TreeDepth {
	/*
	 * 题目：
	 * 输入一颗二叉树的根节点，求该数的深度。从根节点到叶节点依次
	 * 经过的节点(含根、叶节点)形成的一条路径，最长路径的长度为树的深度
	 */
	public int solution(TreeNode root){
		if(root==null)
			return 0;
		int left = solution(root.left)+1;
		int right = solution(root.right)+1;
		return left>right ? left : right;
	}
}
