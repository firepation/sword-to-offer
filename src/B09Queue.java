import java.util.Stack;

import org.junit.Test;

public class B09Queue {
	/*
	 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函
	 * 数 appendTail 和 deleteHead，分别完成在队列尾部插入节点和
	 * 在队列头部删除节点的功能。
	 */
	
	
	private Stack<String> stack1 = new Stack<String>();
	private Stack<String> stack2 = new Stack<String>();
	public void appendTail(String str){
		stack1.push(str);
	}
	
	public String deleteHead(){
		if(stack2.size()==0){
			while(stack1.size()>0){
				stack2.push(stack1.pop());
			}
		}

		if(stack2.size()==0){
			throw new RuntimeException("队列中不存在元素");
		}
		return stack2.pop();
	}
	
	@Test
	public void test(){
		B09Queue queue = new B09Queue();
		queue.appendTail("keep");
		queue.appendTail("on");
		queue.appendTail("coding");
		
		for(int i=0;i<4;i++)
			System.out.println(queue.deleteHead());
	}
}
