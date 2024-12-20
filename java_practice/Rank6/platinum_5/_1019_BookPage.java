package platinum_5;

import java.io.*;

public class _1019_BookPage {
    static final int UNIT = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] counts = new int[UNIT];
        int page = Integer.parseInt(br.readLine());
        int currentNum = page, currentUnit = 1;
        while(currentNum > 0) {
            for(int i=1; i<UNIT; i++) {
                counts[i] += currentNum/UNIT * currentUnit;
                if(i < currentNum%UNIT) counts[i] += currentUnit;
                else if(i == currentNum%UNIT) counts[i] += (page%currentUnit + 1);
            }
            int zeroCnt = currentNum%UNIT == 0 ?
                    (currentNum/UNIT - 1) * currentUnit + (page%currentUnit + 1) : currentNum/UNIT * currentUnit;
            counts[0] += zeroCnt;
            currentNum /= 10;
            currentUnit *= UNIT;
        }

        for(int c : counts) {
            sb.append(c).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
