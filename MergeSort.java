import java.io.*;
import java.util.*;
public class MergeSort {
	public static void sort(int[] a, int low, int high) 
    {
        int N = high - low;         
        if (N <= 1) 
            return; 
        int mid = low + N/2; 
        sort(a, low, mid); 
        sort(a, mid, high); 
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) 
        {
            if (i == mid)  
                temp[k] = a[j++];
            else if (j == high) 
                temp[k] = a[i++];
            else if (a[j] < a[i]) 
                temp[k] = a[j++];
            else 
                temp[k] = a[i++];
        }    
        for (int k = 0; k < N; k++) 
            a[low + k] = temp[k];         
    }
	public static void main(String []args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("C:\\Users\\balra\\Desktop\\numbers.txt"));
		int a[] = new int[10000];
		int i = -1;
		while(scan.hasNextInt()) {
			a[++i] = scan.nextInt();
		}
		sort(a, 0, a.length);
		PrintWriter pw = new PrintWriter("C:\\Users\\balra\\Desktop\\numbers.txt");
		pw.print(" ");
		pw.close();
		File out = new File("C:\\Users\\balra\\Desktop\\numbers.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			for(i = 0; i < a.length; i++) {
				bw.write(Integer.toString(a[i]));
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}
}
