package gold_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_4195 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int f;
	static HashMap<String, User> map;
	
	static class User {
		String name;
		User head;
		int friendCnt;
		
		public User(String name) {
			this.name = name;
			this.friendCnt = 1;
		}
	}
	
	static User find(User u) {
		if(u.head == u) return u;
		return u.head = find(u.head);
	}
	
	static int union(User u1, User u2) {
		User h1 = find(u1);
		User h2 = find(u2);
		if(h1 == h2) return h1.friendCnt;
		
		if(h1.friendCnt < h2.friendCnt) {
			h1.head = h2;
			h2.friendCnt += h1.friendCnt;
			return h2.friendCnt;
		}
		h2.head = h1;
		h1.friendCnt += h2.friendCnt;
		return h1.friendCnt;
		
	}
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			map = new HashMap<>();
			f = Integer.parseInt(br.readLine());
			for(int i=0; i<f; i++) {
				st = new StringTokenizer(br.readLine());
				
				String name1 = st.nextToken();
				User u1, u2;
				if(map.containsKey(name1)) {
					u1 = map.get(name1);
				} else {
					u1 = new User(name1);
					u1.head = u1;
					map.put(name1, u1);
				}
				
				String name2 = st.nextToken();
				if(map.containsKey(name2)) {
					u2 = map.get(name2);
				} else {
					u2 = new User(name2);
					u2.head = u2;
					map.put(name2, u2);
				}
				
				sb.append(union(u1, u2) + "\n");
			}
			
			
		}
		
		System.out.println(sb);
	}

}
