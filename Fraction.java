import java.util.*;

public class Fraction{
	private int numerator = 0;
	private int denominator = 0;
	
	public Fraction(int numerator, int denominator) throws IllegalArgumentException{
		if(denominator == 0){
			throw new IllegalArgumentException("Denominator can not be zero");
		}
		if(denominator < 0){
			numerator *= -1;
			denominator *= -1;
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public Fraction(int numerator){
		this(numerator, 1);
	}
	public Fraction(){
		this.numerator = 0;
		this.denominator =1;
	}
	public int getNumerator(){
		return numerator;
	}
	public int getDenominator(){
		return denominator;
	}
	public String toString(){
		return numerator+"/"+denominator;
	}
	public double toDouble(){
		return (double)numerator/denominator;
	}
	public Fraction add(Fraction other){
		int num = (numerator*other.denominator) + (other.numerator*denominator);
		int den = (denominator * other.denominator);
		return new Fraction(num,den);
	}
	public Fraction subtract(Fraction other){
		int num = (numerator*other.denominator) - (other.numerator*denominator);
		int den = (denominator * other.denominator);
		return new Fraction(num,den);
	}
	public Fraction multiply(Fraction other){
		int num = numerator * other.numerator;
		int den = denominator * other.denominator;
		return new Fraction(num,den);
	}
	public Fraction divide(Fraction other){
		int num = numerator * other.denominator;
		int den = denominator * other.numerator;
		return new Fraction(num,den);
	}
	public boolean equals(Object other){
		if(!(other instanceof Fraction)){
			return false;
		}
		return ((Fraction) other).toDouble() == toDouble();
	}
	public Fraction toLowestTerms(){
		int gcd = gcd(numerator, denominator);
		numerator = numerator/gcd;
		denominator = denominator/gcd;
		return new Fraction(numerator, denominator);
	}
	public static int gcd(int num, int den){
		while(den > 0){
			int temp = den;
			den = num % den;
			num = temp;
		}
		return num;
	}
}