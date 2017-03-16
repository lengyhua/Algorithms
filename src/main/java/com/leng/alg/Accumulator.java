package com.leng.alg;

import com.bedpotato.alg4.utils.StdOut;
import com.bedpotato.alg4.utils.StdRandom;

/**
 * 累加器
 * @title Accumulator
 * @author lengyhua
 * @date 2017年3月15日
 */
public class Accumulator {
	
	private double total;
	private int N;
	
	public void addDataValue(double val){
		N++;
		total += val;
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
		
		Accumulator a = new Accumulator();
		for(int i=0;i<1000000;i++){
			a.addDataValue(StdRandom.uniform());
		}
		StdOut.println(a);
		
	}
	
}
