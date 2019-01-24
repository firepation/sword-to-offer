package leetcode;

import org.junit.Test;

/*
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}
*/
public class ReorderList {
	/*
	 * 题目：
	 * 将链表 L :L0-L1-L2-...L(n-1)-Ln 
	 * 转换为 L0:L0-Ln-L1-L(n-1)-L2-L(n-2)...
	 * 不允许修改节点中的值。例如，所给链表为{1,2,3,4},
	 * 输出结果为{1,4,2,3}
	 */
	public void reorderList(ListNode head){
		if(head==null)
			return ;
		// 通过快慢指针找到中间节点
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// 拆分列表，并将中间节点后面的列表反转
		fast = slow.next;
		slow.next = null;
		ListNode pre = null;
		while(fast!=null){
			ListNode temp = fast.next;
			fast.next = pre;
			pre = fast;
			fast = temp;
		}
		
		// 合并两个链表
		slow = head;
		fast = pre;
		while(fast!=null && slow!=null){
			ListNode slowTemp = slow.next;
			ListNode fastTemp = fast.next;
			slow.next = fast;
			fast.next = slowTemp;
			slow = slowTemp;
			fast = fastTemp;
		}
	}
	public void printList(ListNode head){
		ListNode temp = head;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	
	@Test
	public void tes(){
		ListNode root = new ListNode(5);
		root.next = new ListNode(6);
		root.next.next = new ListNode(7);
		root.next.next.next = new ListNode(8);
		reorderList(root);
		printList(root);
	}
}
