import java.util.Scanner;
public class ZeroOneKnapsack {
	static int knapSack(int wMax, int [] weights, int [] values, int n) {
		int [][] arr = new int[n + 1][wMax + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= wMax; j++) {
				if(i == 0 || j == 0) arr[i][j] = 0;
				else if(weights[i - 1] <= j) arr[i][j] = Math.max(values[i - 1] + arr[i - 1][j - weights[i - 1]], arr[i - 1][j]);
				else arr[i][j] = arr[i - 1][j];
			}
		}
		return arr[n][wMax];
	}
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] weights = new int[n];
		int [] values = new int[n];
		System.out.println("Enter Weights and their respective values");
		for(int i = 0; i < n; i++) {
			weights[i] = scan.nextInt();
			values[i] = scan.nextInt();
		}
		int wMax = scan.nextInt();
		System.out.print(knapSack(wMax, weights, values, n));
		scan.close();
	}
}
