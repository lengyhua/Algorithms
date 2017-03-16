package com.leng.test;

import java.awt.Color;

import com.bedpotato.alg4.BinarySearch;
import com.bedpotato.alg4.Counter;
import com.bedpotato.alg4.Interval1D;
import com.bedpotato.alg4.Interval2D;
import com.bedpotato.alg4.Point2D;
import com.bedpotato.alg4.utils.StdDraw;
import com.bedpotato.alg4.utils.StdIn;
import com.bedpotato.alg4.utils.StdOut;
import com.bedpotato.alg4.utils.StdRandom;
import com.leng.alg.VisualCounter;

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
		
		int interact = 0;
		int contains = 0;
		StdDraw.setPenColor(Color.RED);	//包含区域用另一种颜色标识
		StdDraw.setPenRadius(0.01);
		for(int i=0;i<N;i++){
			for(int j=0;j<=i;j++){
				if(i!=j){
					Interval2D I1 = ins[i];
					Interval2D I2 = ins[j];
					if(I1.intersects(I2)){
						interact++;
						Interval2D I3 = I1.getIntersects(I2);
						I3.draw();
					}
					if(I1.contains(I2) || I2.contains(I1)){
						contains++;
					}
				}
			}
		}
		
		System.out.println(interact);
		System.out.println(contains);
		
	}
	
}
/**
 * 练习1.2.6
 * 	判断字符串回环变位
 * @title C126
 * @author lengyhua
 * @date 2017年3月16日
 */
class C126{
	
	public static void main(String[] args) {
		
		System.out.println("请输入一个字符串：");
		String s = StdIn.readLine();
		System.out.println("请输入另一个字符串：");
		String t = StdIn.readLine();
		
		boolean flag = s.length()==t.length() && t.concat(t).indexOf(s)>=0;
		System.out.println(flag);
		
	}
	
}
/**
 * 练习1.2.9
 * 	使用Counter统计二分查找中被检查的键的总数，并在查找全部结束后打印该值
 * @title C129
 * @author lengyhua
 * @date 2017年3月16日
 */
class C129{
	public static void main(String[] args) {
		
		Counter c = new Counter("计数器");
		int[] a = new int[100];
		for(int i=0;i<100;i++){
			a[i] = i;
		}
		
		BinarySearch.rank(10, a, c);
		System.out.println(c.tally());
		
	}
}
/**
 * 练习1.2.10
 * 	
 * @title C1210
 * @author lengyhua
 * @date 2017年3月16日
 */
class C1210{
	
	public static void main(String[] args) {
		VisualCounter vc = new VisualCounter(10000,100);
		boolean[] fs = new boolean[10000];
		for(int i=0;i<10000;i++){
			fs[i] = StdRandom.uniform()<0.5;
		}
		vc.draw(fs);
	}
	
}
/**
 * 练习1.2.11
 * @title C1211
 * @author lengyhua
 * @date 2017年3月16日
 */
class C1211{
	
	
	
}

public class C12 {
	
	
	public static void main(String[] args) {
		//System.out.println(mystery("abcdefh"));
	}
	
	/**
	 * 练习1.2.7
	 * 	以下递归函数返回的是传入字符串的倒序
	 * @param s
	 * @return
	 */
	public static String mystery(String s){
		int N = s.length();
		if(N<=1)
			return s;
		String a = s.substring(0,N/2);
		String b = s.substring(N/2,N);
		return mystery(b) + mystery(a);
	}
	
}
