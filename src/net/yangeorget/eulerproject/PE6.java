package net.yangeorget.eulerproject;

public class PE6 {
    public static void main(String[] args) {
	long s1 = 0L;
	long s2 = 0L;
	for (int i=1; i<=100; i++) {
	    s1 += i;
	    s2 += i*i;
	}
	System.out.println(s1*s1-s2);
    }
}
