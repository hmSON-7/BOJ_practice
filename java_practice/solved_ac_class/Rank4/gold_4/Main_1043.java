package Rank4.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1043 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	// 사람 수, 이야기할 파티 수
	static int n, p, known;
	// 최상위 노드 배열
	static int[] arr;
	// 거짓말을 할 수 있는 파티 리스트
	static List<List<Integer>> pList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		init();
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			List<Integer> members = new ArrayList<>();
			members.add(first);
			boolean flag = false;
			for(int j=1; j<cnt; j++) {
				int x = Integer.parseInt(st.nextToken());
				members.add(x);
				union(first, x);
				if(find(x) == 0) flag = true;
			}
			
			if(!flag) {
				pList.add(members);
			}
		}
		
		if(known == 0) {
			System.out.println(p);
		} else {
			int pCnt = 0;
			for(List<Integer> pl : pList) {
				boolean flag = false;
				for(int member : pl) {
					if(find(member) == 0) {
						flag = true; break;
					}
				}
				if(!flag) pCnt++;
			}
			System.out.println(pCnt);
		}
	}
	
	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
		// 진실을 아는 사람을 분류하기
		// 진실을 아는 사람의 최상위 노드를 0으로 분류
		st = new StringTokenizer(br.readLine());
		known = Integer.parseInt(st.nextToken());
		for(int i=0; i<known; i++) {
			int k = Integer.parseInt(st.nextToken());
			arr[k] = 0;
		}
	}
	
	static int find(int x) {
		if(arr[x] == x) return x;
		return arr[x] = find(arr[x]);
	}
	
	static void union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		// 거짓말을 알아챌 수 있는 사람을 0으로 분류
		// 따라서 가급적 작은 노드를 최상위 노드로 세우면 진실을 아는 사람과 같은 파티가 되는 것으로 0번째 노드를 공유
		if(rootA < rootB) {
			arr[rootB] = rootA;
		} else {
			arr[rootA] = rootB;
		}
	}

}
