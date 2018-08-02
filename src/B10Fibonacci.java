import org.junit.Test;

public class B10Fibonacci {
	/*
	 * 题目：求斐波那契数列的第 n 项
	 * 写一个函数，输入 n，求斐波那契数列的第 n 项。
	 * */
	
	/*
	 * 这个题目也可以从另外的角度来提问，同样考验的是斐波那契数列
	 * 题目：青蛙跳台阶问题
	 * 一直青蛙以此可以跳上一级台阶，也可以跳上两级台阶。求该青蛙跳
	 * 上一个 n 级的台阶总共有多少种跳法。通过分析，也可得出这个问题
	 * 本质上就是考验斐波那契数列。
	 * */
	
	/*
	 * 这是一个通俗的解法，但是这种方法需要进行太多重复的运算
	 * */
	public long method1(int n){
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		return method1(n-1)+method1(n-2);
	}
	
	/*
	 * 第二种方法利用循环的方式完成一样的功能
	 * */
	public long method2(int n){
		long start = System.currentTimeMillis();
		int[] result = {0,1};
		if(n<2){
			return result[n];
		}
		
		/*
		 * fibN 表示菲波那切数列第 n 项
		 * fibOne 表示菲波那切数列第 n-1 项
		 * fibTwo 表示菲波那切数列第 n-2 项
		 * */
		long fibOne = 1;
		long fibTwo = 0;
		long fibN = 0;
		for(int i=2;i<=n;i++){
			fibN = fibOne + fibTwo;
			fibTwo = fibOne;
			fibOne = fibN;
		}
		System.out.println(System.currentTimeMillis()-start);
		return fibN;
	}
	
	@Test
	/*
	 * 测试的话，可以从三个角度进行
	 * 首先，进行基本的功能测试，即输入普通的数，3,5,10 等
	 * 其次，可以进行边界值测试，如输入 0,1,2
	 * 最后，进行性能的测试，即输入较大的数
	 * */
	public void testMethod1(){
		long start = System.currentTimeMillis();
		System.out.println(method1(50));
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(method2(50));
	}
	
	
}
