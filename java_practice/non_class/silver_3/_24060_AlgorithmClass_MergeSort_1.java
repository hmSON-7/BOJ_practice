package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24060_AlgorithmClass_MergeSort_1 {
    static int[] arr, temp;
    static int n, k, cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n]; temp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, n-1);
        System.out.println(-1);
    }

    static void mergeSort(int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    static void merge(int left, int mid, int right) {
        int i = left, j = mid + 1, t = left;
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) temp[t++] = arr[i++];
            else temp[t++] = arr[j++];
        }
        while(i <= mid) temp[t++] = arr[i++];
        while(j <= right) temp[t++] = arr[j++];
        t = right - left + 1;
        if(cnt + t < k) {
            System.arraycopy(temp, left, arr, left, t);
            cnt += t;
            return;
        }
        for(int x = left; x <= right; x++) {
            arr[x] = temp[x];
            cnt++;
            if(cnt == k) {
                System.out.println(arr[x]);
                System.exit(0);
            }
        }
    }
}
