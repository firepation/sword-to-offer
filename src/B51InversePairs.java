package chacpter5;

import org.junit.Test;

public class B51InversePairs {
	/*
	 * 题目：
	 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
	 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组
	 * 的逆序对总数。例如，在数组{7,5,6,4}中，一共存在5个逆序对，
	 * 分别是(7,6),(7,5),(7,4),(6,4),(5,4)
	 */
	public int solution(int[] datas){
		if(datas==null || datas.length==0)
			return 0;
		int[] copys = new int[datas.length];
		for(int i=0;i<datas.length;i++)
			copys[i] = datas[i];
		int result = count(copys,datas,0,datas.length-1);
		return result;
	}
	
	// 为了防止结果过大，超过 int 类型的范围，建议使用 long 作为返回值
	private int count(int[] copys,int[] datas,int start,int end){
		if(start>=end)
			return 0;
		
		int mid = (start+end)/2;
		int countLeft = count(datas,copys,start,mid);
		int countRight = count(datas,copys,mid+1,end);
		
		int countCur = 0;
		int copyIndex = end;
		int i = mid;
		int j = end;
		while(i>=start && j>mid){
			if(datas[i]>datas[j]){
				copys[copyIndex--] = datas[i--]; 
				countCur += j-mid;
			}else{
				copys[copyIndex--] = datas[j--];
			}
		}
		while(i>=start){
			copys[copyIndex--] = datas[i];
			i--;
		}
		while(j>mid){
			copys[copyIndex--] = datas[j];
			j--;
		}
		return countLeft+countRight+countCur;
	}
	
	@Test
	public void test(){
		int[] datas = {7,5,6,4};
		System.out.println(solution(datas));
	}
}
