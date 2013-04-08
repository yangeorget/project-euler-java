package net.yangeorget.eulerproject;

public class PE12 {
    public static void main(final String[] args) {
	long triangle = 0L;
	for (long i = 1L;; i++) {
	    triangle += i;
	    final int count = divisors(triangle);
	    System.out.println(triangle + " " + count);
	    if (500 <= count) {
		return;
	    }
	}
    }

    static int divisors(final long t) {
	int count = 0;
	final long root = (long) Math.sqrt(t);
	for (int i = 1; i < root; i++) {
	    if (t % i == 0) {
		count += 2;
	    }
	}
	if (root * root == t) {
	    count++;
	}
	return count;
    }
}