
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class B24MergeList {
	/**
	 * 题目：
	 * 输入两个单调递增的链表，输出两个链表合成后的链表，
	 * 当然我们需要合成后的链表满足单调不减规则。
	 */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        
        ListNode mergeNode = null;
        if(list1.val<list2.val){
            mergeNode = list1;
            mergeNode.next = Merge(list1.next,list2);
        }else{
            mergeNode = list2;
            mergeNode.next = Merge(list1,list2.next);
        }
        
        return mergeNode;
    }
}