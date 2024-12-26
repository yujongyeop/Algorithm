package baekjoon;

import java.io.*;

public class Sliver11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int numCoins = 0;
        int[] coinArr = new int[N];
        for (int i = 0; i < N; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = N-1; i >= 0; i--) {
            numCoins += (K / coinArr[i]);
            K = K%coinArr[i];
        }
        bw.write(numCoins + "\n");
        bw.flush();
        bw.close();
    }
}
