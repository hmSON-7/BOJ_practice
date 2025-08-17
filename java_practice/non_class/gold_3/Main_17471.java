package gold_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {

	static int n, minDiff;
	static int[] po, link;
	
	public static void main(String[] args) throws Exception {
		init();
		comb(0, 0, 0);
		System.out.println(minDiff == Integer.MAX_VALUE ?  -1 : minDiff);
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		po = new int[n];
		link = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			po[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				int near = Integer.parseInt(st.nextToken()) - 1;
				link[i] |= 1 << near;
			}
		}
		minDiff = Integer.MAX_VALUE;
	}
	
	static void comb(int idx, int cnt, int bit) {
		if(cnt > (n+1)/2 || idx >= n) return;
		
		bit |= 1<<idx;
		int curPo = bfs(cnt+1, idx, bit);
		if(curPo != -1) {
			int remain = 0;
			for(int i=0; i<n; i++) {
				if((bit & (1<<i)) != 0) continue;
				remain = bfs(n - (cnt+1), i, ~bit);
				break;
			}
			if(remain != -1) {
				minDiff = Math.min(minDiff, Math.abs(curPo - remain));
			}
		}
		comb(idx+1, cnt+1, bit);
		
		bit &= ~(1<<idx);
		comb(idx+1, cnt, bit);
	}
	
	static int bfs(int cnt, int start, int bit) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		int totalPo = 0;
		bit &= ~(1<<start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			totalPo += po[cur];
			cnt--;
			int nextList = link[cur];
			for(int i=0; i<n; i++) {
				if((nextList & (1<<i)) == 0 || (bit & (1<<i)) == 0) continue;
				bit &= ~(1<<i);
				q.add(i);
			}
		}
		
		return cnt == 0 ? totalPo : -1;
	}
	
}
