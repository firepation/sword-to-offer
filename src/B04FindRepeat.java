public class FindRepeat 
{
	/*
	 题目:
	 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
	*/
	
	public void find(int[][] arr,int rows,int columns,int number){		
		if(arr!=null && rows>0 && columns>0){
			int row = 0;
			int column = columns-1;
			
			while(row<rows && column>=0){
				int tempNumber = arr[row][column];
				if(tempNumber==number){
					System.out.println("二维数组中包含钙元素");
					return ;
				}else if(tempNumber<number){
					row++;
				}else{
					column--;
				}
			}
		}
		System.out.println("数组中不包含该元素");
	}
}
