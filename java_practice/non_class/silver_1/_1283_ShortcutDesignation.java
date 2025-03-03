package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _1283_ShortcutDesignation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            String[] cmd = br.readLine().split(" ");
            boolean flag = false;
            for(int j=0; j<cmd.length; j++) {
                char first = cmd[j].charAt(0);
                if(!set.contains(Character.toLowerCase(first))) {
                    set.add(Character.toLowerCase(first));
                    cmd[j] = "[" + first + "]" + cmd[j].substring(1);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                for(int j=0; j<cmd.length; j++) {
                    for(int k=0; k<cmd[j].length(); k++) {
                        char next = cmd[j].charAt(k);
                        if(!set.contains(Character.toLowerCase(next))) {
                            set.add(Character.toLowerCase(next));
                            cmd[j] = cmd[j].substring(0, k) + "[" + next + "]" + cmd[j].substring(k+1);
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                }
            }
            for (String s : cmd) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
