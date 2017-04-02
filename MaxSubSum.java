import java.util.Scanner;
public class MaxSubSum {
	static int getMaxSubsetSum(int [] values, int n) {
		int curr_sum = values[0], max_sum = values[0];
		for(int i = 1; i < n; i++) {
			curr_sum = Math.max(values[i], curr_sum + values[i]);
			max_sum = Math.max(max_sum, curr_sum);
		}
		return max_sum;
	}
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] val = new int[n];
		for(int i = 0; i < n; i++) val[i] = scan.nextInt();
		System.out.println(getMaxSubsetSum(val, n));
	}
}
