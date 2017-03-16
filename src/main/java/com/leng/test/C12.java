package com.leng.test;

import java.awt.Color;

import com.bedpotato.alg4.Interval1D;
import com.bedpotato.alg4.Interval2D;
import com.bedpotato.alg4.Point2D;
import com.bedpotato.alg4.utils.StdDraw;
import com.bedpotato.alg4.utils.StdIn;
import com.bedpotato.alg4.utils.StdOut;
import com.bedpotato.alg4.utils.StdRandom;

/**
 * 练习1.2.1
 * 	接受一个正整数生成N个随机点，然后计算两点之间的最近距离
 * @title C121
 * @author lengyhua
 * @date 2017年3月15日
 */
class C121{
	
	public static void main(String[] args) {

		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdOut.println("请输入一个整数：");
		int N = StdIn.readInt();
		Point2D[] ps = new Point2D[N];
		for(int i=0;i<N;i++){
			ps[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
			StdDraw.point(ps[i]);
		}
		
		double min = ps[0].distanceTo(ps[1]);
		int m=0,n=1;
		for(int i=0;i<N;i++){
			for(int j=0;j<=i;j++){
				if(i != j){
					double dis = ps[i].distanceTo(ps[j]);
					if(dis<min){
						min = dis;
						m = i;
						n = j;
					}
				}
			}
		}
		
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(ps[m], ps[n]);
		
	
	}
	
}
/**
 * 练习1.2.2
 * 	从标准输入中读取N个间隔，并打印出所有相交的间隔对
 * @title C122
 * @author lengyhua
 * @date 2017年3月15日
 */
class C122{
	
	public static void main(String[] args) {
		
		StdOut.println("请输入一个整数：");
		int N = StdIn.readInt();
		Interval1D[] ps = new Interval1D[N];
		for(int i=0;i<N;i++){
			
			double x = StdIn.readDouble();
			double y = StdIn.readDouble();
			double t = x;
			if(x>y){
				x = y;
				y = t;
			}
			ps[i] = new Interval1D(x, y);
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<=i;j++){
				if(i!=j && ps[i].intersects(ps[j])){
					StdOut.println(ps[i]+" " + ps[j]);
				}
			}
		}
		
	}
	
}

/**
 * 练习1.2.3
 * 	从命令行接受参数N、min和max，生成N个随机的2D间隔，其宽和高均匀地分布在单位正方形中的min和max之间，
 * 	用StdDraw画出它们并打印出相交的间隔对的数量以及有包含关系的间隔对数量
 * @title C123
 * @author lengyhua
 * @date 2017年3月16日
 */
class C123{
	
	public static void main(String[] args) {
		
		System.out.println("请输入三个整数：");
		int N = StdIn.readInt();
		double min = StdIn.readDouble();
		double max = StdIn.readDouble();
		
		StdDraw.setScale(min, max);
		StdDraw.setPenColor(Color.GRAY);
		Interval2D[] ins = new Interval2D[N];
		for(int i=0;i<N;i++){
			Interval1D i1 = Interval1D.genInterval(StdRandom.uniform(min, max),StdRandom.uniform(min, max));
			Interval1D i2 = Interval1D.genInterval(StdRandom.uniform(min, max),StdRandom.uniform(min, max));
			ins[i] = new Interval2D(i1, i2);
			ins[i].draw();
			
		}
	}
	
}


public class C12 {
	
	
	public static void main(String[] args) {}
	
}
