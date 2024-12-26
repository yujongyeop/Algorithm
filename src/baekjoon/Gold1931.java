package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Gold1931 {
    static class Meet implements Comparable<Meet> {
        public int start, end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet meet) {
            if(this.end == meet.end) {
                return this.start > meet.start?1:-1;
            }else{
                return this.end > meet.end?1:-1;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numMeet = Integer.parseInt(br.readLine());
        PriorityQueue<Meet> pq = new PriorityQueue<>();

        int currentEnd = 0;
        int operatedMeet = 0;

        for (int i = 0; i < numMeet; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Meet(input[0], input[1]));
        }

        while (!pq.isEmpty()) {
            Meet meet = pq.poll();
            if (meet.start >= currentEnd) {
                operatedMeet++;
                currentEnd = meet.end;
            }
        }
        System.out.println(operatedMeet);
    }
}
