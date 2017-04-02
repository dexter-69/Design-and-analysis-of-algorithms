import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class LargestNumber {
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String []a = new String[n];
		for(int i = 0; i < n; i++) a[i] = scan.next();
		Arrays.sort(a, Collections.reverseOrder());
		for(String s : a) System.out.print(s);
		scan.close();
	}
}
