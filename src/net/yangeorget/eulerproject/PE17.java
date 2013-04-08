package net.yangeorget.eulerproject;

public class PE17 {
    public static void main(final String[] args) {
	final int[] c = new int[1001];
	c[0] = 0;
	c[1] = 3;
	c[2] = 3;
	c[3] = 5;
	c[4] = 4;
	c[5] = 4;
	c[6] = 3;
	c[7] = 5;
	c[8] = 5;
	c[9] = 4;
	c[10] = 3;
	c[11] = 6;
	c[12] = 6;
	c[13] = 8;
	c[14] = 8;
	c[15] = 7;
	c[16] = 7;
	c[17] = 9;
	c[18] = 8;
	c[19] = 8;
	c[20] = 6;
	c[30] = 6;
	c[40] = 5;
	c[50] = 5;
	c[60] = 5;
	c[70] = 7;
	c[80] = 6;
	c[90] = 6;
	for (int d = 2; d <= 9; d++) {
	    for (int u = 1; u <= 9; u++) {
		c[d * 10 + u] = c[d * 10] + c[u];
	    }
	}
	for (int h = 1; h <= 9; h++) {
	    c[h * 100] = c[h] + 7;
	}
	for (int h = 1; h <= 9; h++) {
	    for (int d = 0; d <= 9; d++) {
		for (int u = 0; u <= 9; u++) {
		    if (u > 0 || d > 0) {
			c[h * 100 + d * 10 + u] = c[h * 100] + 3
				+ c[d * 10 + u];
		    }
		}
	    }
	}
	c[1000] = 11;
	int sum = 0;
	for (int i = 1; i <= 1000; i++) {
	    if (c[i] == 0) {
		throw new RuntimeException("" + i);
	    }
	    sum += c[i];
	}
	System.out.println(c[87] - "eightyseven".length());
	System.out.println(c[115] - "onehundredandfifteen".length());
	System.out.println(c[342] - "threehundredandfortytwo".length());
	System.out.println(sum);
    }
}