package silver_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014 {
	
	static int maxFloor, start, goal, up, down;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		maxFloor = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		
		if(start == goal) {
			System.out.println(0);
			return;
		}
		
		visited = new boolean[maxFloor+1];
		
		bfs();
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start, 0});
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curFloor = cur[0], curTime = cur[1];
			
			int nextUp = curFloor + up;
			int nextDown = curFloor - down;
			if(nextUp == goal || nextDown == goal) {
				System.out.println(curTime + 1);
				return;
			}
			if(nextUp <= maxFloor && !visited[nextUp]) {
				visited[nextUp] = true;
				q.add(new int[] {nextUp, curTime+1});
			}
			if(nextDown > 0 && !visited[nextDown]) {
				visited[nextDown] = true;
				q.add(new int[] {nextDown, curTime+1});
			}
		}
		
		System.out.println("use the stairs");
	}

}
