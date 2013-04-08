package net.yangeorget.eulerproject;

public class PE354 {
    static double SQRT3 = Math.sqrt(3.0);
    static boolean[] notprimes = new boolean[35000000]; // lmax/sqrt(3)/7/7/13/13

    public static void main(final String[] args) {
	final int max = (int) Math.sqrt(notprimes.length);
	for (int i = 2; i <= max; i++) {
	    final int jMax = notprimes.length / i;
	    for (int j = 2; j < jMax; j++) {
		notprimes[i * j] = true;
	    }
	}

	// System.out.println(count(15, 1));
	run();
    }

    public static void tests() {
	primes3();
	solve3(111111111 / 3, 9, true);
	// final long kMax = 157338;
	// for (long k = kMax; k >= 1; k -= 1) {
	// solve3(k, 75, false);
	// }
	// 157339 is the smallest k st solve3(k, 75, true)
	solve3(19L * 13 * 13 * 7 * 7, 75, true);
	solve3(7L * 7, 5, true);
	solve3(7L * 7 * 5, 5, true);
	solve3(7L * 7 * 5 * 5, 5, true);
	solve3(7L * 7 * 3, 5, true);
	solve3(7L * 7 * 3 * 3, 5, true);
	solve3(7L * 7 * 3 * 3 * 3, 5, true);
	solve3(7L * 7 * 11 * 11, 5, true);
	solve3(7L * 7 * 17 * 17, 5, true);
	solve3(7L * 7 * 11 * 17, 5, true);
	solve3(7L * 13 * 13 * 11 * 71, 15, true);
	solve3(7L * 7 * 13 * 13 * 11 * 71, 25, true);
	solve3(7L * 7 * 7 * 13 * 13 * 11 * 71, 35, true);
	solve3(7L * 7 * 7 * 7 * 13 * 13 * 11 * 71, 45, true);
	solve3(7L * 7 * 7 * 7 * 7 * 7 * 13 * 13 * 11 * 71, 65, true);
	solve3(7L * 7 * 23 * 23, 5, true);
	solve3(7L * 7 * 7 * 7 * 7 * 7 * 7 * 13 * 13, 75, true);

	solve3(7L * 7 * 7 * 7 * 7 * 7 * 7 * 13 * 13 * 71 * 11, 75, true);
	solve3(7L * 7 * 7 * 7 * 7 * 7 * 7 * 13 * 13 * 71, 75, true);
	solve3(7L * 7 * 7 * 7 * 7 * 7 * 7 * 13 * 13 * 71 * 71, 75, true);
	solve3(7L * 7 * 7 * 7 * 7 * 7 * 7 * 13 * 13 * 71 * 71 * 71, 75, true);
	solve3(7L * 13 * 13 * 19 * 19 * 617 * 71 * 71, 75, true);
    }

    /**
     * If k prime and k=6l+1 then solve3(k, 3, true).
     */
    public static void primes3() {
	solve3(1, 1, true);
	solve3(2, 1, true);
	solve3(3, 1, true);
	solve3(5, 1, true);
	solve3(7, 3, true);
	solve3(11, 1, true);
	solve3(13, 3, true);
	solve3(17, 1, true);
	solve3(19, 3, true);
	solve3(23, 1, true);
	solve3(29, 1, true);
	solve3(31, 3, true);
	solve3(37, 3, true);
	solve3(41, 1, true);
	solve3(43, 3, true);
	solve3(47, 1, true);
	solve3(53, 1, true);
	solve3(59, 1, true);
	solve3(61, 3, true);
	solve3(67, 3, true);
	solve3(71, 1, true);
    }

    public static void run() {

	// for (int i=0; i<primes.length; i++) {
	// if (primes[i]) System.out.println(i);
	// }
	// System.out.println("counting " + count(10));
	final long max = 500000000000L;
	final long count1 = count((long) (max / Math.sqrt(3)));
	System.out.println("counting (1) " + count1);
	final long count3 = count(max / 3);
	System.out.println("counting (3) " + count3);
	System.out.println("counting (1+3) " + (count1 + count3));
    }

    public static long count(final long kMax) {
	System.out.println("counting for kMax " + kMax);
	long count = 0;
	System.out.println("counting alpha^12*beta");
	// 25*3
	// alpha^12*beta
	// alpha < beta
	for (long alpha = 7; alpha < 13; alpha += 6) {
	    if (prime(alpha)) {
		final long alpha12 = alpha * alpha * alpha * alpha * alpha
			* alpha * alpha * alpha * alpha * alpha * alpha * alpha;
		final long kMaxByAlpha12 = kMax / alpha12;
		for (long beta = alpha + 6; beta <= kMaxByAlpha12; beta += 6) {
		    if (prime(beta)) {
			count += count(kMax, alpha12 * beta);
		    }
		}
	    }
	}
	System.out.println("counting alpha^7*beta^2");
	// 15*5
	// alpha^7*beta^2
	// alpha < beta
	for (long alpha = 7; alpha < 51; alpha += 6) {
	    if (prime(alpha)) {
		final long alpha7 = alpha * alpha * alpha * alpha * alpha
			* alpha * alpha;
		final long kMaxByAlpha7 = kMax / alpha7;
		for (long beta = alpha + 6; beta * beta <= kMaxByAlpha7; beta += 6) {
		    if (prime(beta)) {
			count += count(kMax, alpha7 * beta * beta);
		    }
		}
	    }
	}
	System.out.println("counting alpha^7*beta^2");
	// alpha > beta
	for (long beta = 7; beta < 51; beta += 6) {
	    if (prime(beta)) {
		final long beta2 = beta * beta;
		final long kMaxByBeta2 = kMax / beta2;
		for (long alpha = beta + 6; alpha * alpha * alpha * alpha
			* alpha * alpha * alpha <= kMaxByBeta2; alpha += 6) {
		    if (prime(alpha)) {
			count += count(kMax, alpha * alpha * alpha * alpha
				* alpha * alpha * alpha * beta2);
		    }
		}
	    }
	}
	System.out.println("counting alpha^2*beta^2*gamma^1");
	// 5*5*3
	// alpha^2*beta^2*gamma^1
	// alpha < beta < gamma
	for (long alpha = 7; alpha < 230; alpha += 6) {
	    if (prime(alpha)) {
		final long alpha2 = alpha * alpha;
		final long kMaxByAlpha2ByGammaMin = kMax
			/ (alpha2 * (alpha + 12));
		for (long beta = alpha + 6; beta * beta <= kMaxByAlpha2ByGammaMin; beta += 6) {
		    if (prime(beta)) {
			final long alpha2beta2 = alpha2 * beta * beta;
			final long kMaxByAlpha2Beta2 = kMax / alpha2beta2;
			for (long gamma = beta + 6; gamma <= kMaxByAlpha2Beta2; gamma += 6) {
			    if (prime(gamma)) {
				count += count(kMax, alpha2beta2 * gamma);
			    }
			}
		    }
		}
	    }
	}
	System.out.println("counting alpha^2*beta^2*gamma^1");
	// alpha < gamma < beta
	for (long alpha = 7; alpha < 230; alpha += 6) {
	    if (prime(alpha)) {
		final long alpha2 = alpha * alpha;
		final long kMaxByAlpha2ByBetaMin2 = kMax
			/ (alpha2 * (alpha + 12) * (alpha + 12));
		for (long gamma = alpha + 6; gamma <= kMaxByAlpha2ByBetaMin2; gamma += 6) {
		    if (prime(gamma)) {
			final long alpha2gamma = alpha2 * gamma;
			final long kMaxByAlpha2Gamma = kMax / alpha2gamma;
			for (long beta = gamma + 6; beta * beta <= kMaxByAlpha2Gamma; beta += 6) {
			    if (prime(beta)) {
				count += count(kMax, alpha2gamma * beta * beta);
			    }
			}
		    }
		}
	    }
	}
	System.out.println("counting alpha^2*beta^2*gamma^1");
	// gamma < alpha < beta
	for (long gamma = 7; gamma < 230; gamma += 6) {
	    if (prime(gamma)) {
		final long kMaxByGammaByBetaMin2 = kMax
			/ (gamma * (gamma + 12) * (gamma + 12));
		for (long alpha = gamma + 6; alpha * alpha <= kMaxByGammaByBetaMin2; alpha += 6) {
		    if (prime(alpha)) {
			final long alpha2gamma = alpha * alpha * gamma;
			final long kMaxByAlpha2Gamma = kMax / alpha2gamma;
			for (long beta = alpha + 6; beta * beta <= kMaxByAlpha2Gamma; beta += 6) {
			    if (prime(beta)) {
				count += count(kMax, alpha2gamma * beta * beta);
			    }
			}
		    }
		}
	    }
	}
	return count;
    }

    static boolean prime(final long a) {
	return !notprimes[(int) a];
    }

    // public static long count(final long kMax, final long product) {
    // final List lists = new ArrayList();
    // if (product <= kMax) {
    // lists.add(Collections.EMPTY_LIST);
    // enumerate(2, kMax, product, Collections.EMPTY_LIST, lists);
    // }
    // // System.out.println(lists);
    // return lists.size();
    // }
    //
    // public static void enumerate(final int prime, final long kMax,
    // final long product, final List prefix, final List lists) {
    // System.out.println(prime + " " + kMax);
    // if (prime != 0 && prime * product <= kMax) {
    // for (int p = 1; p * product <= kMax; p *= prime) {
    // final List newPrefix = new ArrayList<>(prefix);
    // newPrefix.add(p);
    // lists.add(newPrefix);
    // enumerate(nextPrime(prime), kMax, product * p, newPrefix, lists);
    // }
    // }
    // }

    public static long count(final long kMax, final long product) {
	final long[] count = new long[1];
	if (product <= kMax) {
	    count[0] = 1;
	    // enumerate(2, kMax, product, Collections.EMPTY_LIST, lists);
	    enumerate(2, kMax, product, count);
	}
	// System.out.println(lists);
	return count[0];
    }

    public static void enumerate(final long prime, final long kMax,
	    final long product, final long[] count) {
	// System.out.println(prime + " " + kMax);
	if (prime != 0 && prime * product <= kMax) {
	    enumerate(nextPrime(prime), kMax, product, count);
	    for (long p = prime; p * product <= kMax; p *= prime) {
		count[0]++;
		enumerate(nextPrime(prime), kMax, product * p, count);
	    }
	}
    }

    private static long nextPrime(final long i) {
	if (i == 2L) {
	    return 3L;
	}
	if (i == 3L) {
	    return 5L;
	}
	for (long nextPrime = i + 6; nextPrime < notprimes.length; nextPrime += 6) {
	    if (prime(nextPrime)) {
		return nextPrime;
	    }

	}
	return 0L;
    }

    /**
     * (x,y) solution of solve1 iff (x+2*y, x-y) solution of solve3.
     */
    static void solve1(final long k, final int targetCount, final boolean shout) {
	/*
	 * final long sMin = k; // s=l/Math.sqrt(3)=k final long sMax = (long)
	 * Math.floor(2 * k / SQRT3); // s=2*l/3=2*k/Math.sqrt(3) solve(1, k,
	 * sMin, sMax, targetCount, shout);
	 */
	// solve3(k, targetCount, shout);
    }

    static void solve3(final long k, final int targetCount, final boolean shout) {
	final long sMin = (long) Math.ceil(k * SQRT3); // s=l/Math.sqrt(3)=k*Math.sqrt(3);
	final long sMax = 2 * k; // s=2*l/3=2*k
	solve3(k, sMin, sMax, targetCount, shout);
    }

    static void solve3(final long k, final long sMin, final long sMax,
	    int targetCount, final boolean shout) {
	// System.out.println("solving k=" + k);
	// is delta2=4*l*l/3-3*s*s a perfect square?
	long delta2 = 0; // do we need to compute this?
	long delta2Inc = 6 * sMax - 3; // delta2Inc=-3*(-2*s+1)
	long remainder = 0;
	long j = 1;
	for (long it = sMax - sMin; it >= 0; it--) {
	    while (remainder > 0) {
		remainder -= j;
		j += 2;
	    }
	    if (remainder == 0) {
		// Math.sqrt(delta2);
		// Math.sqrt((12 * k * k - delta2) / 3);
		// System.out.println("x=" + x + ", y=" + y + ", delta2=" +
		// delta2
		// + ", delta2inc=" + delta2Inc + ", j=" + j);
		if (delta2 == 0) {
		    targetCount--;
		} else {
		    targetCount -= 2;
		}
		if (targetCount < 0) {
		    if (shout) {
			throw new RuntimeException("too many solutions ");
		    } else {
			return;
		    }
		}
	    }
	    delta2 += delta2Inc;
	    remainder += delta2Inc;
	    delta2Inc -= 6;
	}
	if (targetCount > 0) {
	    if (shout) {
		throw new RuntimeException(
			"not enough solutions, remaining to be found "
				+ targetCount);
	    } else {
		return;
	    }
	}
	System.out.println("k=" + k + ": ok");
    }
}