package Rank3.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class _11403_FindingPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(br.readLine());

        BitSet[] graph = new BitSet[p];
        for(int i=0; i<p; i++){
            graph[i] = new BitSet(p);
        }

        for(int i=0; i<p; i++){
            String line = br.readLine().replaceAll(" ", "");
            for(int j=0; j<p; j++){
                if(line.charAt(j) == '1'){
                    graph[i].set(j);
                }
            }
        }

        for(int k=0; k<p; k++){
            for(int i=0; i<p; i++){
                if(graph[i].get(k)){
                    graph[i].or(graph[k]);
                }
            }
        }

        for(int i=0; i<p; i++){
            for(int j=0; j<p; j++){
                sb.append(graph[i].get(j) ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
