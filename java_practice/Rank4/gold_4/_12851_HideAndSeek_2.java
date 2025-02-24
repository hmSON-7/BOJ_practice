package gold_4;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12851_HideAndSeek_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int su = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        if(su == bro) bw.write(0 + "\n" + 1);
        else {
            int[] visit = new int[100001];
            Arrays.fill(visit, 100001);
            visit[su] = 0;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{su, 0});
            int time = 0, cnt = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int p = cur[0];
                int currentTime = cur[1];
                if(time != 0 && currentTime == time) break;
                int[] next = new int[]{p+1, p-1, p*2};
                for(int x : next) {
                    if(x < 0 || x >= 100001 || currentTime+1 > visit[x]) continue;
                    if(x == bro) {
                        time = currentTime + 1;
                        cnt++;
                        continue;
                    }
                    visit[x] = currentTime + 1;
                    q.add(new int[]{x, currentTime+1});
                }
            }
            bw.write(time + "\n" + cnt);
        }
        bw.flush();
    }
}
