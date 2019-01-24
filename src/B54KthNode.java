public class B54KthNode {
	/*
	 * 题目：
	 * 给定一颗二叉所搜树，请找出其中的第K小的结点。
	 * 例如，(5,3,7,2,4,6,8)中，按节点数值大小
	 * 顺序第三小结点的值为4.
	 * 
	 * 二叉搜索树按照中序遍历的顺序打印出来正好就是
	 * 排序好的顺序。所以，按照中序遍历顺序找到第K个
	 * 结点就是结果。
	 * 
	 */
	int index = 0;
	public TreeNode KthNode(TreeNode pRoot,int k){
		if(pRoot!=null){
			TreeNode node = KthNode(pRoot.left,k);
			if(node!=null)
				return node;
			index++;
			if(k==index)
				return pRoot;
			node = KthNode(pRoot.right,k);
			return node;
		}
		return null;
	}
}
