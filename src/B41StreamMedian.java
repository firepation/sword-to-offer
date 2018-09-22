import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class B41StreamMedian {
	/*
	 * 题目：
	 * 如何得到一个数据流中的中位数呢？如果从数据流中读出
	 * 奇数个数值，那么中位数就是所有数值排序后位于中间的
	 * 数值。如果从数据流中读出偶数个数值，那么中位数就是
	 * 所有数值排序之后中间两个数的平均值。使用 insert 
	 * 方法读取数据流，使用 getMedian 方法获取数据的中位数。
	 */
	
	// 使用优先队列实现小顶堆
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	// 在优先队列中传入一个比较器，以实现大顶堆
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11,new Comparator<Integer>(){
		@Override
		public int compare(Integer num1,Integer num2){
			return num2 - num1;
		}
	});
	
	public void insert(Integer num){
		minHeap.add(num);
		if(minHeap.size()>maxHeap.size()+1){
			maxHeap.add(minHeap.poll());
			return ;
		}
		if(maxHeap.size()>0 && maxHeap.peek()>minHeap.peek()){
			Integer topMax = maxHeap.poll();
			Integer topMin = minHeap.poll();
			maxHeap.add(topMin);
			minHeap.add(topMax);
		}
	}
	
	public Double getMedian(){
		int count = minHeap.size() + maxHeap.size();
		if(count%2==1)
			return new Double(minHeap.peek());
		else
			return (minHeap.peek()+maxHeap.peek())/2.0;
	}
	
	@Test
	public void test(){
		insert(1);
		insert(9);
		insert(2);
		insert(7);
		insert(3);
		insert(5);
		insert(11);
		System.out.println(getMedian());
	}
}
