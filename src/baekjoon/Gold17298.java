package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gold17298 {
    static int N;
    static Stack<Integer> inputStack = new Stack<>();
    static Stack<Integer> comparisonStack = new Stack<>();
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        while(st.hasMoreTokens()){
            inputStack.push(Integer.parseInt(st.nextToken()));
        }
        comparisonStack.push(inputStack.pop());
        result[N-1] = -1;
        while (!inputStack.isEmpty()) {
            int pop = inputStack.pop();
            while(!comparisonStack.isEmpty()){
                if(pop < comparisonStack.peek()){
                    result[inputStack.size()] = comparisonStack.peek();
                    comparisonStack.push(pop);
                    break;
                }else{
                    comparisonStack.pop();
                }
            }
            if(comparisonStack.isEmpty()){
                result[inputStack.size()] = -1;
            }
            comparisonStack.push(pop);
        }
        for(int i =0;i<N;i++){
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
