import java.io.*;
import java.util.*;

public class _1966PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] info = br.readLine().trim().split(" ");
            int n = Integer.parseInt(info[0]);
            int targetLocation = Integer.parseInt(info[1]);

            String[] files = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++) {
                q.add(Integer.parseInt(files[i]));
            }

            int cnt = 0;
            while(!q.isEmpty()) {
                int maxNum = q.isEmpty() ? -1 : Collections.max(q);
                while(!q.isEmpty() && q.peek() != maxNum) {
                    int num = q.poll();
                    q.add(num);
                    if(targetLocation == 0) {
                        targetLocation = q.size() - 1;
                    } else targetLocation--;
                }

                cnt++;
                if(targetLocation == 0) {
                    break;
                } else {
                    q.remove();
                    targetLocation--;
                }
            }

            sb.append(cnt).append("\n");
            q.clear();
        }

        String str = sb.toString();
        System.out.println(str);
    }
}
