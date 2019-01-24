import org.junit.Test;

public class B57FindNumbersWithSum {
	/*
	 * 题目：
	 * 输入一个递增排序的数组和一个数字s,在数组中查找两个数,使
	 * 得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
	 */
	public void solution(int[] data,int sum){
		if(data==null || data.length==0)
			return ;
		int ahead = 0;
		int behind = data.length-1;
		while(ahead<behind){
			int result = data[ahead]+data[behind];
			if(result==sum)
				break ;
			else if(result<sum)
				ahead++;
			else if(result>sum)
				behind--;
		}
		System.out.println(data[ahead]+"+"+data[behind]+"="+sum);
	}
	
	@Test
	public void test(){
		int[] data = {1,2,4,7,11,15};
		solution(data,11);
	}
}
