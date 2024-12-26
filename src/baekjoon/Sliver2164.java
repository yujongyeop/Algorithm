package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Sliver2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            queue.poll(); // 첫 번째값 삭제
            queue.add(queue.poll());
        }
        bw.write(queue.poll() + "\n");
        bw.flush();
        bw.close();
    }
}
