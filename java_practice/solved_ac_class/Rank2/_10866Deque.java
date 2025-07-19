package Rank2;

import java.io.*;
import java.util.*;

public class _10866Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> d = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] cmd = br.readLine().trim().split(" ");
            switch(cmd[0]) {
                case "push_front":
                    d.addFirst(Integer.parseInt(cmd[1])); break;
                case "push_back":
                    d.addLast(Integer.parseInt(cmd[1])); break;
                case "pop_front":
                    if(d.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(d.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    if(d.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(d.removeLast()).append("\n");
                    break;
                case "size":
                    sb.append(d.size()).append("\n"); break;
                case "empty":
                    if(d.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(d.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(d.peekFirst()).append("\n");
                    break;
                case "back":
                    if(d.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(d.peekLast()).append("\n");
                    break;
            }
        }

        String str = sb.toString();
        System.out.println(str);
    }
}