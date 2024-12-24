package baekjoon;

import java.io.*;
import java.util.Stack;

public class Sliver3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int goodNum = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < word.length(); j++) {
                if(!stack.isEmpty() && stack.peek() == word.charAt(j)) {
                    stack.pop();
                }else{
                    stack.push(word.charAt(j));
                }
            }
            if(stack.isEmpty()) goodNum++;
        }
        bw.write(String.valueOf(goodNum));
        bw.flush();
        br.close();
        bw.close();

    }
}
