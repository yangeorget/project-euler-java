package net.yangeorget.eulerproject;

public class PE5 {
    public static void main(String[] args) {
	long min = 20;
	for (long i = 19; i >=2; i--) {
	    if (min % i != 0) {
		min *= i / gcd(min, i);
	    }
	}
	System.out.println(min);
    }

    static long gcd(long a, long b) {
	if (b==0) return a;
	return gcd(b,a%b);
    }
}
