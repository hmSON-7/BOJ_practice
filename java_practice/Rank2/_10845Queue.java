import java.io.*;
import java.util.*;

public class _10845Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());
        int lastInserted = -1;
        while(t-- > 0) {
            String[] cmd = br.readLine().trim().split(" ");
            switch(cmd[0]) {
                case "push":
                    lastInserted = Integer.parseInt(cmd[1]);
                    q.add(lastInserted); break;
                case "pop":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.remove()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n"); break;
                case "empty":
                    if(q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peek()).append("\n");
                    break;
                case "back":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(lastInserted).append("\n");
                    break;
            }
        }

        String str = sb.toString();
        System.out.println(str);
    }
}