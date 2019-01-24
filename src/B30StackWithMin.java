import java.util.Stack;

import org.junit.Test;

public class B30StackWithMin {
	/**
	 * 题目：
	 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中
	 * 所含最小元素的 min 函数（时间复杂度应为O(1)）.
	 */
	
	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int node){
		dataStack.push(node);
		if(minStack.size()==0 || node < minStack.peek())
			minStack.push(node);
	}
	
	public void pop(){
		int popNum = dataStack.pop();
		if(popNum == minStack.peek())
			minStack.pop();
	}
	
	public int top(){
		return dataStack.peek();
	}
	
	public int min(){
		if(minStack.size()>0)
			return minStack.peek();
		throw new RuntimeException("栈中没有元素");
	}
	
	@Test
	public void test(){
		B30StackWithMin s = new B30StackWithMin();
		s.push(1);
		s.push(2);
		s.pop();
		System.out.println(s.min());
	}
}
