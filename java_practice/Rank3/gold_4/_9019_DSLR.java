package gold_4;

import java.io.*;
import java.util.*;

class DSLR {
    int num;
    List<Character> cmd;

    public DSLR(int num, List<Character> cmd) {
        this.num = num;
        this.cmd = cmd;
    }
}

public class _9019_DSLR {
    static Queue<DSLR> q;
    static int before, after;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            visit = new boolean[10000];
            String[] line = br.readLine().trim().split(" ");
            before = Integer.parseInt(line[0]);
            after = Integer.parseInt(line[1]);
            q = new LinkedList<>();
            q.add(new DSLR(before, new ArrayList<>()));
            visit[before] = true;
            List<Character> res = bfs();
            for(Character c : res) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static List<Character> bfs() {
        while(!q.isEmpty()) {
            DSLR cur = q.poll();
            int d = (cur.num * 2) % 10000;
            int s = (cur.num + 9999) % 10000;
            int l = (cur.num * 10 + cur.num / 1000) % 10000;
            int r = (cur.num / 10 + cur.num % 10 * 1000) % 10000;

            if(!visit[d]) {
                List<Character> newCmd = new ArrayList<>(cur.cmd);
                newCmd.add('D');
                if(d == after) return newCmd;
                q.add(new DSLR(d, newCmd));
                visit[d] = true;
            }
            if(!visit[s]) {
                List<Character> newCmd = new ArrayList<>(cur.cmd);
                newCmd.add('S');
                if(s == after) return newCmd;
                q.add(new DSLR(s, newCmd));
                visit[s] = true;
            }
            if(!visit[l]) {
                List<Character> newCmd = new ArrayList<>(cur.cmd);
                newCmd.add('L');
                if(l == after) return newCmd;
                q.add(new DSLR(l, newCmd));
                visit[l] = true;
            }
            if(!visit[r]) {
                List<Character> newCmd = new ArrayList<>(cur.cmd);
                newCmd.add('R');
                if(r == after) return newCmd;
                q.add(new DSLR(r, newCmd));
                visit[r] = true;
            }
        }
        return null;
    }
}
