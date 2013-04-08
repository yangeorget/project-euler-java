package net.yangeorget.eulerproject;

import java.math.*;

public class PE20 {
    public static void main(String[] args) {
	BigInteger f = BigInteger.ONE;
	for (int i=2; i<=100; i++) {
	    f = f.multiply(new BigInteger(new Integer(i).toString()));
	}
	int sum = 0;
	String s = f.toString();
	for (int i=0; i<s.length(); i++) {
	    sum += (s.charAt(i) - '0');
	}
	System.out.println(sum);
    }
}