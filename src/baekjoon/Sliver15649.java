package baekjoon;

import java.io.*;

public class Sliver15649 {
    static int n = 0;
    static int m = 0;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        br.close();
        arr = new int[m];
        visited = new boolean[n+1];

        dfs(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
    static void dfs(int node){
        if(node == m){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i<= n;i++){
            if(!visited[i]){
                arr[node] = i;
                visited[i] = true;
                dfs(node + 1);
                visited[i] = false;
            }
        }
    }
}
