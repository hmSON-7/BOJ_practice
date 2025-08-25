package Rank4.gold_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1043 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	// ��� ��, �̾߱��� ��Ƽ ��
	static int n, p, known;
	// �ֻ��� ��� �迭
	static int[] arr;
	// �������� �� �� �ִ� ��Ƽ ����Ʈ
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
		
		// ������ �ƴ� ����� �з��ϱ�
		// ������ �ƴ� ����� �ֻ��� ��带 0���� �з�
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
		// �������� �˾�ç �� �ִ� ����� 0���� �з�
		// ���� ������ ���� ��带 �ֻ��� ���� ����� ������ �ƴ� ����� ���� ��Ƽ�� �Ǵ� ������ 0��° ��带 ����
		if(rootA < rootB) {
			arr[rootB] = rootA;
		} else {
			arr[rootA] = rootB;
		}
	}

}
