/**
 * 题目：
 * 请完成一个函数，输入一颗二叉树，该函数输出它的镜像。
 *        
 *        源二叉树 
 *   	    8
 *   	   /  \
 *   	  6   10
 *   	 / \  / \
 *   	5  7 9 11
 *   	
 *       镜像二叉树
 *   	    8
 *   	   /  \
 *   	  10   6
 *   	 / \  / \
 *   	11 9 7  5
 * @author firefox
 *
 */

class TreeNode{
	TreeNode right;
	TreeNode left;
	int val;
}

public class B27MirrorTree {
	public void Mirror(TreeNode root) {
		if(root==null)
            return;
        
        if(root.left!=null)
        	Mirror(root.left);
        if(root.right!=null)
        	Mirror(root.right);
        
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = tempRight;
    }
}
