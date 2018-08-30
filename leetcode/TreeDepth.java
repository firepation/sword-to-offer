package leetcode;
import org.junit.Test;

public class TreeDepth {
	/*
	 * 参数为一棵树的根节点，找出这棵树的最小深度。
	 * 最小深度为根节点到最近一个叶节点的深度。
	 */
	public int run(TreeNode root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
            return 1;
		if(root.left==null)
        	return run(root.right)+1;
		if(root.right==null) 
        	return run(root.left)+1;
		return Math.min(run(root.left)+1, run(root.right)+1);
    }
	
    @Test
    public void main(){
    	TreeNode root = new TreeNode(6);
    	root.left = new TreeNode(2);
    	//root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	System.out.println(run(root));
    }
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}

