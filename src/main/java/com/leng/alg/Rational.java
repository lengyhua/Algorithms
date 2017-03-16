package com.leng.alg;
/**
 * 有理数，通过分子与分母的形式来表示
 * @title Rational
 * @author lengyhua
 * @date 2017年3月16日
 */
public class Rational {
	
	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator) {
		if(denominator==0){
			throw new IllegalArgumentException("Invalid denominator");
		}
		if(numerator!=0){
			int r = Rational.gcd(numerator, denominator);
			numerator /= r;
			denominator /= r;
		}
		
		this.numerator = numerator;
		this.denominator = denominator;
	}
	/**
	 * 加法
	 * @param b
	 * @return
	 */
	public Rational plus(Rational b){
		
		int mul = Rational.mul(this.denominator, b.denominator);
		int x = this.numerator * mul / this.denominator + b.numerator * mul / b.denominator;
		return new Rational(x,mul);
	}
	/**
	 * 减法
	 * @param b
	 * @return
	 */
	public Rational minus(Rational b){
		
		int mul = Rational.mul(this.denominator, b.denominator);
		int x = this.numerator * mul / this.denominator - b.numerator * mul / b.denominator;
		return new Rational(x,mul);
	}
	
	/**
	 * 乘法
	 * @param b
	 * @return
	 */
	public Rational times(Rational b){
		return new Rational(this.numerator*b.numerator,this.denominator*b.denominator);
	}
	/**
	 * 除法
	 * @param b
	 * @return
	 */
	public Rational divides(Rational b){
		if(b.numerator==0){
			throw new IllegalArgumentException("Invalid denominator");
		}
		return new Rational(this.numerator * b.denominator, this.denominator * b.numerator);
	}
	
	/**
	 * 判断相等
	 */
	public boolean equals(Object that){
		if(this==that)
			return true;
		if(that == null)
			return false;
		if(that.getClass() != this.getClass())
			return false;
		Rational r = (Rational) that;
		return (this.numerator == r.numerator) && (this.denominator == r.denominator) || (this.numerator==0 && r.numerator == 0);
		
	}
	
	public String toString(){
		return this.numerator + "/" + this.denominator;
	}
	
	/**
	 * 获取p和q的最大公约数
	 * @param p
	 * @param q
	 * @return
	 */
	private static int gcd(int p,int q){
		
		if(p==0 || q==0)
			return p + q;
		
		int t = p;
		if(p < q){
			p = q;
			q = t;
		}
		int r = p % q;
		return gcd(q,r);
		
	}
	/**
	 * 求p和q的最小公倍数
	 * @param p
	 * @param q
	 * @return
	 */
	private static int mul(int p, int q){
		
		int r = gcd(p,q);
		if(r==0)
			return 0;
		return p*q/r;
	}
	
	public static void main(String[] args) {
		Rational r = new Rational(2, 4);
		Rational r2 = new Rational(1,2);
		System.out.println(r.equals(r2));
	}
	
}
