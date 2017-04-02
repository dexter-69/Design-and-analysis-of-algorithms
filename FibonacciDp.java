import java.util.Scanner;
public class FibonacciDp {
	static int getFib(int [] fib, int x) {
		for(int i = 2; i < fib.length; i++)
			fib[i] = fib[i - 1] + fib[i - 2];
		return fib[x];
	}
	public static void main(String []args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter a number");
	int n = scan.nextInt();
	if(n == 0) { //Handle the 0 input
		System.out.println(0);
		System.exit(0);
	}
	int [] fib = new int[n + 1];
	fib[0] = 0;
	fib[1] = 1;
	System.out.println(getFib(fib, n));
	scan.close();
	}
}