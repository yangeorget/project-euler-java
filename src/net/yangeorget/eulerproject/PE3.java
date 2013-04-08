package net.yangeorget.eulerproject;

public class PE3 {
    static int MAX = 100000000;
    static boolean[] notprime = new boolean[MAX];

    public static void main(String[] args) {
	long val = 600851475143L;
	int max = -1;
	for (int i = 2; i<MAX; i++) {
	    if (!notprime[i] && val%i == 0) {
		if (i > max) {
		    max = i;
		}
		val /= i;
	    }
	}
	System.out.println(max);
    }

    static void primes() {
	notprime[0] = true;
	notprime[1] = true;
	for (int i=2; i<MAX; i++) {
	    for (int k=2; k*i<MAX; k++) {
		notprime[k*i] = true;
	    }
	}
    }
}
