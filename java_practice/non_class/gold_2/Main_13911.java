package gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13911 {
	
	static int v, e, macLimit, starLimit;
	static int[] macDist, starDist;
	static List<List<Node>> list = new ArrayList<>();
	static HashSet<Integer> macList = new HashSet<>();
	static HashSet<Integer> starList = new HashSet<>();
	
	static class Node {
		int id, cost;
		
		public Node(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(dijkstra());
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		for(int i=0; i<v; i++) {
			list.add(new ArrayList<>());
		}
		macDist = new int[v];
		starDist = new int[v];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(new Node(v2, w));
			list.get(v2).add(new Node(v1, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int macN = Integer.parseInt(st.nextToken());
		macLimit = Integer.parseInt(st.nextToken());
		for(int i=0; i<v; i++) {
			macDist[i] = macLimit+1;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<macN; i++) {
			macList.add(Integer.parseInt(st.nextToken()) - 1);
		}
		
		st = new StringTokenizer(br.readLine());
		int starN = Integer.parseInt(st.nextToken());
		starLimit = Integer.parseInt(st.nextToken());
		for(int i=0; i<v; i++) {
			starDist[i] = starLimit+1;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<starN; i++) {
			starList.add(Integer.parseInt(st.nextToken()) - 1);
		}
	}
	
	public static int dijkstra() {
		int min = macLimit + starLimit + 1;
		HashMap<Integer, Integer> nears = new HashMap<>();
		
		PriorityQueue<Node> macQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		PriorityQueue<Node> starQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		for(int m : macList) {
			macQ.add(new Node(m, 0));
			macDist[m] = 0;
		}
		for(int s : starList) {
			starQ.add(new Node(s, 0));
			starDist[s] = 0;
		}
		
		while(!macQ.isEmpty()) {
			Node cur = macQ.poll();
			if(cur.cost > macDist[cur.id]) continue;
			for(Node next : list.get(cur.id)) {
				int newCost = macDist[cur.id] + next.cost;
				if(newCost > macLimit || newCost >= macDist[next.id]) continue;
				macDist[next.id] = newCost;
				if(!starList.contains(next.id)) nears.put(next.id, newCost);
				macQ.add(new Node(next.id, newCost));
			}
		}
		
		if(nears.isEmpty()) return -1;
		
		while(!starQ.isEmpty()) {
			Node cur = starQ.poll();
			if(cur.cost > starDist[cur.id]) continue;
			if(nears.containsKey(cur.id)) {
				min = Math.min(min, cur.cost + macDist[cur.id]);
			}
			for(Node next : list.get(cur.id)) {
				int newCost = starDist[cur.id] + next.cost;
				if(newCost > starLimit || newCost >= starDist[next.id]) continue;
				starDist[next.id] = newCost;
				starQ.add(new Node(next.id, newCost));
			}
		}
		
		if(min == macLimit + starLimit + 1) return -1;
		
		return min;
	}

}
