import org.junit.Test;

public class B14MaxProductActerCounting {
	/*
	 * 题目：
	 * 给你一根长度为 N 的绳子，请把绳子剪成 m 段（m、n 都是整数，
	 * n>1 并且 m>1），每段绳子的长度记为 k[0],k[1],...,[m]。请问 k[0]*k[1]...
	 * *k[m] 可能的最大乘积是多少？例如，当绳子的长度为 8 时，我们把它剪成长度
	 * 分别为 2，3，3 的三段，此时得到的最大乘积是 18。
	 * */
	
	// 利用动态规划求解
	public int solution1(int length){
		
		if(length<2)
			return 0;
		if(length==2)
			return 1;
		if(length==3)
			return 2;
		
		int[] products = new int[length+1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		
		for(int i=4;i<=length;i++){
			int max = 0;
			for(int j=1;j<=i/2;j++){
				int product = products[j]*products[i-j];
				if(product>max)
					max = product;
				products[i] = max;
			}
		}
		return products[length];
	}
	
	// 利用贪婪算法
	public int solution2(int length){
		if(length<2)
			return 0;
		if(length==2)
			return 1;
		if(length==3)
			return 2;
		// 尽可能多的剪去长度为 3 的绳子段
		int timesOf3 = length/3;
		// 如果绳子最后剩下长度为 4 的时候，不能再剪去长度为 3 的绳子段
		// 此时最佳的方法是把绳子剪成长度为 2 的两段，因为 2*2 > 3*1
		if(length-timesOf3*3==1)
			timesOf3 -= 1;
		int timesOf2 = (length-timesOf3*3)/2;
		
		return (int)Math.pow(3, timesOf3)*(int)Math.pow(2, timesOf2);
				
	}
	
	@Test
	public void test(){
		System.out.println(solution1(6));
		System.out.println(solution2(6));
	}
}