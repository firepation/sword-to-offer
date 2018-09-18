/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class B28SymmetricalBinaryTree {
	/*
	 * 题目：
	 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
	 * 按照我的理解，是否对称的定义是这样的：一棵树的左节点
	 * 的左节点会和右节点的右节点值一样，左节点的右节点会和
	 * 右节点的左节点值一样。
	 */
	
	public boolean isSymmetrical(TreeNode pRoot){
		if(pRoot==null)
			return false;
		return isSymmetrical(pRoot.left,pRoot.right); 
    }
	private boolean isSymmetrical(TreeNode left,TreeNode right){
		if(left==null)return right==null;
		if(right==null) return false;
		if(left.val!=right.val)return false;
		return isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
	}
}
