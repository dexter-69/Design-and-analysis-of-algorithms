import java.util.*;
import java.io.*;
public class WriteNumbers {
	public static void main(String []args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("C:\\Users\\balra\\Desktop\\numbers.txt"); 
		pw.print(" "); //Reset File Content to null
		pw.close(); //Close the file
		File out = new File("C:\\Users\\balra\\Desktop\\numbers.txt");
		FileWriter fw = null;
		int n = 10000;
		try {
			fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			Random random = new Random();
			int num;
			while(n --> 0) {
				num = random.nextInt(20000);
				bw.write(Integer.toString(num));
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
