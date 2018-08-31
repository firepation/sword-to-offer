package chacpter5;

import org.junit.Test;

public class B42FindGreatsSumOfSubArray {
	/*
	 * 题目：
	 * 输入一个整型数组，数组里有正数也有负数。数组中的一个
	 * 或连续多个整数组成一个子数组。求所有子数组的和的最大值。
	 * 要求时间复杂度为O(N)
	 */
	public int solution(int[] array) {
        if(array==null || array.length<=0)
            return 0;
        // 这里不能设为0，防止出现负数
        int result = array[0];
        int curSum = 0;
        for(int i=0;i<array.length;i++){
            if(curSum<=0)
                curSum = array[i];
            else
                curSum += array[i];
            
            if(curSum>result)
                result = curSum;
        }
        return result;
    }
	
	@Test
	public void test(){
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(solution(array));
	}
}
