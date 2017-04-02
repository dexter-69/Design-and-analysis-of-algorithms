import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class SortingComparisions {
	public static void quickSort(int arr[], int low, int high) 
    {
        int i = low, j = high;
        int temp;
        int pivot = arr[(low + high) / 2];
 
        /** partition **/
        while (i <= j) 
        {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                /** swap **/
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
 
                i++;
                j--;
            }
        }
 
        /** recursively sort lower half **/
        if (low < j)
            quickSort(arr, low, j);
        /** recursively sort upper half **/
        if (i < high)
            quickSort(arr, i, high);
    }
	
	/*Merge Sort*/
	public static void mergeSort(int[] a, int low, int high) 
    {
        int N = high - low;         
        if (N <= 1) 
            return; 
        int mid = low + N/2; 
        mergeSort(a, low, mid); 
        mergeSort(a, mid, high); 
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) 
        {
            if (i == mid)  
                temp[k] = a[j++];
            else if (j == high) 
                temp[k] = a[i++];
            else if (a[j]<a[i]) 
                temp[k] = a[j++];
            else 
                temp[k] = a[i++];
        }    
        for (int k = 0; k < N; k++) 
            a[low + k] = temp[k];         
    }
	public static void fill(int []arr_to_fill) {
		Random random= new Random();
		for(int i = 0; i < 100000; i++) arr_to_fill[i] = random.nextInt(100000);
	}
	public static void print(int []arr) {
		for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void fill_from_file(int []arr) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("C:\\Users\\balra\\Desktop\\numbers.txt"));
		int i = -1;
		while(scan.hasNextInt()) {
			arr[++i] = scan.nextInt();
		}
		scan.close();
	}
	public static void main(String []args) throws FileNotFoundException {
		int []a = new int[100000];
		int []b = new int[10000];
		fill(a);
		long startTime = System.currentTimeMillis();
		mergeSort(a, 0, a.length);
		long stopTime = System.currentTimeMillis();
		System.out.println("Time Taken by MergeSort " + (stopTime - startTime));
		fill_from_file(b);
		startTime = System.currentTimeMillis();
		quickSort(b, 0, b.length - 1);
		stopTime = System.currentTimeMillis();
		System.out.println("Time Taken by QuickSort(Worst Time Complexity) " + (stopTime - startTime));
	}
}
