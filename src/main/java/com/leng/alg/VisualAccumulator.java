package com.leng.alg;

import com.bedpotato.alg4.utils.StdDraw;
import com.bedpotato.alg4.utils.StdOut;
import com.bedpotato.alg4.utils.StdRandom;

/**
 * 
 * @title VisualAccumulator
 * @author lengyhua
 * @date 2017年3月15日
 */
public class VisualAccumulator {
	
	private double total;
	private int N;
	
	public VisualAccumulator(int trials, double max){
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(0.005);
	}
	
	public void addDataValue(double val){
		N++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
	}
	
	//返回平均值s
	public double mean(){
		return total / N;
	}
	@Override
	public String toString() {
		return "Mean (" + N + " values):" + String.format("%7.5f", mean());
	}
	
	public static void main(String[] args) {
		VisualAccumulator a = new VisualAccumulator(100, 1);
		for(int i=1;i<10000;i++){
			a.addDataValue(StdRandom.uniform());
		}
		StdOut.println(a);
	}
	
}
