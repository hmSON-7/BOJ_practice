package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2630_ColoredPaper {
    static int cntBlue = 0;
    static int cntWhite = 0;
    static boolean[][] paper;

    static boolean check(int r, int x, int y) {
        if(r==1) return true;

        boolean std = paper[x][y];
        for(int i=x; i<x+r; i++) {
            for(int j=y; j<y+r; j++) {
                if(paper[i][j] != paper[x][y]) return false;
            }
        }

        return true;
    }

    static void dnc(int r, int x, int y) {
        boolean res = check(r, x, y);

        if(res || r == 1) {
            if(paper[x][y]) cntBlue++;
            else cntWhite++;
        } else {
            dnc(r/2, x, y);
            dnc(r/2, x, y + r/2);
            dnc(r/2, x + r/2, y);
            dnc(r/2, x + r/2, y + r/2);
        }
    }

    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(br.readLine());
        paper = new boolean[r][r];

        for(int i=0; i<r; i++) {
            String[] line = br.readLine().trim().split(" ");

            for(int j=0; j<r; j++) {
                paper[i][j] = line[j].equals("1");
            }
        }

        dnc(r, 0, 0);

        System.out.println(sb.append(cntWhite).append("\n").append(cntBlue));
    }
}
