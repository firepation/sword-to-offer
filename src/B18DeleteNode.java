public class B18DeleteNode {
	/*
	 * 题目一：
	 * 在 O(1) 时间内删除链表节点。
	 * 给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内
	 * 删除该节点。
	 * */
	
	/*
	 *  此方法假设要删除的节点在链表中，因此在调用这个方法
	 *  之前应该确保删除的节点在链表中，为了保证时间复杂度
	 *  为 O(1) 才没有进行判断。该方法时间复杂度为：
	 *  [(n-1)*O(1) + O(n)] / n = O(1)
	 */
	public void deleteNode(Node toBeDelete){
		if(head==null || toBeDelete==null)
			return;
		
		if(toBeDelete.next!=null){
			Node nextNode = toBeDelete.next;
			toBeDelete.value = nextNode.value;
			toBeDelete.next = nextNode.next;
		}else if(head.value.equals(toBeDelete.value)){
			head = null;
			tail = null;
		}else{
			Node currentNode = head;
			while(!toBeDelete.value.equals(currentNode.next.value)){
				currentNode = currentNode.next;
			}
			currentNode.next = null;
		}
	}	
	@Test
	public void test1(){
		B18DeleteNode d = new B18DeleteNode();
		d.add("I");
		d.add("do");
		d.add("not");
		d.add("talk");
		d.add("anymore");
		//Node toBeDelete = d.head.next;
		// Node toBeDelete = d.tail;
		 Node toBeDelete = d.head;
		d.deleteNode(toBeDelete);
		d.printLinkList();
	}
	
	/*
	 *  题目二:
	 *  删除链表中的重复节点
	 *  在一个排序的链表中，如何删除重复的节点？
	 *  例如，删除链表:1->2->3->3->-4>->4->5
	 *  中的重复值之后，该链表变为
	 *  1->2->5
	 */
	public void deleteRepeatNode(){
		if(head==null)
			return;
		
		Node pre = null;
		Node current = head;
		while(current!=null){
			Node nextNode = current.next;
			boolean needDelete = false;
			if(nextNode!=null && current.value.equals(nextNode.value)){
				needDelete = true;
			}
			
			// 如果没有重复节点，给 pre 赋值，然后遍历下一个节点
			if(!needDelete){
				pre = current;
				current = nextNode;
			}else{
				Object value = current.value;
				Node toBeDelete = current;
				// 这个循环主要是为了找出下一个不包含重复值的节点
				while(toBeDelete!=null && value.equals(toBeDelete.value)){
					nextNode = toBeDelete.next;
					toBeDelete.value = null;
					toBeDelete = nextNode;
				}
				if(pre==null || pre.value==null){
					head = nextNode;
					pre = nextNode;
				}
				else{
					pre.next = nextNode;
				}
				current = nextNode;
			}
		}
	}
	@Test
	public void test2(){
		B18DeleteNode d = new B18DeleteNode();
		d.add(1);
		d.add(1);
		d.add(2);
		d.add(2);
		d.add(3);
		d.add(3);
		d.add(4);
		d.add(4);
		d.add(5);
		d.deleteRepeatNode();
		d.printLinkList();
	}
	
	// --------------链表添加和打印方法的实现---------------------
	
	private Node head;
	private Node tail;
	
	private class Node{
		private Object value;
		private Node next;
		
		public Node(Object value,Node next){
			this.value = value;
			this.next = next;
		}
	}
	
	public void printLinkList(){
		Node currentNode = head;
		while(currentNode!=null){
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}
	
	public void add(Object value){
		Node temp = new Node(value,null);
		if(head==null){
			head = temp;
			tail = temp;
		}else{
			tail.next = temp;
			tail = tail.next;
		}
	}
}
