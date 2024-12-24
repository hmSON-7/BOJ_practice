package silver_1;

import java.io.*;

public class _5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cnt = 0, res = 0;
        for(int i=1; i<len-1; i+=2) {
            if(str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                cnt++;
                if(cnt == n) {
                    if(str.charAt(i-(cnt*2-1)) == 'I') res++;
                    cnt--;
                }
            } else {
                cnt = 0;
                i--;
            }
        }
        bw.write(Integer.toString(res));
        bw.flush();
    }
}
