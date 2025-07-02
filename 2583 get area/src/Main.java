import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] matrix;
    static boolean[][] visited;
    static int result = 0;

    //dfs 탐색
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        result++;

        // 상
        if (x > 0 && matrix[x - 1][y] == 0 && !visited[x - 1][y]) {
            dfs(x - 1, y);
        }

        // 하
        if (x + 1 < matrix.length && matrix[x + 1][y] == 0 && !visited[x + 1][y]) {
            dfs(x + 1, y);
        }

        // 좌
        if (y > 0 && matrix[x][y - 1] == 0 && !visited[x][y - 1]) {
            dfs(x, y - 1);
        }

        // 우
        if (y + 1 < matrix[0].length && matrix[x][y + 1] == 0 && !visited[x][y + 1]) {
            dfs(x, y + 1);
        }
    }


    //bfs탐색
    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            result++;

            // 상
            if (x1 > 0 && matrix[x1 - 1][y1] == 0 && !visited[x1 - 1][y1]) {
                q.offer(new int[]{x1 - 1, y1});
                visited[x1 - 1][y1] = true;
            }

            // 하
            if (x1 + 1 < matrix.length && matrix[x1 + 1][y1] == 0 && !visited[x1 + 1][y1]) {
                q.offer(new int[]{x1 + 1, y1});
                visited[x1 + 1][y1] = true;
            }

            // 좌
            if (y1 > 0 && matrix[x1][y1 - 1] == 0 && !visited[x1][y1 - 1]) {
                q.offer(new int[]{x1, y1 - 1});
                visited[x1][y1 - 1] = true;
            }

            // 우
            if (y1 + 1 < matrix[0].length && matrix[x1][y1 + 1] == 0 && !visited[x1][y1 + 1]) {
                q.offer(new int[]{x1, y1 + 1});
                visited[x1][y1 + 1] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int N, M, K;
        Vector<Integer> v = new Vector<>(); // 결과 담을 벡터

        // N, M, K 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];

        // K개의 직사각형 영역 색칠
        // 대칭해서 보기 쉽게 0.0이 가장 위로 가게 변환
        for (int i = 0; i < K; i++) {
            int x1, x2, y1, y2;
            st = new StringTokenizer(br.readLine(), " ");
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    matrix[j][k] = 1; //영역 색칠
                }
            }
        }

        // DFS 탐색하여 영역 크기 측정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) {
                    result = 0;
//                    dfs(i, j);
                    bfs(i, j);
                    v.add(result);
                }
            }
        }

        // 결과 정렬 및 출력
        Collections.sort(v);
        System.out.println(v.size());
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i));
            if (i != v.size() - 1) System.out.print(" ");
        }
    }
}
