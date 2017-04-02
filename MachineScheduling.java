import java.util.*;

public class MachineScheduling {
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Jobs []jobs = new Jobs[n];
		for(int i = 0; i < n; i++) {
			jobs[i] = new Jobs(scan.next(), scan.nextInt(), scan.nextInt());
		}
		Arrays.sort(jobs);
		//print(n, jobs);
		System.out.println(jobs[0].count_min_machines(jobs, n));
 	}
	
}

class Jobs implements Comparable<Jobs>{
	public String jobs_name;
	public int start_time, finish_time;
	public int assigned_machine;
	public Jobs(String jobs_name, int start_time, int finish_time) {
		this.jobs_name = jobs_name;
		this.start_time = start_time;
		this.finish_time = finish_time;
		this.assigned_machine = 0;
	}
	@Override
	public int compareTo(Jobs jobs) {
		return this.start_time - jobs.start_time;
	}
	public int count_min_machines(Jobs[] jobs, int n) {
		int count = 0;
		ArrayList<Integer> machines = new ArrayList<Integer>();
		machines.add(this.finish_time);
		String machines_allocated = "";
		machines_allocated += ( "1 " + this.jobs_name + " ");
		for(int i = 1; i < n; i++) {
			Boolean flag = false;
			for(Integer x : machines) {
				if(jobs[i].start_time >= x) {
					machines.add(jobs[i].finish_time);
					machines.remove(x);
					flag = true;
					break;
				}
			}
			if(!flag)
			machines.add(jobs[i].finish_time);
			machines_allocated += (Integer.toString(machines.size()) + " " + jobs[i].jobs_name + " ");
		}
		System.out.println(machines_allocated);
		return machines.size();
	}
}
