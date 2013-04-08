package net.yangeorget.eulerproject;

public class PE14 {
    public static void main(final String[] args) {
	int max = 0;
	int imax = 0;
	for (int i = 1; i <= 1000000; i++) {
	    final int length = length(i);
	    // System.out.println(i + " " + length);
	    if (length > max) {
		max = length;
		imax = i;
	    }
	}
	System.out.println(imax);
    }

    static int length(long n) {
	int length = 1;
	while (n != 1) {
	    length++;
	    if (n % 2 == 0) {
		n = n / 2;
	    } else {
		n = 3 * n + 1;
	    }
	}
	return length;
    }
}