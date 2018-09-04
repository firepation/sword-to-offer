import org.junit.Test;

public class B64Sum1ToN {
	/*
	 * 题目：
	 * 求 1+2+...+n,要求不能使用乘除法、for、while、if、
	 * else、switch、case等关键字及条件判断语句(A?B:C)
	 */
	public int solution(int  n){
		int sum = n;
		boolean flag = n>0 && ((sum+=solution(n-1))>0);
		return sum;
	}
	
	@Test
	public void test(){
		System.out.println(solution(100));
	}
}