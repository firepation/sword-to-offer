
/*
 *    题目：给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的
 * 下一个节点？树中的节点除了有两个分别指向左、右子节点的指针，还有
 * 一个指向父节点的指针。
 * */
public class B08FindNextNode {
	
	private Node head;
	
	/*
	 *  根据给定的值查找该节点在中序遍历的下一个节点
	 *  主要提供给外部类使用
	*/ 
	
	public void findNextValue(int value){
		Node node = findNextNode(value); 
		if(node!=null)
		{
			System.out.println("下一个节点为："+node.value);
			return;
		}
		System.out.println("树中不存在该节点");
	}
	
	/* 
	 * 根据给定的值找出该节点在中序遍历中的下一个节点
	 * 是上面 findNextValue 的辅助函数
	 */
	private Node findNextNode(int value){
		Node targetNode = findNode(value);
		if(targetNode == null){
			return null;
		}
		if(targetNode.right!=null){
			targetNode = targetNode.right;
			while(targetNode.left!=null){
				targetNode = targetNode.left;
			}
		}else if(targetNode.parent!=null){
			Node parentNode = targetNode.parent;
			while(parentNode!=null && parentNode.right==targetNode){
				targetNode = parentNode;
				parentNode = parentNode.parent;
			}
			targetNode = parentNode;
		}
		return targetNode;
	}
	
	// 根据指定的值找出对应的节点
	private Node findNode(int value){
		Node currentNode = head;
		while(currentNode!=null){
			if(currentNode.value>value){
				currentNode = currentNode.left;
			}else if(currentNode.value<value){
				currentNode = currentNode.right;
			}else if(currentNode.value==value){
				return currentNode;
			}
		}
		return null;
	}
	
	@Test
	// 测试用例为没有任何元素的二叉树
	public void testFindNext1(){
		B08FindNextNode tree = new B08FindNextNode();
		tree.findNextValue(15);
	}
	
	@Test
	/*
	 * 测试用例为普通的二叉树
	 *              10
	 *           /     \
	 *         5       15
	 *       /  \     /   \
	 *     3    7    12    18
	 *        /  \
	 *       6    9    
	 * */
	public void testFindNext2(){
		B08FindNextNode tree = new B08FindNextNode();
		tree.add(10);
		tree.add(5);
		tree.add(15);
		tree.add(3);
		tree.add(7);
		tree.add(12);
		tree.add(18);
		tree.add(6);
		tree.add(9);
		tree.findNextValue(15);
	}
	@Test
	/*
	 * 测试用例为没有左子树的二叉树
	 *   1
	 *    2
	 *     3
	 *      4
	 *       5
	 *        6
	 * */
	public void testFindNode3(){
		B08FindNextNode tree = new B08FindNextNode();
		for(int i=1;i<7;i++){
			tree.add(i);
		}
		tree.findNextValue(5);
	}
	
	@Test
	/*
	 * 测试用例为没有右子树的二叉树
	 *         6
	 *        5
	 *       4
	 *      3
	 *     2
	 *    1
	 * */
	public void testFindNode4(){
		B08FindNextNode tree = new B08FindNextNode();
		for(int i=6;i>0;i--){
			tree.add(i);
		}
		tree.findNextValue(5);
	}
	
	// 添加元素方法
	public void add(int value){
		Node addNode = new Node();
		addNode.value = value;
		
		Node currentNode = head;
		
		if(currentNode==null){
			head = addNode;
			return ;
		}
		
		Node parent = null;
		while(currentNode!=null){
			parent = currentNode;
			if(currentNode.value>value){
				currentNode = currentNode.left;
			}else if(currentNode.value<value){
				currentNode = currentNode.right;
			}else{
				return ;
			}
		}
		if(parent.value>value){
			parent.left = new Node(parent,null,null,value);
		}else{
			parent.right = new Node(parent,null,null,value);
		}
	}
	
	private class Node{
		private Node left;
		private Node right;
		private Node parent;
		private int value;
		
		public Node(){
			
		}
		
		public Node(Node parent,Node left,Node right,int value){
			this.left = left;
			this.parent = parent;
			this.right = right;
			this.value = value;
		}
	}
}
