import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class B59MaxInWindows {
	/*
	 * 题目：
	 * 给定一个数组和滑动窗口的大小,找出所有滑动窗口里数值的最大值.例如,如果输入数组
	 * {2,3,4,2,6,2,5,1}及滑动窗口的大小3,那么一共存在6个滑动窗口,它们的最大值分别为
	 * {4,4,6,6,6,5};针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个:{[2,3,4],2,6,2,5,1}, 
	 * {2,[3,4,2],6,2,5,1},{2,3,[4,2,6],2,5,1}, {2,3,4,[2,6,2],5,1}, 
	 * {2,3,4,2,[6,2,5],1}, {2,3,4,2,6,[2,5,1]}。
	 */
	public ArrayList<Integer> maxInWindows(int[] num,int size){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(num!=null && num.length>=size && size>0){
			LinkedList<Integer> index = new LinkedList<>();
			
			for(int i=0;i<size;i++){
				while(!index.isEmpty() && num[i]>=num[index.peekLast()])
					index.removeLast();
				index.add(i);
			}
			
			for(int i=size;i<num.length;i++){
				result.add(num[index.peekFirst()]);
				while(!index.isEmpty() && num[i]>=num[index.peekLast()])
					index.removeLast();
				if(!index.isEmpty() && index.peekFirst()<=(i-size))
					index.removeFirst();
				index.addLast(i);
				
			}
			result.add(num[index.peekFirst()]);
		}
		return result;
	}
	
	@Test
	public void test(){
		int num[] = {2,3,4,2,6,2,5,1};
		System.out.println(maxInWindows(num, 3));
	}
}
