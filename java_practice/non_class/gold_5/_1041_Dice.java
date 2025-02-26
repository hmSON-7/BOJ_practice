package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1041_Dice {
    public static void main(String[] args) throws IOException {
        // 1개 면만 보이는 경우 : (n-2) * ((n-1) * 4 + (n-2));
        // 2개 면만 보이는 경우 : 4 * ((n-1) + (n-2));
        // 3개 면만 보이는 경우 : 4
        // 예외 사항 : n == 1 -> 5개 면을 볼 수 있음. 그 외에는 상기한 공식 적용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int[] eyes = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++) {
            eyes[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        if(n == 1) {
            Arrays.sort(eyes);
            for(int i=0; i<5; i++) sum += eyes[i];
            System.out.println(sum);
            return;
        }

        long one = (n-2) * (n-1) * 4 + (n-2) * (n-2), two = 4 * ((n-1) + (n-2)), three = 4;
        long oneMin = Long.MAX_VALUE, twoMin = Long.MAX_VALUE, threeMin = Long.MAX_VALUE;
        for(int i=0; i<6; i++) {
            oneMin = Math.min(oneMin, eyes[i]);
            for(int j=i+1; j<6; j++) {
                if(i + j == 5) continue;
                twoMin = Math.min(twoMin, eyes[i] + eyes[j]);
                for(int k=j+1; k<6; k++) {
                    if(j + k == 5 || i + k == 5) continue;
                    threeMin = Math.min(threeMin, eyes[i] + eyes[j] + eyes[k]);
                }
            }
        }
        sum += oneMin * one + twoMin * two + threeMin * three;
        System.out.println(sum);
    }
}
