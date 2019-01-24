package chacpter5;

import org.junit.Test;

public class B49UglyNumber {
	/*
	 * 题目：
	 * 我们只把包含因子2,3,5的数称为丑数。求按从小到大的顺序的第N个丑数。
	 * 例如，6,8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做第一个丑数。
	 */
	public int solution(int index) {
        /*
         * 解法一
         * 逐个判断每个整数是不是丑数，直观但是不够高效
         */
        
        /*
         * 解法二：
         * 创建数组保存已经找到的丑数，用空间换时间的解法
         */
        if(index<=0)
            return 0;
        
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        
        int mutiply2=0,mutiply3=0,mutiply5 = 0;
        
        while(nextUglyIndex<index){
        	int min = min(uglyNumbers[mutiply2]*2,uglyNumbers[mutiply3]*3,uglyNumbers[mutiply5]*5);
        	uglyNumbers[nextUglyIndex] = min;
        	while(uglyNumbers[mutiply2]*2<=uglyNumbers[nextUglyIndex])
        		mutiply2++;
        	while(uglyNumbers[mutiply3]*3<=uglyNumbers[nextUglyIndex])
        		mutiply3++;
        	while(uglyNumbers[mutiply5]*5<=uglyNumbers[nextUglyIndex])
        		mutiply5++;
        	nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex-1];
    }
	
	private int min(int number1,int number2,int number3){
		int min = (number1<number2) ? number1 : number2;
		min = (min<number3) ? min : number3;
		return min;
	}
	
	@Test
	public void test(){
		System.out.println(solution(7));
	}
}
