package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Glod9663 {
    static int n;
    static int cnt = 0;
    static boolean[] yCheck;
    static boolean[] rCheck;
    static boolean[] lCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        yCheck = new boolean[n];
        rCheck = new boolean[n*2-1];
        lCheck = new boolean[n*2-1];
        backTrack(0);
        System.out.println(cnt);
    }

    static void backTrack(int cur){
        if(cur == n) {
            cnt ++;
            return;
        }
        for(int i = 0 ; i < n ; i++){
            int rCheckIdx = i + cur;
            int lCheckIdx = i - cur + n - 1;
            if(!yCheck[i] && !rCheck[rCheckIdx] && !lCheck[lCheckIdx]){
                yCheck[i] = true;
                rCheck[rCheckIdx] = true;
                lCheck[lCheckIdx] = true;
                backTrack(cur+1);
                yCheck[i] = false;
                rCheck[rCheckIdx] = false;
                lCheck[lCheckIdx] = false;
            }
        }
    }
}
