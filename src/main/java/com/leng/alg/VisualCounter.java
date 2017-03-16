package com.leng.alg;

import java.awt.Color;

import com.bedpotato.alg4.Point2D;
import com.bedpotato.alg4.utils.StdDraw;
import com.bedpotato.alg4.utils.StdRandom;

/**
 * 改类支持加一减一操作，通过构造函数N确定操作的最大次数，max指定计数器的最大绝对值
 * @title VisualCounter
 * @author lengyhua
 * @date 2017年3月16日
 */
public class VisualCounter {
	private int N;
	private int max;
	private int count;
	private int operCount;
	private Point2D[] points;
	public VisualCounter(int n, int max) {
		super();
		N = n;
		this.max = max;
		points = new Point2D[n];
	}
	
	//加一操作
	public void increment(){
		operCount++;
		count++;
		if(count > Math.abs(max)){
			count = Math.abs(max);
		}
	}
	//减一操作
	public void decrease(){
		operCount++;
		count--;
		if(count<-Math.abs(max)){
			count = -Math.abs(max);
		}
	}
	
	/**
	 * 画出图像
	 * @param ops
	 */
	public void draw(boolean[] ops){
		
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(-Math.abs(max), Math.abs(max));
		StdDraw.setPenColor(Color.RED);
		int len = ops.length;
		while(operCount<N){
			StdDraw.setPenRadius(0.01);
			boolean f = ops[len-1];
			if(len>operCount){
				f = ops[operCount];
			}
			
			StdDraw.point(operCount, count);
			points[operCount] = new Point2D(operCount, count);
			StdDraw.setPenRadius(0.005);
			if(operCount>0)
				StdDraw.line(points[operCount-1], points[operCount]);
			
			if(f){
				increment();
			}else{
				decrease();
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		VisualCounter vc = new VisualCounter(10000,100);
		boolean[] fs = new boolean[10000];
		for(int i=0;i<10000;i++){
			fs[i] = StdRandom.uniform()<0.5;
		}
		vc.draw(fs);
	}
	
}
