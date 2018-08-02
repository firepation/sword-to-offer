import org.junit.Test;

public class B16Power {
	
	/*
	 * 题目：实现函数 double power(double base,int exponent),求 base 的
	 * exponent 次方。不得使用函数库，同时不需要考虑大数问题
	 * */
	
	/*
	 * 考虑到 exponent 为正数、负数、零的情况
	 * */
	public double power(double base,int exponent){
		
		if(base==0.0 && exponent<0){
			throw new RuntimeException("0 不存在负指数幂");
		}
		
		int absExponent = exponent;
		if(absExponent<0)
			absExponent = -absExponent;
		double result = powerWithAbsExponent2(base,absExponent);
		if(exponent<0)
			result = 1 / result;
		return result;
	}
	/*
	 * 这种方法运行速度较慢
	 * */
	@SuppressWarnings("unused")
	private double powerWithAbsExponent1(double base,int exponent){
		double result = 1;
		for(int i=0;i<exponent;i++){
			result *= base;  
		}
		return result;
	}
	/*
	 * 这是比较高效的运算方法
	 * */
	private double powerWithAbsExponent2(double base,int exponent){
		if(exponent==0)
			return 1;
		if(exponent==1)
			return base;
		
		double result = powerWithAbsExponent2(base,exponent>>1);
		result *= result;
		
		if((exponent&1)==1)
			result *= base;
		
		return result;
	}
	
	@Test
	public void test(){
		System.out.println(power(2,-2));
	}
}
