package chacpter5;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Test;

public class B40GetLeastNumbers {
	/**
	 * 题目：
	 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
	 */
	
	// 第一种方法，利用快速排序的 partition 函数来完成，但是这种方法会修改数组
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input.length<k || k<=0)
            return result;
        adjustArray(input,0,input.length-1,k);
        for(int i=0;i<k;i++)
            result.add(input[i]);
        return result;
    }
    
    private void adjustArray(int[] input,int start,int end,int k){
    	int pointer = partition(input,start,end);
        while(pointer!=k-1){
            if(pointer>k-1){
                end = pointer-1;
                pointer = partition(input,start,end);
            }else{
                start = pointer+1;
                pointer = partition(input,start,end);
            }
        }
    }
    
    private int partition(int[] input,int start,int end){
        int pointer = input[start];
        while(start<end){
            while(start<end && input[end]>=pointer)
                end--;
            input[start] = input[end];
            while(start<end && input[start]<=pointer)
                start++;
            input[end] = input[start];
        }
        input[start] = pointer;
        return start;
    }
    
    /*  第二种方法
     *  这种方法借助 TreeSet 集合类，每次存储四个，当超过四个时，将加入的元素和最大值比较，判断是否加入
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input,int k){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(input==null || input.length==0 || k<=0 || k>=input.length)
    		return result;
    	TreeSet<Integer> set = new TreeSet<Integer>();
    	for(int i=0;i<input.length;i++){
    		if(set.size()<k)
    			set.add(input[i]);
    		else{
    			int high = set.last();
    			if(high>input[i]){
    				set.pollLast();
    				set.add(input[i]);
    			}
    		}
    	}
    	result.addAll(set);
    	return result;
    }
    
    @Test
    public void test(){
    	int[] arr = {4,5,1,6,2,7,3,8};
    	//int[] arr = {};
    	ArrayList<Integer> list = GetLeastNumbers_Solution2(arr,4);
    	System.out.println(list);
    }
}
