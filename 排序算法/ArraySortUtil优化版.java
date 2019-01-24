package util;

/**
 * 排序算法的简单实现
 * @author firefox
 *
 */
public class ArrayUtil优化版 {
	/**
	 * 冒泡排序
	 */
	/*
	 *  这种算法并不是两两相比较，而是第 i 个与 i+1 到最后一个元素依次比较
	 *  因此这不是正宗的冒泡排序
	 */
	public static void bubbleSort1(int[] array){
		if(array==null || array.length==0)
			return ;
		int count1=0,count2=0;
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				count1++;
				if(array[i]>array[j]){
					count2++;
					swap(array,i,j);
				}
			}
		}
		System.out.println("总共进行了"+count1+"次比较"+count2+"次移动");
	}
	/*
	 *  这是冒泡排序的改进算法，当一个循环下来没有进行一次移动
	 *  说明这个数组已经排序好了，因此可以直接返回结果了
	 */
	public static void bubbleSort2(int[] array){
		if(array==null || array.length==0)
			return ;
		
		int count1=0,count2=0;
		boolean flag = true;
		for(int i=array.length-1;i>0 && flag;i--){
			flag = false;
			for(int j=0;j<i;j++){
				count1++;
				if(array[j+1]<array[j]){
					flag = true;
					count2++;
					swap(array,j+1,j);
				}
			}
		}
		System.out.println("总共进行了"+count1+"次比较"+count2+"次移动");
	}
	
	/**
	 * 选择排序
	 * @param array
	 */
	public static void selectSort(int[] array){
		if(array==null || array.length==0)
			return ;
		
		int minIndex = 0,count1=0,count2=0;		
		for(int i=0;i<array.length;i++){
			minIndex = i;
			for(int j=i;j<array.length;j++){
				count1++;
				if(array[j]<array[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex!=i){
				swap(array,minIndex,i);
				count2++;
			}
		}
		System.out.println("共进行了"+count1+"次比较"+count2+"次移动");
	}
	
	/**
	 * 插入排序
	 * @param array
	 */
	public static void insertSort(int[] array){
		if(array==null || array.length==0)
			return ;
		
		for(int i=1;i<array.length;i++){
			int insertNum = array[i];
			int insertIndex = i;
			for(int j=i-1;j>=0 && array[j]>insertNum;j--){
				array[j+1] = array[j];
				insertIndex = j;
			}
			array[insertIndex] = insertNum;
		}
	}
	
	/**
	 * 希尔排序
	 * 本质上是一种插入排序，只是他将一个数组分成几个序列，
	 * 分到后面就会发现数组已经基本接近有序的了，而插入排序针对
	 * 这种序列来说速度会更快
	 * @param array
	 */
	public static void shellSort(int[] array){
		int gap = 1;
		while(gap<array.length/3)
			gap = gap*3+1;
		
		while(gap>=1){
			for(int i=gap;i<array.length;i++){
				int insertIndex = i;
				int insertNum = array[i];
				for(int j=i-gap;j>=0 && array[j]>insertNum;j-=gap){
					array[j+gap] = array[j];
					insertIndex = j;
				}
				array[insertIndex] = insertNum;
			}
			gap = gap/3;
		}
	}
	
	/**
	 * 堆排序
	 * 对选择排序算法的改进
	 * @param array
	 */
	public static void heapSort(int[] array){
		for(int i=array.length/2;i>0;i--){
			heapAdjust(array,i,array.length);
		}
		for(int i =array.length-1;i>0;i--){
			swap(array,0,i);
			heapAdjust(array,0,i);
		}
	}
	private static void heapAdjust(int[] array,int parent,int length){
		int child = parent*2+1;
		while(child<length){
			if(child+1<length && array[child]<array[child+1]){
				child++;
			}
			
			if(array[child]<array[parent])
				break;
			swap(array,parent,child);
			parent = child;
			child = child * 2+ 1;
		}
	}
	/**
	 * 归并排序
	 * @param array
	 */
	public static void mergeSort(int[] array){
		if(array==null || array.length==0)
			return;
		mergeSort(array,0,array.length-1);
	}
	private static void mergeSort(int[] array,int left,int right){
		if(left<right){
			int mid = (left+right)/2;
			mergeSort(array,left,mid);
			mergeSort(array,mid+1,right);
			merge(array,left,mid,right);
		}
	}	
	private static void merge(int[] array,int left,int mid,int right){
		int[] temp = new int[right-left+1];
		int i = left;
		int j = mid+1;
		int index = 0;
		while(i<=mid && j<=right){
			if(array[i]<=array[j]){
				temp[index] = array[i];
				i++;
			}
			else if(array[i]>array[j]){
				temp[index] = array[j];
				j++;
			}
			index++;
		}
		while(i<=mid){
			temp[index] = array[i];
			i++;
			index++;
		}
		while(j<=right){
			temp[index] = array[j];
			j++;
			index++;
		}

		index = 0;
		while(left<=right){
			array[left++] = temp[index++];
		}
	}
	/**
	 * 快速排序
	 * @param array
	 */
	public static void quickSort(int[] array){
		if(array==null || array.length==0)
			return ;
		quickSort(array,0,array.length);
	}
	private static void quickSort(int[] array,int left,int right){
		if(left<right){
			int pointer = partition3(array,left,right);
			quickSort(array,left,pointer);
			quickSort(array,pointer+1,right);
		}
	}
	/*
	 * 1、这种快速算法碰到有的序列性能变得极差，时间复杂度会直接掉到 O(N^2)
	 */
	private static int partition1(int[] array,int left,int right){
		int pointer = array[left];
		while(left<right){
			while(left<right && array[right]>=pointer){
				right--;
			}
			swap(array,left,right);
			while(left<right && array[left]<=pointer){
				left++;
			}
			swap(array,left,right);
		}
		return left;
	}
	/*
	 * 2、这是对快速排序算法的第一种优化，主要是避免 left 值为极值
	 */
	private static int partition2(int[] array,int left,int right){
		int mid = (left+right)/2;
		if(array[left]>array[right])
			swap(array,left,right);
		if(array[mid]>array[right])
			swap(array,right,mid);
		if(array[left]>array[mid])
			swap(array,left,mid);
		int pointer = array[left];
		while(left<right){
			while(left<right && array[right]>=pointer){
				right--;
			}
			swap(array,left,right);
			while(left<right && array[left]<=pointer){
				left++;
			}
			swap(array,left,right);
		}
		return left;
	}
	/*
	 * 3、优化掉不必要的交换
	 */
	private static int partition3(int[] array,int left,int right){
		int mid = (left+right)/2;
		if(array[left]>array[right])
			swap(array,left,right);
		if(array[mid]>array[right])
			swap(array,right,mid);
		if(array[left]>array[mid])
			swap(array,left,mid);
		int pointer = array[left];
		while(left<right){
			while(left<right && array[right]>=pointer){
				right--;
			}
			// 主要在这里避免不必要的交换
			// swap(array,left,right);
			array[left] = array[right];
			while(left<right && array[left]<=pointer){
				left++;
			}
			// 主要在这里避免不必要的交换
			//swap(array,left,right);
			array[right] = array[left];
		}
		array[left] = pointer;
		return left;
	}
	/*
	 * 4、优化小数组的排序方案
	 *  当需要排序的小数组小于等于一个数时，调用插入排序算法
	 *  当需要排序的小数组大于这个数时，才调用快速排序算法
	 */
	
	public static void main(String[] args){
		// {2,1,0,3,4,5,6,7,8,9}
		int[] array1 = {9,2,3,0,7,1,5,4,6,8};
		System.out.println("冒泡排序1结果：");
		ArrayUtil.bubbleSort1(array1);
		ArrayUtil.printArray(array1);
		
		int[] array2 = {9,2,3,0,7,1,5,4,6,8};
		System.out.println("冒泡排序2结果：");
		ArrayUtil.bubbleSort2(array2);
		ArrayUtil.printArray(array2);
		
		int[] array3 = {9,2,3,0,7,1,5,4,6,8};
		System.out.println("选择排序结果：");
		ArrayUtil.selectSort(array3);
		ArrayUtil.printArray(array3);
		
		int[] array4 = {9,2,3,0,7,1,5,4,6,8};
		System.out.println("插入排序结果：");
		ArrayUtil.insertSort(array4);
		ArrayUtil.printArray(array4);
		
		int[] array5 = {9,2,3,0,7,1,5,4,6,8};
		System.out.println("希尔排序结果：");
		ArrayUtil.shellSort(array5);
		ArrayUtil.printArray(array5);
		
		int[] array6 = {9,2,3,0,7,1,5,4,6,8};
		System.out.println("堆排序结果：");
		ArrayUtil.heapSort(array6);
		ArrayUtil.printArray(array6);
		
		int[] array7 = {9,2,3,0,7,1,5,4,6,8};
		System.out.println("归并排序结果：");
		ArrayUtil.mergeSort(array7);
		ArrayUtil.printArray(array7);
		
		int[] array8 = {9,2,3,0,7,1,5,4,6,8};
		System.out.println("快速排序结果：");
		ArrayUtil.mergeSort(array8);
		ArrayUtil.printArray(array8);
	}
	
	/**
	 * 打印数组
	 * @param array
	 */
	private static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("\n");
	}
	
	/**
	 * 交换数组中的两个元素
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
