import org.junit.Test;

public class B65Add {
	/*
	 * 题目：
	 * 写一个函数，求两个整数之和，要求在函数体内不得使用
	 * '+'、'-'、'*'、'/' 四则运算符号
	 */
	public int solution(int num1,int num2){
		int sum,carry;
		do{
			sum = num1^num2;
			carry = (num1&num2)<<1;
			num1 = sum;
			num2 = carry;
		}while(num2!=0);
		return num1;
	}
	
	@Test
	public void solution(){
		System.out.println(solution(5,7));
	}
	
}
