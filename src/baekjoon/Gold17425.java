package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Gold17425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 1000001;
        long[] fx = new long[MAX];
        long[] gx = new long[MAX];
        Arrays.fill(fx, 1); // 모든 자연수는 1을 약수로 함 Math.sqrt(MAX)
        for (int i = 2; i < MAX; i++) { // fx 구하는 과정
            for (int j = 1; i * j < MAX; j++) {
                fx[i * j] += i;
            }
        }
        for (int i = 1; i < MAX; i++) { // gx 구하는 과정
            gx[i] = gx[i - 1] + fx[i];
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(gx[N] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
