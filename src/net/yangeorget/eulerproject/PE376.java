package net.yangeorget.eulerproject;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;

import com.koalog.jcs.constraint.BaseProblem;
import com.koalog.jcs.constraint.Problem;
import com.koalog.jcs.constraint.arithmetic.Count;
import com.koalog.jcs.constraint.arithmetic.GCC;
import com.koalog.jcs.constraint.arithmetic.Increasing;
import com.koalog.jcs.constraint.arithmetic.Leq;
import com.koalog.jcs.constraint.arithmetic.LexLeq;
import com.koalog.jcs.constraint.arithmetic.SmallerSum;
import com.koalog.jcs.constraint.bool.And;
import com.koalog.jcs.constraint.bool.And0;
import com.koalog.jcs.constraint.bool.IsSmaller;
import com.koalog.jcs.constraint.bool.IsSmaller_3;
import com.koalog.jcs.constraint.bool.Not;
import com.koalog.jcs.constraint.bool.Or1;
import com.koalog.jcs.solver.DefaultSplitSolver;
import com.koalog.jcs.solver.Solver;
import com.koalog.jcs.variable.BooleanVariable;
import com.koalog.jcs.variable.IntegerVariable;

public class PE376 {

    public static void main(final String[] args) {
	final int max = 30;
	long count = 0L;

	count += 15 * comb(max, 5);
	count += 491 * comb(max, 6);
	count += 6028 * comb(max, 7);
	count += 40974 * comb(max, 8);
	count += 178508 * comb(max, 9);
	count += 535887 * comb(max, 10);
	count += 1152344 * comb(max, 11);
	count += 1808978 * comb(max, 12);
	count += 2082342 * comb(max, 13);
	count += 1741403 * comb(max, 14);
	count += 1030705 * comb(max, 15);
	count += 409596 * comb(max, 16);
	count += 98092 * comb(max, 17);
	count += 10705 * comb(max, 18);

	System.out.println(count);
    }

    public static void run() {
	DOMConfigurator.configure("d:/koalog/BasicLogConfig.xml");
	long count = 0L;
	final int max = 18;
	for (int i = 2; i <= max; i++) {
	    System.out.println("solving " + i);
	    final long t = System.currentTimeMillis();
	    final long lcount = solve(i);
	    final long multi = comb(max, i);
	    count += lcount * multi;
	    System.out.println("count " + count + "=" + lcount + "*" + multi
		    + "(in " + (System.currentTimeMillis() - t) + " ms)");
	}
	System.out.println("total " + count);
    }

    private static long comb(final int n, final int p) {
	if (p == 0) {
	    return 1L;
	}
	return comb(n - 1, p - 1) * n / p;
    }

    public static int solve(final int k) {

	final int[] counter = new int[1];
	final Solver solver = new DefaultSplitSolver(getProblem(k)) {
	    @Override
	    public void solutionFound() {
		counter[0]++;
	    }

	    @Override
	    public void solved() {

	    }
	};
	solver.solve();
	return counter[0];
    }

    public static Problem getProblem(final int k) {
	final Problem p = new BaseProblem();
	final List vars = new LinkedList();
	final IntegerVariable[][] side = new IntegerVariable[3][6];
	for (int d = 0; d < 3; d++) {
	    for (int s = 0; s < 6; s++) {
		side[d][s] = new IntegerVariable(d + "/" + s, 1, k);
		// side[d][s] = new IntegerVariable(d + "/" + s, new
		// SparseDomain(1, k));
	    }
	    p.add(new Increasing(side[d]));
	}

	/*
	 * side[0][0] = new IntegerVariable("0/0", 1); side[0][1] = new
	 * IntegerVariable("0/1", 4); side[0][2] = new IntegerVariable("0/2",
	 * 4); side[0][3] = new IntegerVariable("0/3", 4); side[0][4] = new
	 * IntegerVariable("0/4", 4); side[0][5] = new IntegerVariable("0/5",
	 * 4);
	 * 
	 * side[1][0] = new IntegerVariable("1/0", 2); side[1][1] = new
	 * IntegerVariable("1/1", 2); side[1][2] = new IntegerVariable("1/2",
	 * 2); side[1][3] = new IntegerVariable("1/3", 5); side[1][4] = new
	 * IntegerVariable("1/4", 5); side[1][5] = new IntegerVariable("1/5",
	 * 5);
	 * 
	 * side[2][0] = new IntegerVariable("2/0", 3); side[2][1] = new
	 * IntegerVariable("2/1", 3); side[2][2] = new IntegerVariable("2/2",
	 * 3); side[2][3] = new IntegerVariable("2/3", 3); side[2][4] = new
	 * IntegerVariable("2/4", 3); side[2][5] = new IntegerVariable("2/5",
	 * 6);
	 */

	for (int d = 0; d < 3; d++) {
	    for (int s = 0; s < 6; s++) {
		vars.add(side[d][s]);
	    }
	}

	final IntegerVariable[] varArray = (IntegerVariable[]) vars
		.toArray(new IntegerVariable[0]);
	final int[] low = new int[k];
	for (int j = 0; j < low.length; j++) {
	    low[j] = 1;
	}
	final int[] cap = new int[k];
	for (int j = 0; j < cap.length; j++) {
	    cap[j] = varArray.length - (k - 1);
	}
	final int[] values = new int[k];
	for (int j = 0; j < values.length; j++) {
	    values[j] = j + 1;
	}
	p.add(new GCC(varArray, 1, k, low, cap));
	// p.add(new GCC_SPARSE(varArray, values, 1, varArray.length - (k -
	// 1)));

	final BooleanVariable[][][][] smaller = new BooleanVariable[3][6][3][6];
	for (int d1 = 0; d1 < 2; d1++) {
	    for (int d2 = d1 + 1; d2 < 3; d2++) {
		for (int s1 = 0; s1 < 6; s1++) {
		    for (int s2 = 0; s2 < 6; s2++) {
			smaller[d1][s1][d2][s2] = new BooleanVariable(d1 + "/"
				+ s1 + "<" + d2 + "/" + s2);
			smaller[d2][s2][d1][s1] = new BooleanVariable(d2 + "/"
				+ s2 + "<" + d1 + "/" + s1);
			p.add(new IsSmaller_3(smaller[d1][s1][d2][s2],
				side[d1][s1], side[d2][s2], 0));
			p.add(new IsSmaller_3(smaller[d2][s2][d1][s1],
				side[d2][s2], side[d1][s1], 0));
			p.add(new And0(smaller[d1][s1][d2][s2],
				smaller[d2][s2][d1][s1]));
		    }
		}

	    }
	}

	for (int d1 = 0; d1 < 3; d1++) {
	    for (int d2 = 0; d2 < 3; d2++) {
		if (d1 != d2) {
		    final int d3 = 3 - d2 - d1;
		    for (int s1 = 0; s1 < 6; s1++) {
			for (int s2 = 0; s2 < 6; s2++) {
			    for (int s3 = 0; s3 < 6; s3++) {
				final BooleanVariable b = new BooleanVariable();
				p.add(new And(b, smaller[d1][s1][d2][s2],
					smaller[d2][s2][d3][s3]));
				p.add(new Leq(b, smaller[d1][s1][d3][s3]));
			    }
			}
		    }
		}
	    }
	}

	final IntegerVariable[][] countRightGreater = new IntegerVariable[3][3];
	final BooleanVariable[][] dominatedByRight = new BooleanVariable[3][3];
	for (int d1 = 0; d1 < 2; d1++) {
	    for (int d2 = d1 + 1; d2 < 3; d2++) {
		countRightGreater[d1][d2] = new IntegerVariable(d1
			+ " countRight " + d2, 0, 36);
		p.add(new Count(countRightGreater[d1][d2],
			new BooleanVariable[] { smaller[d1][0][d2][0],
			smaller[d1][0][d2][1], smaller[d1][0][d2][2],
			smaller[d1][0][d2][3], smaller[d1][0][d2][4],
			smaller[d1][0][d2][5], smaller[d1][1][d2][0],
			smaller[d1][1][d2][1], smaller[d1][1][d2][2],
			smaller[d1][1][d2][3], smaller[d1][1][d2][4],
			smaller[d1][1][d2][5], smaller[d1][2][d2][0],
			smaller[d1][2][d2][1], smaller[d1][2][d2][2],
			smaller[d1][2][d2][3], smaller[d1][2][d2][4],
			smaller[d1][2][d2][5], smaller[d1][3][d2][0],
			smaller[d1][3][d2][1], smaller[d1][3][d2][2],
			smaller[d1][3][d2][3], smaller[d1][3][d2][4],
			smaller[d1][3][d2][5], smaller[d1][4][d2][0],
			smaller[d1][4][d2][1], smaller[d1][4][d2][2],
			smaller[d1][4][d2][3], smaller[d1][4][d2][4],
			smaller[d1][4][d2][5], smaller[d1][5][d2][0],
			smaller[d1][5][d2][1], smaller[d1][5][d2][2],
			smaller[d1][5][d2][3], smaller[d1][5][d2][4],
			smaller[d1][5][d2][5],

		}, 1));
		countRightGreater[d2][d1] = new IntegerVariable(d2
			+ " countRightGreater " + d1, 0, 36);
		p.add(new Count(countRightGreater[d2][d1],
			new BooleanVariable[] { smaller[d2][0][d1][0],
			smaller[d2][0][d1][1], smaller[d2][0][d1][2],
			smaller[d2][0][d1][3], smaller[d2][0][d1][4],
			smaller[d2][0][d1][5], smaller[d2][1][d1][0],
			smaller[d2][1][d1][1], smaller[d2][1][d1][2],
			smaller[d2][1][d1][3], smaller[d2][1][d1][4],
			smaller[d2][1][d1][5], smaller[d2][2][d1][0],
			smaller[d2][2][d1][1], smaller[d2][2][d1][2],
			smaller[d2][2][d1][3], smaller[d2][2][d1][4],
			smaller[d2][2][d1][5], smaller[d2][3][d1][0],
			smaller[d2][3][d1][1], smaller[d2][3][d1][2],
			smaller[d2][3][d1][3], smaller[d2][3][d1][4],
			smaller[d2][3][d1][5], smaller[d2][4][d1][0],
			smaller[d2][4][d1][1], smaller[d2][4][d1][2],
			smaller[d2][4][d1][3], smaller[d2][4][d1][4],
			smaller[d2][4][d1][5], smaller[d2][5][d1][0],
			smaller[d2][5][d1][1], smaller[d2][5][d1][2],
			smaller[d2][5][d1][3], smaller[d2][5][d1][4],
			smaller[d2][5][d1][5],

		}, 1));
		dominatedByRight[d1][d2] = new BooleanVariable(d1
			+ " dominatedByRight " + d2);
		dominatedByRight[d2][d1] = new BooleanVariable(d2
			+ " dominatedByRight " + d1);

		p.add(new IsSmaller(dominatedByRight[d2][d1],
			countRightGreater[d1][d2], 19));
		p.add(new IsSmaller(dominatedByRight[d1][d2],
			countRightGreater[d2][d1], 19));

		p.add(new Not(dominatedByRight[d2][d1],
			dominatedByRight[d1][d2]));

		p.add(new SmallerSum(new IntegerVariable[] {
			countRightGreater[d1][d2], countRightGreater[d2][d1] },
			37));
	    }
	}

	p.add(new Or1(dominatedByRight[0][1], dominatedByRight[0][2]));
	p.add(new Or1(dominatedByRight[1][0], dominatedByRight[1][2]));
	p.add(new Or1(dominatedByRight[2][0], dominatedByRight[2][1]));

	p.add(new LexLeq(side[0], side[1]));
	p.add(new LexLeq(side[1], side[2]));
	p.add(new LexLeq(side[0], side[2]));

	p.setVariables(varArray);
	return p;
    }
}
