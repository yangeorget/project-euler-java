package net.yangeorget.eulerproject;

public class PE24 {
    public static void main(final String[] args) {
	int num = 0;
	for (int a = 0; a < 10; a++) {
	    for (int b = 0; b < 10; b++) {
		if (b != a) {
		    for (int c = 0; c < 10; c++) {
			if (c != a && c != b) {
			    for (int d = 0; d < 10; d++) {
				if (d != a && d != b && d != c) {
				    for (int e = 0; e < 10; e++) {
					if (e != a && e != b && e != c
						&& e != d) {
					    for (int f = 0; f < 10; f++) {
						if (f != a && f != b && f != c
							&& f != d && f != e) {
						    for (int g = 0; g < 10; g++) {
							if (g != a && g != b
								&& g != c
								&& g != d
								&& g != e
								&& g != f) {
							    for (int h = 0; h < 10; h++) {
								if (h != a
									&& h != b
									&& h != c
									&& h != d
									&& h != e
									&& h != f
									&& h != g) {
								    for (int i = 0; i < 10; i++) {
									if (i != a
										&& i != b
										&& i != c
										&& i != d
										&& i != e
										&& i != f
										&& i != g
										&& i != h) {
									    for (int j = 0; j < 10; j++) {
										if (j != a
											&& j != b
											&& j != c
											&& j != d
											&& j != e
											&& j != f
											&& j != g
											&& j != h
											&& j != i) {
										    num++;
										    if (num == 1000000) {
											System.out
											.println(a
												+ ""
												+ b
												+ ""
												+ c
												+ ""
												+ d
												+ ""
												+ e
												+ ""
												+ f
												+ ""
												+ g
												+ ""
												+ h
												+ ""
												+ i
												+ ""
												+ j
												+ "");
											return;
										    }
										}
									    }
									}
								    }
								}
							    }
							}
						    }
						}
					    }
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}
    }
}