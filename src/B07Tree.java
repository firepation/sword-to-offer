/*
 * 这是自己实现的一个二叉树，完成了添加方法和打印
 * 二叉树（前序、中序遍历）的方法
 * constructTree 是为了完成题目的功能
 * */

import org.junit.Test;

public class Tree {
	
	/*
	 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
	 * 假设输入的前序和中序遍历的结果中都不含重复的数字。例如，输入
	 * 前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1，5,3,8,6},
	 * 则重建此二叉树并输出它的头结点。
	 * */
	
	public static Tree constructTree(int[]befores,int[]centers){
		if(befores==null || centers==null){
			return null;
		}
		Node headNode = constructTree(befores,0,befores.length-1,centers,0,centers.length-1);
		Tree tree = new Tree();
		tree.head = headNode;
		return tree;
	}
	private static Node constructTree(int[]bef,int befStart,int befEnd,int[]cen,int cenStart,int cenEnd){
		
		if(cenStart>cenEnd || befStart>befEnd){
			return null;
		}
		
		// 根据前序遍历数组找出 root节点
		Node root = new Node();
		int rootValue = bef[befStart];
		root.value = rootValue;
		
		/*
		 *  找到根节点在中序遍历中的位置
		 *  以中序遍历数组确定左右子树长度
		 */
		int rootIndex = -1;
		for(int i=cenStart;i<=cenEnd;i++){
			if(cen[i]==rootValue)
				rootIndex = i;
		}
		
		if(rootIndex==-1){
			throw new RuntimeException("输入的参数不合法！");
		}
		
		int leftLength = rootIndex - cenStart;
		
		// 构建左子树
		root.left = constructTree(bef, befStart+1, befStart+leftLength, cen, cenStart, rootIndex-1);
		// 构建右子树
		root.right = constructTree(bef, befStart+leftLength+1, befEnd, cen, rootIndex+1, cenEnd);
		return root;
	}
	@Test
	// 测试案例为没有右节点的数
	public void constructTest1(){
		int[] befores = {1,2,3,4,5,6,7,8};
		int[] centers = {4, 7, 2, 1, 5, 3, 8, 6};
		Tree tree = Tree.constructTree(befores, centers);
		tree.printByBefore();
		System.out.println();
		tree.printByCenter();
	}
	@Test
	public void constructTest2(){
		int[] befores = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] centers = {4, 7, 2, 1, 5, 3, 8, 6};
		Tree tree = Tree.constructTree(befores, centers);
		tree.printByBefore();
		System.out.println();
		tree.printByCenter();
	}
	
	// 以下是添加与打印方法=============================================================================
	private Node head;
	
	// 构建树的一个内部类
	static class Node{
		private Node left;
		private Node right;
		private Integer value;
	}
	
	@Test
	public void testPring(){
		Tree tree = new Tree();
		tree.add(2);
		tree.add(1);
		tree.add(8);
		tree.add(5);
		tree.add(4);
		tree.add(7);
		tree.printByCenter();
		System.out.println();
		tree.printByBefore();
	}
	
	// 打印中序遍历结果
	public void printByCenter(){
		if(head!=null){
			printByCenter(head);
		}
	}
	private void printByCenter(Node node){
		
		if(node!=null){
			printByCenter(node.left);
			System.out.print(" "+node.value+" ");
			printByCenter(node.right);
		}
	}
	
	// 打印前序遍历结果
	public void printByBefore(){
		
		if(head!=null){
			printByBefore(head);
		}
	}
	private void printByBefore(Node node){
		if(node!=null){
			System.out.print(" "+node.value+" ");
			printByBefore(node.left);
			printByBefore(node.right);
		}
	}
	
	// 添加元素
	public void add(int value){		
		if(head==null){
			head = new Node();
			head.value = value;
			return ;
		}		
		Node currentNode = head;		
		Node x = null;
		while(currentNode!=null){
			x = currentNode;
			if(currentNode.value>value){
				currentNode = currentNode.left;
			}else if(currentNode.value<value){
				currentNode = currentNode.right;
			}else{
				return ;
			}
		}
		if(x.value>value){
			x.left = new Node();
			x.left.value = value;
		}else{
			x.right = new Node();
			x.right.value = value;
		}
	} 
}
