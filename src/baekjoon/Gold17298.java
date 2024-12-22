package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Gold17298 {
    static int N;
    static Stack<Integer> idxStack = new Stack<>();
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.close();
        for(int i = 0 ; i < N ; i++){
            while(!idxStack.isEmpty() && input[idxStack.peek()] < input[i]){
                result[idxStack.pop()] = input[i];
            }
            idxStack.push(i);
        }

        while(!idxStack.isEmpty()){
            result[idxStack.pop()] = -1;
        }

        for(int i =0;i<N;i++){
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
