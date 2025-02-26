package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1049_GuitarString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lines = Integer.parseInt(st.nextToken());
        int brand = Integer.parseInt(st.nextToken());
        int one = lines % 6, pkg = lines / 6;;
        int minOne = 1001, minPkg = 1001, sum = 0;
        for(int i=0; i<brand; i++) {
            st = new StringTokenizer(br.readLine());
            minPkg = Math.min(minPkg, Integer.parseInt(st.nextToken()));
            minOne = Math.min(minOne, Integer.parseInt(st.nextToken()));
        }
        sum += pkg * Math.min(minPkg, minOne * 6);
        sum += Math.min(minPkg, minOne * one);
        System.out.println(sum);
    }
}
