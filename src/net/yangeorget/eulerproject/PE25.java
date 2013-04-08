package net.yangeorget.eulerproject;

import java.math.*;

public class PE25 {
    public static void main(String[] args) {
	for (int i=0;; i++) {
	    String s = fibo(i).toString();
	    if (s.length() == 1000) {
		System.out.println(i);
		return;
	    }
	}
    }

    static BigInteger fibo(int n) {
	if (n==1) return BigInteger.ONE;
	if (n==2) return BigInteger.ONE;
	BigInteger a = BigInteger.ONE;
	BigInteger b = BigInteger.ONE;
	BigInteger f = BigInteger.ZERO;
	for (int i=3; i<=n; i++) {
	    f = a.add(b);
	    a = b;
	    b = f;
	}
	return f;
    }
}