package chacpter3;

import org.junit.Test;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class B23EntryNodeOfLoop {
	/*
	 * 题目：
	 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，
	 * 否则，输出null。
	 */
	public ListNode solution(ListNode pHead){
		if(pHead==null || pHead.next==null)
			return null;
		ListNode fast = pHead;
		ListNode slow = pHead;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow){
				slow = pHead;
				while(slow!=fast){
					slow = slow.next;
					fast = fast.next;
				}
				break;
			}
		}
		return fast;
	}
	
	@Test
	public void test(){
		ListNode root = new ListNode(7);
		root.next = new ListNode(6);
		root.next.next = new ListNode(5);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = root;
		System.out.println(solution(root).val);
	}
}
