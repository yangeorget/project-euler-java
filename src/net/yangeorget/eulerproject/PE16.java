package net.yangeorget.eulerproject;

import java.math.*;

public class PE16 {
    public static void main(String[] args) {
	String s = BigInteger.ONE.shiftLeft(1000).toString();
	System.out.println(s);
	int sum = 0;
	for (int i=0; i<s.length(); i++) {
	    sum += (s.charAt(i) - '0');
	}
	System.out.println(sum);
    }
}