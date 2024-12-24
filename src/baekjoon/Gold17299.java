package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Gold17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int[] counts = new int[1000001];

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];

        result[N-1] = -1; // 마지막 인덱스는 항상 값이 -1임
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < N; i++) {
            counts[input[i]]++;
        }
        stack.push(N-1);
        for(int i = N - 2 ; i >= 0; i--) {
            if(counts[input[i]] < counts[input[stack.peek()]]) {
                result[i] = input[stack.peek()];
            }else{
                stack.pop();
                while(!stack.isEmpty() && counts[input[i]] >= counts[input[stack.peek()]]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    result[i] = -1;
                }else{
                    result[i] = input[stack.peek()];
                }
            }
            stack.push(i);
        }
        for(int i = 0; i < N; i++) {
            bw.write(result[i]+ " ");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
