package net.yangeorget.eulerproject;

public class PE21 {
    public static void main(final String[] args) {
	int sum = 0;
	for (int i = 2; i <= 10000; i++) {
	    if (amicable(i)) {
		sum += i;
	    }
	}
	System.out.println(divsum(16));
	System.out.println(divsum(220));
	System.out.println(divsum(284));
	System.out.println(sum);
    }

    static boolean amicable(final int i) {
	final int j = divsum(i);
	return j != i && divsum(j) == i;
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