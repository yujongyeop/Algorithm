package baekjoon;

import java.io.*;
import java.util.Stack;

public class Gold9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        String sentence = br.readLine();
        String bombStr = br.readLine();

        int sentenceLength = sentence.length();
        int bombLen = bombStr.length();

        br.close();

        for(int i = 0 ; i < sentenceLength ; i++){
            stack.push(sentence.charAt(i));
            if (stack.size() >= bombLen) {
                char topChar = stack.peek();
                char bombEndChar = bombStr.charAt(bombLen -1 );
                if (topChar == bombEndChar) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < bombLen; j++) {
                        sb.append(stack.pop());
                    }
                    if (!sb.reverse().toString().equals(bombStr)) {
                        for (int j = 0; j < bombLen; j++) {
                            stack.push(sb.charAt(j));
                        }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            bw.write("FRULA");
        }else{
            StringBuilder stringBuffer = new StringBuilder();
            while(!stack.isEmpty()){
                stringBuffer.append(stack.pop());
            }
            bw.write(stringBuffer.reverse().toString());

        }
        bw.flush();
        bw.close();
    }
}
