package gold_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
BOJ_6443: 애너그램
각 테스트 케이스마다 주어지는 영단어를 조합하여 구성할 수 있는 모든 애너그램을 출력한다.
t: 테스트 케이스의 수, 각 단어의 길이는 20 이하이며, 한 단어당 구성되는 애너그램의 수가 100_000 이하인 단어만 입력값으로 주어진다.

1. 주어진 단어를 문자 배열로 전환 후 정렬
2. 백트래킹 실행. 중복 없이 모든 인덱스의 문자가 사용되면 해당 값을 출력한다.
3. 정렬된 문자 배열이므로, 동일한 cnt 상황에서 다음에 오는 알파벳은 취급하지 않는다.
3-1. 이를 idx > 0 && arr[idx] == arr[idx-1] && !visited[idx-1]로 검증하여 해당 조건에 부합하면 다음 알파벳으로 넘어간다.
*/

public class _6443_Anagram {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder ans = new StringBuilder();
    static char[] str;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            str = br.readLine().toCharArray();
            Arrays.sort(str);
            visited = new boolean[str.length];
            bt(0);
        }
        System.out.println(ans);
    }

    private static void bt(int cnt) {
        if(cnt == str.length) {
            ans.append(sb.toString()).append("\n");
            return;
        }

        for(int i=0; i<str.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && str[i] == str[i-1] && !visited[i-1]) continue;
            sb.append(str[i]);
            visited[i] = true;
            bt(cnt+1);
            visited[i] = false;
            sb.setLength(cnt);
        }
    }
}
