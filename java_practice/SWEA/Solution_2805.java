import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_2805 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, dist;
	static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init(); solve(i);
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		dist = n/2;
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
	}
	
	public static void solve(int idx) {
		int harvest = 0;
		sb.append("#").append(idx).append(" ");
		q.add(new int[] {dist, dist, 0});
		visited[dist][dist] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int y = curr[0], x = curr[1], currDist = curr[2];
			harvest += map[y][x];
			if(currDist >= dist) continue;
			for(int i=0; i<4; i++) {
				int newY = y + dy[i];
				int newX = x + dx[i];
				if(visited[newY][newX]) continue;
				visited[newY][newX] = true;
				q.add(new int[] {newY, newX, currDist+1});
			}
		}
		
		sb.append(harvest).append("\n");
	}
}
