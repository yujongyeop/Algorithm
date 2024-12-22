package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gold15686 {
    static int N, M;
    static int totalDistance = Integer.MAX_VALUE;
    static boolean[] removed;
    static List<Pos> chickens = new ArrayList<>();
    static List<Pos> homes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        for (int i = 0; i < N; i++) {
            String[] datas = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (datas[j].equals("1")) {
                    homes.add(new Pos(i, j));
                } else if (datas[j].equals("2")) {
                    chickens.add(new Pos(i, j));
                }
            }
        }
        removed = new boolean[chickens.size()];

        br.close();
        backtrack(0, 0);
        bw.write(totalDistance + "\n");
        bw.flush();
        bw.close();
    }

    static void backtrack(int start, int removeCount) {
        if (removeCount == (chickens.size() - M)) {
            int shortestDistance = 0;
            for (Pos home : homes) {
                int tmpDistance = Integer.MAX_VALUE;
                int x = home.x;
                int y = home.y;
                for (int i = 0; i < chickens.size(); i++) {
                    if (!removed[i]) {
                        int distance = Math.abs(x - chickens.get(i).x) + Math.abs(y - chickens.get(i).y);
                        if (distance <= tmpDistance) {
                            tmpDistance = distance;
                        }
                    }
                }
                shortestDistance += tmpDistance;
            }
            if (shortestDistance < totalDistance) {
                totalDistance = shortestDistance;
            }
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            removed[i] = true;
            backtrack(i + 1, removeCount + 1);
            removed[i] = false;
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}