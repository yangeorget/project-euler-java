package net.yangeorget.eulerproject;

public class PE27 {
	static int MAX = 3000000;
	static boolean[] notprime = new boolean[MAX];

	public static void main(final String[] args) {
		primes();
		int max = 0;
		int amax=0;
		int bmax=0;
		for (int a = -999; a <1000; a++) {
			for (int b= 2; b <1000; b++) {
				if (!notprime[b]) {
					int m = cp(a, b);
					if (m > max) {
						amax = a;
						bmax = b;
						max = m;
						System.out.println(amax + " " + bmax +  " " +max + " "+ (amax*bmax));
					}
				}
			}
		}
		
	}

	static int cp(int a, int b) {
		for (int m = 0;; m++) {
			int v = m*m+a*m+b;
			if (v < 0  || notprime[v]) {
				return m;
			}
		}
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
	}
}