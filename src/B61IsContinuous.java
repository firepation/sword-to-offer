package chacpter6;

import java.util.Arrays;

import org.junit.Test;

public class B61IsContinuous {
	/*
	 * 题目：
	 * 从扑克牌中随机抽5张牌,判断是不是一个顺子,即这5张
	 * 牌是不是连续的.2~10为数字本身,A为1,J为11,Q为12,K为13,
	 * 而大、小王可看成任何数字。
	 */
	public boolean solution(int[] numbers){
		if(numbers==null)
			return false;
		// 1. 给数组排序
		Arrays.sort(numbers);
		// 2. 统计0的个数
		int zeroNum = 0;
		for(int i=0;i<numbers.length && numbers[i]==0;i++)
				zeroNum++;
		
		// 3. 不连续数字的间隔是否大于零的个数
		int numberOfGap = 0;
		int small = zeroNum;
		int big = small+1;
		while(big<numbers.length){
			if(numbers[small]==numbers[big])
				return false;
			numberOfGap += numbers[big]-numbers[small]-1;
			small = big;
			big++;
		}
		return zeroNum>=numberOfGap ? true : false;
	}
	
	@Test
	public void test(){
		System.out.println(solution(new int[]{0,3,2,6,4}));
	}
}
