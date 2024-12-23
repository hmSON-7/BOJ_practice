package silver_1;

import java.io.*;
import java.util.*;

class House {
    int y, x, info;
    public House(int y, int x, int info) {
        this.y = y;
        this.x = x;
        this.info = info;
    }
}

public class _2667_EstateNumbering {
    static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;
    static int[][] map;
    static Queue<House> q = new LinkedList<>();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] line = br.readLine().trim().split("");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 0 || visit[i][j]) continue;
                q.add(new House(i, j, map[i][j]));
                visit[i][j] = true;
                int cnt = bfs();
                list.add(cnt);
            }
        }
        list.sort(Comparator.naturalOrder());
        sb.append(list.size()).append("\n");
        for(int c : list) {
            sb.append(c).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static int bfs() {
        int cnt = 0;
        while(!q.isEmpty()) {
            House h = q.poll();
            cnt++;
            for(int[] dir : directions) {
                int newY = h.y + dir[0];
                int newX = h.x + dir[1];
                if(newY < 0 || newX < 0 || newY >= n || newX >= n || visit[newY][newX]) continue;
                if(map[newY][newX] == 0) continue;
                q.add(new House(newY, newX, map[newY][newX]));
                visit[newY][newX] = true;
            }
        }

        return cnt;
    }
}
