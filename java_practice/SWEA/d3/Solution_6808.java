package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6808 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int winCnt, loseCnt;
	static List<Integer> yourCards = new ArrayList<>();
	static List<Integer> oppCards = new ArrayList<>();
	static int[] oppSelect = new int[9];
	static boolean[] visited = new boolean[9];
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			init(); 
			sb.append("#").append(i).append(" ");
			bt(0);
			sb.append(winCnt).append(" ").append(loseCnt).append("\n");
			yourCards.clear();
			oppCards.clear();
		}
		System.out.println(sb);
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<9; i++) {
			yourCards.add(Integer.parseInt(st.nextToken()));
		}
		winCnt = 0; loseCnt = 0;
		for(int i=1; i<=18; i++) {
			if(!yourCards.contains(i)) {
				oppCards.add(i);
			}
		}
	}
	
	public static void bt(int cnt) {
		if(cnt == 9) {
			compareCard();
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			oppSelect[cnt] = oppCards.get(i);
			bt(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void compareCard() {
		int sumYou = 0, sumOpp = 0;
		for(int i=0; i<9; i++) {
			int card1 = yourCards.get(i), card2 = oppSelect[i];
			if(card1 > card2) sumYou += card1 + card2;
			else sumOpp += card1 + card2;
		}
		if(sumYou > sumOpp) {
			winCnt++;
		} else if(sumYou < sumOpp) {
			loseCnt++;
		}
	}
}
