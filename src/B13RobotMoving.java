import org.junit.Test;

public class B13RobotMoving {
	/*
	 * 题目：
	 * 地上有一个  m 行 n 列的方格。一个机器人从坐标（0,0）的格子开
	 * 始移动，它每次可以向左、右、上、下移动一个，但不能进入行坐标和列
	 * 坐标的数位之和大于 k 的格子。例如，当 k=18 时，机器人能够进入方格
	 * （35,37），因为 3+5+3+7=18.但它不能进入方格（35,38），因为 3+5+3+8=19.
	 * 请问该机器人能够到达多少个格子。
	 * */
	
	// 提供给用户调用的方法
	public int movingCount(int k,int rows,int cols){
		if(k<0 || rows<0 || cols<0)
			return 0;
		
		boolean[][] visited = new boolean[rows][cols];
		
		return movingCountCore(k,0,0,rows,cols,visited);
	}
	
	// 辅助函数，解决问题的核心
	private int movingCountCore(int threshhold,int row,int col,int rows,int cols,boolean[][] visited){
		int count = 0;
		if(check(threshhold,row,col,rows,cols,visited)){
			visited[row][col] = true;
			count = 1 + movingCountCore(threshhold,row+1,col,rows,cols,visited)+
					movingCountCore(threshhold,row-1,col,rows,cols,visited)+
					movingCountCore(threshhold,row,col-1,rows,cols,visited)+
					movingCountCore(threshhold,row,col+1,rows,cols,visited);
		}
		return count;
	}
	
	// 判断是否能够进入方格
	private boolean check(int threshhold,int row,int col,int rows,int cols,boolean[][] visited){
		if(row>=0 && row<rows && col>=0 && col<cols && !visited[row][col] 
		   && getDigitSum(row)+getDigitSum(col)<=threshhold){
			return true;
		}			
		return false;
	}
	
	// 计算 number 各个位置上的数字的总和
	private int getDigitSum(int number){
		int sum = 0;
		while(number>0){
			sum += number%10;
			number = number/10;
		}
		return sum;
	}
	
	@Test
	public void test(){
		System.out.println(movingCount(0,4,4));
		System.out.println(movingCount(5,4,4));
	}
}
