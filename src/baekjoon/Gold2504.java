package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Gold2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input =br.readLine();
        br.close();
        int sum = 0;
        int tmpValue = 1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
                tmpValue *= 2;
            } else if(c=='['){
                stack.push(c);
                tmpValue *= 3;
            }else if (c==')') {
                if (stack.isEmpty()||stack.peek() != '(') {
                    sum=0;
                    break;
                }
                if (input.charAt(i - 1) == '(') {
                    sum += tmpValue;
                }
                stack.pop();
                tmpValue /= 2;
            } else {
                if(stack.isEmpty() || stack.peek()!='['){
                    sum=0;
                    break;
                }
                if (input.charAt(i - 1) == '[') {
                    sum += tmpValue;
                }
                stack.pop();
                tmpValue /= 3;
            }
        }
        if(!stack.isEmpty()){
            sum=0;
        }
        System.out.println(sum);
    }
}
