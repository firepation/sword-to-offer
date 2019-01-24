import org.junit.Test;

public class B53GetNumberOfK {
	/*
	 * 题目：
	 * 统计一个数字在排序数组中出现的次数。例如，输入排序数组
	 * {1,2,3,3,3,3,3,4,5}和数字3,由于3这个数在数组中出现了
	 * 4次，因此输出4.
	 */
	public int solution(int [] array , int k) {
		int number = 0;
		if(array!=null && array.length!=0){
			int first = findFirstK(array,0,array.length-1,k);
			int last = findLastK(array,0,array.length-1,k);
			if(first>-1 && last>-1)
				number = last - first + 1;
		}
		return number;
    }
	private int findFirstK(int[] array,int left,int right,int k){
		if(left>right)
			return -1;
		int mid = -1;
		mid = (left+right)/2;
		if(array[mid]==k){
			if((mid>0 && array[mid-1]!=k) || mid==0)
				return mid;
			else{
				right = mid-1;
			}
		}
		else if(array[mid]>k)
			right = mid-1;
		else if(array[mid]<k)
			left = mid+1;
		return findFirstK(array, left, right, k);
	}
	private int findLastK(int[] array,int left,int right,int k){
		if(left>right)
			return -1;
		int mid = -1;
		while(left<=right){
			mid = (left+right)/2;
			if(array[mid]==k){
				if((mid<right && array[mid+1]!=k) || mid==right)
					return mid;
				else
					left = mid + 1;
			}else if(array[mid]>k){
				right = mid - 1;
			}else if(array[mid]<k){
				left = mid + 1;
			}
		}
		return findLastK(array,left,right,k);
	}
	
	
	@Test
	public void test(){
		int[] array = {1,3,3,3,3,4,5};
		System.out.println(solution(array, 3));
	}
}
