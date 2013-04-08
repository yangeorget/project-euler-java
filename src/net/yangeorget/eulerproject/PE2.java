package net.yangeorget.eulerproject;

public class PE2 {
    public static void main(String[] args) {
	int sum = 0;
	int i = 0;
	int f;
	while ((f = fibo(i)) <= 4000000) {
	    if (f%2 == 0) {
		sum += f;
	    }
	    i++;
	}
	System.out.println(sum);
    }

    static int fibo(int n) {
	if (n==0) return 1;
	if (n==1) return 2;
	int a = 1;
	int b = 2;
	int f = 0;
	for (int i=2; i<=n; i++) {
	    f = a + b;
	    a = b;
	    b = f;
	}
	return f;
    }
}