package chacpter5;

class ListNode{
	ListNode next;
	int val;
}

public class B52FindFirstCommonNode {
	public ListNode solution(ListNode node1,ListNode node2){
		int length1 = getListLength(node1);
		int length2 = getListLength(node2);
		int distanceLength = length1-length2;
		ListNode longListHead = node1;
		ListNode shortListHead = node2;
		if(distanceLength<0){
			distanceLength = -distanceLength;
			longListHead = node2;
			shortListHead = node1;
		}
		for(int i=1;i<=distanceLength;i++){
			longListHead = longListHead.next;
		}
		
		while(longListHead!=null && shortListHead!=null && (longListHead!=shortListHead)){
			longListHead = longListHead.next;
			shortListHead = shortListHead.next;
		}
		
		ListNode firstCommonNode = longListHead;
		return firstCommonNode;
	}
	
	private int getListLength(ListNode node){
		int count = 0;
		ListNode current = node;
		while(current!=null){
			count++;
			current = current.next;
		}
		return count;
	}
}
