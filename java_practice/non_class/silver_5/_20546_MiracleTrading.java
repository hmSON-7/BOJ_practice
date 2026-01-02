package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20546_MiracleTrading {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cur = Integer.parseInt(br.readLine());
        int bnpCur = cur, timCur = cur, bnpCnt = 0, timCnt = 0, check = 0, last = 0;
        String[] line = br.readLine().split(" ");
        for(int i=0; i<14; i++) {
            int stock = Integer.parseInt(line[i]);
            int bnpBought = bnpCur / stock;
            if(bnpBought != 0) {
                bnpCnt += bnpBought;
                bnpCur %= stock;
            }
            if(i != 0 && last != stock) {
                if(stock > last) {
                    check = check < 0 ? 1 : check + 1;
                    if(check >= 3 && timCnt > 0) {
                        timCur += stock * timCnt;
                        timCnt = 0;
                    }
                } else {
                    check = check > 0 ? -1 : check - 1;
                    if(check <= -3 && timCur >= stock) {
                        timCnt = timCur / stock;
                        timCur %= stock;
                    }
                }
            }
            last = stock;
        }
        bnpCur += last * bnpCnt;
        timCur += last * timCnt;
        if(bnpCur > timCur) System.out.println("BNP");
        else if(timCur > bnpCur) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}
