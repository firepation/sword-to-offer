import org.junit.Test;

public class B15NumberOf1 {
	/*
	 * 题目：
	 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的
	 * 个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，
	 * 则该函数输出 2。
	 * */
	
	/*
	 *  可能会引起死循环的解法
	 *  这个解法针对正数是完全可行的，但是碰到负数，
	 *	右移之后左边第一位仍然是 1，这样便陷入的死循环。  
	 */
	public void solution1(int n){
		int count = 0;
		while(n != 0){
			if((n&1) == 1)
				count++;
			n = n >>1;
		}
		System.out.println("1 的个数为："+count);
	}
	
	// 常规解法
	public void solution2(int num){
		int count = 0 ;
		int flag = 1;
		/*
		 *  java 中整数有 32 位
		 *  flag 初始值为 1，之后进行位运算，
		 *  逐位判断 num 每一个数字是否为 1 
		 */
		for(int i=0;i<32;i++){
			if((num&flag)!=0)
				count++;
			flag = flag<<1;
		}
		System.out.println("1 的个数为："+count);
	}
	
	/*
	 *  最佳解法
	 *  将 num 和 num-1 进行位运算，则 num 最右边的 1 将变为 0
	 *  后边的 0 将变为 1 
	 *  有多少个 1 就可以进行多少次这样的操作。
	 *  语言表达能力不足，画图之后就会显得简单明了。
	 */
	
	public void solution3(int num){
		int count = 0 ;
		while(num!=0){
			count++;
			num = (num-1)&num;
		}
		System.out.println("1 的个数为："+count);
	}
	
	@Test
	public void test(){
		solution1(8);
		solution2(-8);
		solution3(-8);
	}
}
