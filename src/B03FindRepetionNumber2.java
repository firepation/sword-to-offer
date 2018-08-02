public class FindRepetionNumber2 {
	/*
	在一个长度为 n+1 的数组里的所有数字都在 1~n 的范围内，所以数组中至少有一个数字是重复的。
	请找出数组中任意一个重复的数字，但不能修改输入的数组。例如，如果输入长度为 8 的数组 
	{ 2 , 3 , 5 , 4 , 3 , 2 , 6 , 7 }，那么对应的输出是重复的数字 2 或者 3。
	*/
	public int getDuplication(int arr[]){
		if(arr.length==0 || arr == null){
			return 0;
		}
		int start = 1;
		int end  = arr.length-1;
		while(start<=end){
			int middle = (start+end)/2;
			int count = countRange(arr, start, middle);
			/*
			 * 判断是否只剩下一个数字，如果是，并且 count 值大于 1，
			 * 那么这个数字就是重复的。
			 * */
			if(end == start){
				if(count>1){
					return start;
				}else{
					break;
				}
			}	
			if(count==middle-start+1){
				start = middle + 1;
			}else{
				end = middle;
			}
		}	
		return 0;
	}
	// 查找数组中存在几个 start-end 范围的元素
	public int countRange(int[] numbers,int start,int end){
		if(numbers == null){
			return 0;
		}
		
		int count = 0;
		for(int i=0;i<numbers.length;i++){ 
			if(numbers[i]>=start && numbers[i]<=end)
				count++;
		}
		
		return count;
	}
}
