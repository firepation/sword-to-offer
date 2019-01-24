import java.util.ArrayList;

import org.junit.Test;

public class B57FindContinuousSequence {
	/*
	 * 题目：
	 * 输入一个正数s,打印出所有和为s的连续正数序列
	 * (至少含有两个数).例如,输入15,,由于1+2+3+4+5=4+5+6=7+8=15,
	 * 所以打印出3个连续序列1~5,4~6和7~8
	 */
	public ArrayList<ArrayList<Integer>> solution(int sum){
		ArrayList<ArrayList<Integer>> list  = new ArrayList<>();
		if(sum<3)
			return list;
		int small = 1;
		int big = 2;
		int middle = (sum+1)/2;
		int total = small+big;
		while(small<middle){
			if(total==sum)
				addSequence(list,small,big);
			while(total>sum && small<middle){
				total -= small;
				small++;
				if(total==sum){
					addSequence(list,small,big);
				}
			}
			big++;
			total+=big;
		}
		return list;
	}
	
	private void addSequence(ArrayList<ArrayList<Integer>> list,int small,int big){
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=small;i<=big;i++){
			temp.add(i);
		}
		list.add(temp);
	}
	
	@Test
	public void test(){
		System.out.println(solution(15));
	}
}