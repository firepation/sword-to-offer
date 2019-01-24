import java.util.HashMap;

import org.junit.Test;

class Point{
	int x;
	int y;
	Point(){x=0;y=0;}
	Point(int a,int b){x=a;y=b;}
}

public class MaxPointOnALine {
	/*
	 * 题目：
	 * 输入一个点数组，输出在同一条线上点的最大个数
	 */
	public int solution(Point[] points){
		if(points==null || points.length==0)
			return 0;
		int result = 0;
		for(int i=0;i<points.length;i++){
			int repeat = 0;   // 重复点的个数
			int curMax = 1;   // 一个循环中的最大个数
			int verNum = 0;   // 斜率不存在的个数
			HashMap<Double,Integer> map = new HashMap<Double,Integer>();
			for(int j=0;j<points.length;j++){
				if(i==j)
					continue;
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				
				// 两个点重复的情况
				if(x==0 && y==0){
					repeat++;
				}
				// 斜率不存在的情况
				else if(x==0){
					verNum = verNum==0 ? 2 : ++verNum;
					curMax = verNum>curMax ? verNum : curMax;
				}
				// 正常情况
				else{
					double k = y*1.0 / x;
					Integer count = map.get(k);
					if(count==null)
						map.put(k, (count=2));
					else
						map.put(k, ++count);
					
					curMax = count>curMax ? count : curMax;
				}
			}
			result = (curMax+repeat) > result ? curMax+repeat : result;
		}
		return result;
	}
	
	@Test
	public void test(){
		Point p = new Point(0,0);
		Point p2 = new Point(0,1);
		Point p3 = new Point(2,2);
		Point p4 = new Point(2,3);
		Point p5 = new Point(2,4);
		System.out.println(solution(new Point[]{p,p2,p3,p4,p5}));
	}
}
