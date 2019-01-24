import org.junit.Test;

public class B62LastRemaining {
	/*
	 * 题目：
	 * 0,1,...,n-1 这 n 个数字排成一个圆圈，从数字 0 开始
	 * 每次从这个圆圈中删除第 m 个数字。求出这个圆圈里剩下
	 * 的最后一个数字。
	 */
	public int solution(int n,int m){
		if(n<1 || m<-1)
			return -1;
		int last = 0;
		for(int i=2;i<=n;i++){
			last = (last+m)%i;
		}
		return last;
	}
	
	@Test
	public void test(){
		System.out.println(solution(10,2));
	}
}
