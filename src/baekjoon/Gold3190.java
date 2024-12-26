package baekjoon;

import java.io.*;
import java.util.*;

public class Gold3190 {
    static Queue<int[]> snack = new LinkedList<>();
    static Map<Integer, String> commandMap = new HashMap<>();
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};// 동 남 서 북
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int apples = Integer.parseInt(br.readLine());
        for (int i = 0; i < apples; i++) {
            int[] applePos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[applePos[0] - 1][applePos[1] - 1] = 1;
        }
        int numCommands = Integer.parseInt(br.readLine());
        for (int i = 0; i < numCommands; i++) {
            String[] command = br.readLine().split(" ");
            commandMap.put(Integer.parseInt(command[0]), command[1]);
        }
        br.close();

        int result = solve();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    static int solve() {
        int x = 0, y = 0;
        int direction = 0;
        int result = 0;
        map[x][y] = -1;
        snack.add(new int[]{x, y});

        while (true) {
            x += dx[direction];
            y += dy[direction];
            result+=1;
            if(x == -1 || x == N || y == -1 || y == N) { // 벽에 부딪힐 경우
                break;
            }
            if(map[x][y] == -1) // 몸에 부딪힐 경우
                break;


            if(map[x][y] != 1){ // 사과가 없을 경우 꼬리 위치를 움직임
                int[] pos = snack.poll();
                map[pos[0]][pos[1]] = 0;
            }else{
                map[x][y] = 0;
            }

            snack.add(new int[]{x, y});
            map[x][y] = -1;

            if(commandMap.containsKey(result)){ // 방향 전환 부분
                if(commandMap.get(result).equals("D")){
                    direction+=1;
                    if(direction == 4){
                        direction = 0;
                    }
                }else{
                    direction-=1;
                    if(direction == -1){
                        direction = 3;
                    }
                }
            }
        }

        return result;
    }
}
