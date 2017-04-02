import java.util.*;
public class CountDupBs {
	public static void main(String []args) {
		long start_time = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int []a = new int[n];
		for(int i = 0; i < n; i++) a[i] = scan.nextInt();
		int ele = scan.nextInt();
		System.out.println(count(a, n, ele));
		long stop_time = System.currentTimeMillis();
		System.out.println(stop_time - start_time);
		scan.close();
	}
	static int count(int []a, int n, int x) {
		int idx1 = find_first_index(a, 0, n-1, x);
		if(idx1 == -1) return 0;
		int idx2 = find_last_index(a, idx1, n-1, x, n);
		return idx2 - idx1 + 1;
	}
	static int find_first_index(int []a, int low, int high, int x) {
		if(high >= low) {
			int mid = low + (high - low) / 2;
			if((mid == 0 || x > a[mid-1] ) && x == a[mid]) return mid;
			else if( x > a[mid]) return find_first_index(a, (mid + 1), high, x);
			else return find_first_index(a, low, (mid - 1), x);
		}
		return -1;
	}
	static int find_last_index(int []a, int low, int high, int x, int n) {
		if(high >= low) {
			int mid = low + (high - low) / 2;
			if((mid == n-1) || (x < a[mid + 1] && x == a[mid])) return mid;
			else if(x < a[mid]) return find_last_index(a, low, (mid - 1), x, n);
			else return find_last_index(a, (mid + 1), high, x, n);
		}
		return -1;
	}
}
