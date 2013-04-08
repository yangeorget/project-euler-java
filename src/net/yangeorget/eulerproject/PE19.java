package net.yangeorget.eulerproject;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PE19 {
    public static void main(final String[] args) {
	int c = 0;
	for (int y = 1901; y <= 2000; y++) {
	    for (int m = 0; m < 12; m++) {
		c += new GregorianCalendar(y, m, 1).get(Calendar.DAY_OF_WEEK) == 1 ? 1
			: 0;
	    }
	}
	System.out.println(c);
    }
}