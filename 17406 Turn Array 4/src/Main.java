import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] matrix;
    static int r, c, s;

    static int[][] origin;
    static int[][] cmd;      // K개의 (r,c,s) 저장
    static boolean[] visited;
    static int[] order;
    static int answer = Integer.MAX_VALUE;

    public static void turn(int r, int c, int s) {

        int startX = r - s - 1;
        int startY = c - s - 1;
        int endX = r + s - 1;
        int endY = c + s - 1;

        while (true) {

            // 더 돌릴 레이어가 없으면 종료 
            if (startX >= endX || startY >= endY) {
                break;
            }

            //예시 행렬 생성
            int[][] temp = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    temp[i][j] = matrix[i][j];
                }
            }

            //우로 이동
            for (int i = startY; i < endY; i++) {
                temp[startX][i + 1] = matrix[startX][i];
            }

            //아래로 이동
            for (int i = startX; i < endX; i++) {
                temp[i + 1][endY] = matrix[i][endY];
            }

            //좌로 이동
            for (int i = endY; i > startY; i--) {
                temp[endX][i - 1] = matrix[endX][i];
            }

            //위로 이동
            for (int i = endX; i > startX; i--) {
                temp[i - 1][startY] = matrix[i][startY];
            }

            //결과 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = temp[i][j];
                }
            }

            //안쪽 레이어로 한 칸 들어감
            startX += 1;
            startY += 1;
            endX -= 1;
            endY -= 1;
        }

    }

    public static int calMin() {
        int min = Integer.MAX_VALUE;

        //최종 결과 계산
        for (int i = 0; i < N; i++) {
            int result = 0;
            for (int j = 0; j < M; j++) {
                result += matrix[i][j];
            }
            min = Math.min(min, result);
        }

        return min;
    }

    // 연산 순서 전부 조사 (순열)
    public static void dfs(int depth) {
        if (depth == K) {
            // origin -> matrix 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = origin[i][j];
                }
            }

            // 현재 순서대로 회전
            for (int idx = 0; idx < K; idx++) {
                int opIndex = order[idx];
                int rr = cmd[opIndex][0];
                int cc = cmd[opIndex][1];
                int ss = cmd[opIndex][2];

                turn(rr, cc, ss);
            }

            // 최소값 갱신
            int val = calMin();
            if (val < answer) answer = val;

            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        origin = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                origin[i][j] = num;  //원본도 같이 저장
            }
        }

        //  연산들 저장
        cmd = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            cmd[i][0] = r;
            cmd[i][1] = c;
            cmd[i][2] = s;
        }

        // 순열 돌리기
        visited = new boolean[K];
        order = new int[K];
        dfs(0);

        //최종 결과 출력
        System.out.println(answer);
    }
}
