package net.yangeorget.eulerproject;

public class PE7 {
    static int MAX = 1000000000;
    static boolean[] notprime = new boolean[MAX];

    public static void main(String[] args) {
	primes();
	int j = 0;
	for (int i = 0; i<MAX; i++) {
	    if (!notprime[i]) {
		j++;
		if (j == 10001) {
		    System.out.println(i);
		    return;
		}
	    }
	}
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
