package silver_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14235 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int state = Integer.parseInt(st.nextToken());
			
			if(state == 0) {
				if(q.isEmpty()) sb.append(-1);
				else sb.append(q.poll());
				sb.append("\n");
				continue;
			}
			
			for(int j=0; j<state; j++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		System.out.println(sb);
	}

}
