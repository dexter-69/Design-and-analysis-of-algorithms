import java.util.Scanner;
public class SubsetSum {
	static void findNumbers(int[] list, int index, int current, int goal, String result)
	{ 
	  if (list.length <= index || current>goal) // I've added the "=" which is missing in your code.
	          return;
	  if (current + list[index] == goal)   {
	      System.out.println(result + " " + String.valueOf(list[index]));
	  }
	  	else if (current + list[index] < goal) {
	  		findNumbers(list, index + 1, current + list[index], goal, result + " " + String.valueOf(list[index]));
	  	}
	  	findNumbers(list, index + 1, current, goal, result);
	  	
	}
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] a = new int[n];
		for(int i = 0; i < n; i++) a[i] = scan.nextInt();
		int findit = scan.nextInt();
		String s = "";
		findNumbers(a, 0, 0, findit, s);
		scan.close();
	}
}
