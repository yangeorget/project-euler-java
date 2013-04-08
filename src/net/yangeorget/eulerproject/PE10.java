package net.yangeorget.eulerproject;

public class PE10 {
    static int MAX = 2000000;
    static boolean[] notprime = new boolean[MAX];

    public static void main(final String[] args) {
	primes();
	long val = 0L;
	for (int i = 2; i < MAX; i++) {
	    if (!notprime[i]) {
		val += i;
	    }
	}
	System.out.println(val);
    }

    static void primes() {
	notprime[0] = true;
	notprime[1] = true;
	notprime[2] = false;
	notprime[3] = false;
	for (int i = 2; i < MAX; i++) {
	    for (int k = 2; k * i < MAX; k++) {
		notprime[k * i] = true;
	    }
	}
	for (int i = 0; i < 100; i++) {
	    System.out.println(notprime[i]);
	}
    }
}
