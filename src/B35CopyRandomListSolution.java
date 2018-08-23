public class B35CopyRandomListSolution {
	/**
	 * 题目
	 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
	 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
	 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要
	 * 返回参数中的节点引用，否则判题程序会直接返回空）
	 */
	
	public RandomListNode Clone(RandomListNode pHead)
    {
        cloneNodes(pHead);
        cloneSiblingNodes(pHead);
        return reconnectNodes(pHead);
    }
    
	// 复制节N为N^并放在插入到N后面
    private void cloneNodes(RandomListNode pHead)
    {
    	RandomListNode current = pHead;
    	while(current!=null){
    		RandomListNode cloneNode = new RandomListNode(current.label);
    		cloneNode.next = current.next;
    		current.next = cloneNode;
    		
    		current = cloneNode.next;
    	}
    }
    
    // 调整N^的random节点
    private void cloneSiblingNodes(RandomListNode pHead)
    {
        RandomListNode current = pHead;
        while(current!=null){
        	if(current.random!=null){
        		current.next.random = current.random.next;
        	}
        	current = current.next.next;
        }
    }
    
    // 拆分链表
    private RandomListNode reconnectNodes(RandomListNode pHead)
    {
    	RandomListNode cloneNode = null;
    	RandomListNode cloneHead = null;
    	RandomListNode current = pHead;
    	
    	if(current != null){
    		cloneHead = cloneNode = current.next;
    		current.next = cloneNode.next;
    		current = current.next;
    	}
    	
    	while(current != null){
    		cloneNode.next = current.next;
    		cloneNode = cloneNode.next;
    		
    		current.next = cloneNode.next;
    		current = current.next;    		
    	}
    	
        return cloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
