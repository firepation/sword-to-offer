import java.util.Stack;

import org.junit.Test;

public class B31PopOrder {
	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，
	 * 请判断第二个序列是否可能为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
	 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
	 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
	 * （注意：这两个序列的长度是相等的）
	 */
	
	/**
	 * 思路：
	 * 1. 如果下一个弹出的数字刚好是栈顶元素，则直接弹出
	 * 2. 如果下一个弹出的数字不是栈顶元素，则把pushA中
	 *    的pushIndex元素添加至栈中，直到把栈顶元素添加
	 *    到栈中
	 * 3. 如果所有数字都添加到栈中，仍然没有找到需要弹出的数字
	 *    那么该序列就不可能是一个弹出序列。
	 */
	public boolean isPopOrder(int[] pushA,int[] popA){
		
		boolean flag = false;
		
		if(pushA!=null && popA!=null){
			Stack<Integer> pushStack = new Stack<Integer>();
			int pushIndex = 0;
			int popIndex = 0;
			
			while(popIndex<popA.length){
				while(pushStack.isEmpty() || pushStack.peek()!=popA[popIndex]){
					if(pushIndex==pushA.length)
						break;
					pushStack.push(pushA[pushIndex]);
					
					pushIndex++;
				}
				if(pushStack.peek()!=popA[popIndex])
					break;
				pushStack.pop();
				popIndex++;
			}
			
			if(pushStack.isEmpty() && popIndex==popA.length)
				flag = true;
		}
		
		return flag;
	}
	
	@Test
	public void test(){
		int[] push = {1,2,3,4,5};
		int[] pop = {4,5,3,2,1};
		System.out.println(isPopOrder(push, pop));
	}
}
