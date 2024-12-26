package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Sliver10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> queue = new LinkedList<>();
        String top = "-1";
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            try {
                String number = command.split(" ")[1];
                queue.add(number);
                top = number;
            } catch (Exception e) {
                if (command.equals("front")) {
                    if (!queue.isEmpty())
                        bw.write(queue.element() + "\n");
                    else
                        bw.write("-1\n");
                } else if (command.equals("back")) {
                    if (!queue.isEmpty())
                        bw.write(top + "\n");
                    else
                        bw.write("-1\n");
                } else if (command.equals("size")) {
                    bw.write(queue.size() + "\n");
                } else if (command.equals("empty")) {
                    if(!queue.isEmpty())
                        bw.write( "0\n");
                    else
                        bw.write("1\n");
                } else if (command.equals("pop")) {
                    if (!queue.isEmpty()){
                        bw.write(queue.remove() + "\n");
                    }
                    else
                        bw.write("-1\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
