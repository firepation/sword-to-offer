public class B08FindNextNode {
	/*
	 * 题目：
	 * 给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的
	 * 下一个节点？树中的节点除了有两个分别指向左、右子节点的指针，
	 * 还有一个指向父节点的指针。
	 * */
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode == null)
			return null;
		TreeLinkNode cur = pNode;
		if(cur.right!=null){
			cur = cur.right;
			while(cur.left!=null)
				cur = cur.left;
			return cur;
		}
		while(cur.next!=null){
			TreeLinkNode parent = cur.next;
			if(parent.left==cur)
				return parent;
			cur = parent;
		}
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;    // 这个变量表示父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}
