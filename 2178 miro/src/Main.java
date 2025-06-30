import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] miro;
    static boolean[][] visited;
    static int weigh, height;
    static int minVal = Integer.MAX_VALUE;


    //bfs방식
    public static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        visited[startX][startY] = true;
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            // 아래쪽 이동
            if (x + 1 < miro.length && miro[x + 1][y] == 1 && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                miro[x + 1][y] = miro[x][y] + 1;
                q.add(new int[]{x + 1, y});
            }

            // 위쪽 이동
            if (x - 1 >= 1 && miro[x - 1][y] == 1 && !visited[x - 1][y]) {
                visited[x - 1][y] = true;
                miro[x - 1][y] = miro[x][y] + 1;
                q.add(new int[]{x - 1, y});
            }

            // 오른쪽 이동
            if (y + 1 < miro[0].length && miro[x][y + 1] == 1 && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                miro[x][y + 1] = miro[x][y] + 1;
                q.add(new int[]{x, y + 1});
            }

            // 왼쪽 이동
            if (y - 1 >= 1 && miro[x][y - 1] == 1 && !visited[x][y - 1]) {
                visited[x][y - 1] = true;
                miro[x][y - 1] = miro[x][y] + 1;
                q.add(new int[]{x, y - 1});
            }
        }
    }

    //dfs방식
    public static void dfs(int startX, int startY, int count) {
        visited[startX][startY] = true;

        if (startX == weigh && startY == height) {
            minVal = Math.min(minVal, count);
            visited[startX][startY] = false;  // 복구
            return;
        }

        if (count > minVal) {
            visited[startX][startY] = false;  // 복구
            return;
        }

        // 상
        if (startX > 0 && !visited[startX - 1][startY] && miro[startX - 1][startY] == 1) {
            dfs(startX - 1, startY, count + 1);
        }

        // 하
        if (startX + 1 < miro.length && !visited[startX + 1][startY] && miro[startX + 1][startY] == 1) {
            dfs(startX + 1, startY, count + 1);
        }

        // 좌
        if (startY > 0 && !visited[startX][startY - 1] && miro[startX][startY - 1] == 1) {
            dfs(startX, startY - 1, count + 1);
        }

        // 우
        if (startY + 1 < miro[0].length && !visited[startX][startY + 1] && miro[startX][startY + 1] == 1) {
            dfs(startX, startY + 1, count + 1);
        }

        visited[startX][startY] = false;  // 복구
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        weigh = Integer.parseInt(input[0]);  // 행 수
        height = Integer.parseInt(input[1]); // 열 수

        miro = new int[weigh + 1][height + 1];
        visited = new boolean[weigh + 1][height + 1];

        //입력값 행렬 저장.
        for (int i = 1; i <= weigh; i++) {
            String line = br.readLine();
            for (int j = 1; j <= height; j++) {
                miro[i][j] = line.charAt(j - 1) - '0';
            }
        }

        /**
         * bfs탐색
         */
        bfs(1, 1);
        System.out.println(miro[weigh][height]);

        /**
         * dfs탐색
         */
//        dfs(1,1,1);
//        System.out.println(minVal);
    }
}
