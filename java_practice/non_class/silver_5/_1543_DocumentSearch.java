package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1543_DocumentSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String docs = br.readLine();
        String findWord = br.readLine();
        if(docs.length() < findWord.length()) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0; i<docs.length(); i++) {
            sb.append(docs.charAt(i));
            if(sb.length() >= findWord.length()) {
                boolean flag = true;
                for(int j=0; j<findWord.length(); j++) {
                    if(sb.charAt(sb.length() - findWord.length() + j) != findWord.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    sb.delete(0, sb.length());
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
