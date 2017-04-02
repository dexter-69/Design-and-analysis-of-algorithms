import java.util.Scanner;
import java.util.HashMap;
public class CountDupHashMap {
	public static void main(String []args) {
		long start_time = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = scan.nextInt();
		int val = 0;
		for(int i = 0; i < n; i++) {
			int a = scan.nextInt();
				if(map.containsKey(a)) {
					val = map.get(a);
					map.put(a, ++val);
				}
				else map.put(a, 1);
			}
		
		int query = scan.nextInt();
		System.out.println(map.get(query));
		long stop_time = System.currentTimeMillis();
		System.out.println(stop_time - start_time);
		scan.close();
	}
}
