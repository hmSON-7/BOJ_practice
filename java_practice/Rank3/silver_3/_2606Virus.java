import java.util.*;

public class _2606Virus {
    public static void main(String[] args){
        // 초기 설정
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 수
        boolean[] virus = new boolean[n]; // 오염여부 기록 배열
        boolean[][] map = new boolean[n][n];
        int l = sc.nextInt(); // 간선 수
        for(int i=0; i<l; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            map[a][b] = map[b][a] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0); virus[0] = true; // 바이러스 모체 컴퓨터
        int cnt = 0; // 오염된 컴퓨터의 수 카운트

        while(!q.isEmpty()) {
            int x = q.poll();
            for(int i=0; i<n; i++) {
                if(map[x][i] && !virus[i]) {
                    q.add(i);
                    virus[i] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}