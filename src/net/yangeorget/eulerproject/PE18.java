package net.yangeorget.eulerproject;

public class PE18 {

    static int[][] t = { { 75 }, { 95, 64 }, { 17, 47, 82 },
	{ 18, 35, 87, 10 }, { 20, 04, 82, 47, 65 },
	{ 19, 01, 23, 75, 03, 34 }, { 88, 02, 77, 73, 07, 63, 67 },
	{ 99, 65, 04, 28, 06, 16, 70, 92 },
	{ 41, 41, 26, 56, 83, 40, 80, 70, 33 },
	{ 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 },
	{ 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 },
	{ 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 },
	{ 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
	{ 63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
	{ 04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23 } };

    public static void main(final String[] args) {
	for (int i = 1; i < t.length; i++) {
	    t[i][0] += t[i - 1][0];
	    for (int j = 1; j < t[i].length - 1; j++) {
		t[i][j] += Math.max(t[i - 1][j - 1], t[i - 1][j]);
	    }
	    t[i][t[i].length - 1] += t[i - 1][t[i].length - 2];
	}
	int max = 0;
	for (int j = 0; j < t[t.length - 1].length; j++) {
	    max = Math.max(max, t[t.length - 1][j]);
	}
	System.out.println(max);
    }
}
