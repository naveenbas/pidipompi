package practice;

import java.io.IOException;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.print("Enter number: ");
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.print(fib(i) + " ");
		}
	}

	static int fib(int n) {
		
		if (n == 1 || n == 2 || n == 3)
			return n;
		else
			return fib(n-1) + fib(n-2);
	}
}
