package Rank2;

import java.io.*;
import java.util.*;

public class _10828Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] cmd = br.readLine().trim().split(" ");
            switch(cmd[0]) {
                case "push":
                    s.push(Integer.parseInt(cmd[1]));
                    break;
                case "pop":
                    if(s.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(s.pop()).append("\n");
                    break;
                case "top":
                    if(s.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(s.peek()).append("\n");
                    break;
                case "empty":
                    if(s.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "size":
                    sb.append(s.size()).append("\n"); break;
            }
        }

        String str = sb.toString();
        System.out.println(str);
    }
}