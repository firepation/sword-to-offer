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

public class InsertionSortList {
	/*
	 * 题目：
	 * 使用插入排序排序链表
	 */
	public ListNode sort(ListNode head){
		if(head==null || head.next==null)
			return head;

		ListNode root = new ListNode(0);
		root.next = head;
		ListNode current = head;
		ListNode nextNode = null;
		ListNode temp = null;
		
		while(current!=null && current.next!=null){
			if(current.val<current.next.val)
				current = current.next;
			else{
				nextNode = current.next;
				current.next = nextNode.next;
				
				temp = root;
				while(temp.next.val<nextNode.val)
					temp = temp.next;
				nextNode.next = temp.next;
				temp.next = nextNode;
			}
		}
		return root.next;
	}
	
	@Test
	public void test(){
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		printLinkedList(sort(head));
	}
	
	private void printLinkedList(ListNode head){
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
		
	}
}
