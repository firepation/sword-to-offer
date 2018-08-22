class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class B22FindNodeInLinkedList {
    public ListNode FindKthToTail(ListNode head,int k) {
        
        if(head==null || k<=0)
            return null;
        
        ListNode front = head;
        ListNode behind = null;
        
        for(int i=1;i<k;i++){
            if(front==null)
                return null;
            front = front.next;
        }
        if(front==null)return null;
        behind = head;
        while(front.next!=null){
            front = front.next;
            behind = behind.next;
        }
        
        return behind;
    }
}
