package net.yangeorget.eulerproject;

public class PE9 {
    public static void main(String[] args) {
	for (int a = 1; a < 1000-1; a++) {
	    for (int b = a+1; b < 1000; b++) {
		int c2 = a*a + b*b;
		int c = (int) Math.sqrt(c2);
		if (c*c == c2 && a+b+c == 1000) {
		    System.out.println(a*b*c);
		    return;
		}
	    }
	}
    }
}
