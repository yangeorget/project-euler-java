package net.yangeorget.eulerproject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PE26 {
    public static void main(String[] args) {

	System.out.println(cycle(2));
	System.out.println(cycle(3));
	System.out.println(cycle(4));
	System.out.println(cycle(5));
	System.out.println(cycle(6));
	System.out.println(cycle(7));
	System.out.println(cycle(8));
	System.out.println(cycle(9));
	System.out.println(cycle(10));

	int max = 0;
	int maxd = 1;
	for (int d = 2; d<1000; d++) {
	    int o = cycle(d);
	    if (o > max) {
		max = o;
		maxd = d;
	    }
	}

	System.out.println(maxd);
    }

    static int cycle(int d) {
	List remainders = new LinkedList();
	int remainder = 1;
	for (;;) {
	    if (remainder == 0) {
		return 0;
	    } else {
		int idx = remainders.indexOf(remainder);
		if (idx >=0) {
		    return remainders.size() - idx;
		}
	    } 
	    remainders.add(remainder);
	    remainder *= 10;
	    remainder = remainder %d;
	}
    }
}