package net.yangeorget.eulerproject;

public class PE28 {
    public static void main(final String[] args) {
	System.out.println(d(0));
	System.out.println(d(1));
	System.out.println(d(2));
	System.out.println(d(500));
    }

    static int d(final int n) {
	int r = 1;
	for (int i = 0; i < n; i++) {
	    r += 16 * i * i + 36 * i + 24;
	}
	return r;
    }
}