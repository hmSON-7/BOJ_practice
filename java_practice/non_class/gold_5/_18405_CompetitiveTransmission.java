package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Virus {
    int id, h, w, second;
    public Virus(int id, int h, int w, int second) {
        this.id = id;
        this.h = h;
        this.w = w;
        this.second = second;
    }
}

public class _18405_CompetitiveTransmission {
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int virusCnt = Integer.parseInt(st.nextToken());
        int[][] examiner = new int[n][n];
        PriorityQueue<Virus> q = new PriorityQueue<>((a, b) -> a.second != b.second ?
                Integer.compare(a.second, b.second) : Integer.compare(a.id, b.id));
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int x = Integer.parseInt(st.nextToken());
                examiner[i][j] = x;
                if(x != 0) q.add(new Virus(x, i, j, 0));
            }
        }
        st = new StringTokenizer(br.readLine());
        int sec = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        while(!q.isEmpty()) {
            Virus v = q.poll();
            if(v.second == sec) break;
            boolean resultFlag = false;
            for(int[] dir : direction) {
                int newY = v.h + dir[0];
                int newX = v.w + dir[1];
                if(newY < 0 || newY >= n || newX < 0 || newX >= n || examiner[newY][newX] > 0) continue;
                examiner[newY][newX] = v.id;
                if(newY == y && newX == x) {
                    resultFlag = true;
                    break;
                }
                q.add(new Virus(v.id, newY, newX, v.second + 1));
            }
            if(resultFlag) break;
        }
        System.out.println(examiner[y][x]);
    }
}
