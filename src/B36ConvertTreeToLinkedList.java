import org.junit.Test;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class B36ConvertTreeToLinkedList {
	
	/**
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
	 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
	 */
	
	public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNode = null;
        TreeNode headOfList = convert(pRootOfTree,lastNode);
        while(headOfList!=null && headOfList.left!=null)
        	headOfList = headOfList.left;
        return headOfList;
    }
    
    private TreeNode convert(TreeNode node,TreeNode lastNode){
        if(node==null)
            return null;
        TreeNode current = node;
        if(current.left!=null)
            lastNode = convert(current.left,lastNode);
        
        current.left = lastNode;
        if(lastNode!=null)
            lastNode.right = current;
        lastNode = current;
        
        if(current.right!=null)
            lastNode = convert(current.right,lastNode);
        
        return lastNode;
    }
    
    @Test
    public void test(){
    	TreeNode head = new TreeNode(10);
    	head.left = new TreeNode(6);
    	head.left.left = new TreeNode(4);
    	head.left.right = new TreeNode(8);
    	
    	head.right = new TreeNode(14);
    	head.right.left = new TreeNode(12);
    	head.right.right = new TreeNode(16);
    	
    	TreeNode headOfList = Convert(head);
    	while(headOfList!=null){
    		System.out.println(headOfList.val);
    		headOfList = headOfList.right;
    	}
    	
    }
}
