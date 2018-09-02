public class B55IsBalanced {
	/*
	 * 题目：
	 * 输入一颗二叉树的根节点，判断该树是不是平衡二叉树。如果
	 * 某二叉树中任意的左、右子树的深度相差不超过1，那么它就是一颗
	 * 平衡二叉树。
	 */
	public boolean solution(TreeNode root){
		return calDepth(root)!=-1;
	}
	
	 private int calDepth(TreeNode root){
		if(root==null)
			return 0;
		int left = calDepth(root.left);
		if(left==-1)
			return -1;
		int right = calDepth(root.right);
		if(right==-1)
			return -1;
		return Math.abs(left-right)>1 ? -1 : 1+Math.max(left,right);
	}
}
