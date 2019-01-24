class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}

public class SortLinkedList {
	/* 
	 * 题目：
	 * 根据头结点给链表排序，要求时间复杂度为 O(nlogn) 
	 */
	
	/*
	 * 思路：
	 * 因为题目要求时间复杂度为O(nlogn),故可以考使用归并排序
	 * 归并排序的一般步骤为：
	 * 1. 将带排序数组(链表)取中点并一分为二
	 * 2. 递归的对左半部分进行归并排序
	 * 3. 递归的对右半部分进行归并排序
	 * 4. 将两个半部分进行合并，得到结果。
	 * 
	 * 因此该问题可以划分为三个小问题：
	 * 1. 找到链表中点(快慢指针思路,快指针一次走两步,慢指针一次走一步,快指针在链表末尾时，慢指针恰好在链表中点)
	 * 2. 写出merge函数,即如何合并链表
	 * 3. 写出mergeSort函数,实现上述步骤
	 */
	public ListNode sort(ListNode head){
		if(head==null || head.next==null)
			return head;
		
		ListNode middle = findMiddleNode(head);
		ListNode right = sort(middle.next);
		middle.next = null;
		ListNode left = sort(head);
		return mergeTwoList(left,right);
	}
	
	private ListNode mergeTwoList(ListNode left,ListNode right){
		ListNode head = new ListNode(0);
		ListNode temp = head;
		
		while(left!=null && right!=null){
			if(left.val>right.val){
				temp.next = right;
				right = right.next;
			}else{
				temp.next = left;
				left = left.next;
			}
			temp = temp.next;
		}
		while(left!=null){
			temp.next = left;
			temp = temp.next;
			left = left.next;
		}
		while(right!=null){
			temp.next = right;
			right = right.next;
			temp = temp.next;
		}
		return head.next;
	}
	
	private ListNode findMiddleNode(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
