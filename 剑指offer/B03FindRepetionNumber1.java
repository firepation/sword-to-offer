import java.util.Arrays;

import org.junit.Test;

public class FindRepetionNumber1{
	/*
	 在一个长度为 n 的数组里的所有数字都在 0 ~ n-1 的范围内。数组中某些数字是重复的，
	 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
	 例如，如果输入长度为 7 的数组 { 2，3 , 1 , 0 , 2 , 5 , 3 }，那么对应的输出是重复的数字 2 或者 3。
	*/	
	
	// 解法一
	public void bySort(int arr[]){
		
		if(arr==null || arr.length==0){
			System.out.println("数组中不存在数字");
			return;
		}
		
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++){
			if(arr[i] == arr[i+1]){
				System.out.println("数组中至少存在一个重复数字："+arr[i]);
				return;
			}
		}
		System.out.println("数组中不存在重复数字");
	}
	// 解法二
	public void byHashTable(int[] arr){
		
		if(arr==null || arr.length==0){
			System.out.println("数组中不存在数字");
			return;
		}
		
		int[] hashTable = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			if(hashTable[arr[i]] != 0){
				System.out.println("该数组存在重复数字："+arr[i]);
				return ;
			}
			hashTable[arr[i]] += 1;
		}		
	}
	// 解法三
	public void byDuplication(int[] arr){
	if(arr!=null && arr.length>0){
		for(int i=0;i<arr.length;i++){
			while(arr[i]!=i){
				if(arr[i]>=arr.length){
						System.out.println("数组元素大小超出限制！");
						return;
					}
				if(arr[arr[i]] == arr[i]){
					System.out.println("存在重复数字："+arr[i]);
					return;
				}
				
				int temp = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = temp;
			}
		}
		System.out.println("数组中不存在重复元素");
	}
	}
}
