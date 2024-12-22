package baekjoon;

import java.io.*;
import java.util.Stack;

public class Gold2493 {
    static int N;
    static int[] result;
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> idxStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        result = new int[N];

        String[] towers = br.readLine().split(" ");
        stack.push(Integer.parseInt(towers[0]));
        idxStack.push(0);
        for (int idx = 1; idx < N; idx++) {
            int value = Integer.parseInt(towers[idx]);
            while (!stack.isEmpty()) {
                if(stack.peek() > value) {
                    result[idx] = idxStack.peek()+1;
                    break;
                }else{
                    stack.pop();
                    idxStack.pop();
                }
            }
            if(stack.isEmpty()) {
                result[idx] = 0;
            }
            stack.push(value);
            idxStack.push(idx);
        }
        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
