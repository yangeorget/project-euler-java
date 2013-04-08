package net.yangeorget.eulerproject;

public class PE23 {
    static boolean[] abundant = new boolean[28124];

    public static void main(final String[] args) {

	for (int i = 2; i < abundant.length; i++) {
	    abundant[i] = abundant(i);
	}
	System.out.println("init ok");
	long sum = 0;
	for (int i = 1; i < abundant.length; i++) {
	    if (!sumabundants(i)) {
		sum += i;
	    }
	}
	System.out.println(sum);
    }

    static boolean sumabundants(final int j) {
	for (int i = 2; i < j; i++) {
	    if (abundant[i] && abundant[j - i]) {
		return true;
	    }
	}
	return false;
    }

    static boolean abundant(final int i) {
	return divsum(i) > i;
    }

    static int divsum(final int i) {
	int sum = 0;
	for (int j = 1; j < i; j++) {
	    if (i % j == 0) {
		sum += j;
	    }
	}
	return sum;
    }
}