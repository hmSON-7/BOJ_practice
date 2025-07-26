package silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12891_DNAPassword {
    static int n, len;
    static char[] dna;
    static int[] require = new int[4], cnt = new int[4];
    public static void main(String[] args) throws Exception {
        init(); solve();
    }

    public static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        dna = new char[n];
        dna = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            require[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        int left = 0, right = len-1, res = 0;
        for(int i=left; i<right; i++) {
            int ch = switchChar(dna[i]);
            cnt[ch]++;
        }

        while(true) {
            if(right >= n) break;
            int rightIdx = switchChar(dna[right]);
            cnt[rightIdx]++;
            boolean flag = true;
            for(int i=0; i<4; i++) {
                if(cnt[i] < require[i]) {
                    flag = false; break;
                }
            }
            if(flag) res++;

            int leftIdx = switchChar(dna[left]);
            cnt[leftIdx]--;
            left++; right++;
        }

        System.out.println(res);
    }

    public static int switchChar(char c) {
        switch(c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return -1;
        }
    }
}
