package baekjoon;

import java.io.*;
import java.util.Stack;

public class Gold1918 {
    static int getPriority(char c){
        if(c == '+' || c == '-'){
            return 1;
        }else if(c == '*' || c == '/'){
            return 2;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if( c >= 65 && c <= 90) {
                bw.write(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    bw.write(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && (getPriority(c) <= getPriority(stack.peek()))) {
                    bw.write(stack.pop());
                }
                stack.push(c);

            }
        }
        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();
    }
}
