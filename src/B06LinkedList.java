import org.junit.Test;

/*
 * 这个类主要实现 java 的链表，并写了一个从尾到头
 * 打印链表的方法。
 * */
public class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList(){
		size = 0;
	}
	
	// 添加元素
	public void add(Object obj){
		Node tempNode = new Node(null,obj);
		if(head==null){
			head = tempNode;
			tail = tempNode;
		}else{
			tail.next = tempNode;
			tail = tail.next;
		}
		size++;
	}
	
	// 删除指定元素
	public void remove(Object obj){
		
		if(size==0){
			System.out.println("数组中不存在元素");
			return ;
		}
		
		
		// 如果第一个元素为空，进行修改
		if(head.value.equals(obj)){
			head=head.next;
		}
		
		Node currentNode = head;
		Node tobeDelete;
		while(currentNode!=null){
			tobeDelete = currentNode.next;
			if(tobeDelete!=null && obj.equals(tobeDelete.value)){
				if(tail.value.equals((tobeDelete.value))){
					tail = currentNode;
				}
				currentNode.next = tobeDelete.next;
				break;
			}
			currentNode = currentNode.next;
		}
		size--;
	}
	
	// 从尾到头打印链表
	public void printReversingly(){
		Object[] objs = new Object[getSize()];
		Node currentNode = head;
		
		int i=0;
		while(currentNode!=null){
			objs[i] = currentNode.value;
			currentNode = currentNode.next;
			i++;
		}
		
		for(int j=objs.length-1;j>=0;j--){
			System.out.println(objs[j]);
		}
	}
	
	public int getSize(){
		return this.size;
	}
	
	// 链表的一个内部类
	class Node{
		public Node next;
		public Object value;
		
		public Node(){
			
		}
		
		public Node(Node next,Object value){
			this.next = next;
			this.value = value;
		}
	}
	
	@Test
	// 测试方法
	public void addTest(){
		LinkedList linkedList = new LinkedList();
		linkedList.add("h");
		linkedList.add("a");
		linkedList.add("r");
		linkedList.add("d");
		linkedList.add("!");
		linkedList.remove("!");
		linkedList.add("!!");
		linkedList.printReversingly();
	}
}

