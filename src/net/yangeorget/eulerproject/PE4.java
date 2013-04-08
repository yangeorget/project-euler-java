package net.yangeorget.eulerproject;

public class PE4 {
    public static void main(String[] args) {
	int max = 0;
	for (int i=111; i<1000;i++)
	    for (int j = i; j<1000; j++)
	    {
		int n = i*j;
		if (palindrome(n) && n > max) {
		    max = n;
		}
	    }
	System.out.println(max);
    }

    static boolean palindrome(int n) {
	String s = Integer.toString(n);
	if (n < 100000) {
	    return s.charAt(0) == s.charAt(4) 
		    && s.charAt(1) == s.charAt(3);
	} else {
	    return s.charAt(0) == s.charAt(5) 
		    && s.charAt(1) == s.charAt(4) 
		    && s.charAt(2) == s.charAt(3);
	}
    }
}
