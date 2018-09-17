
/*class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class B23ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        
        ListNode currentNode = head;
        ListNode preNode = null;
        ListNode nextNode = null;
        while(currentNode!=null){
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }
}
