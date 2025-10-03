import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minGold = Integer.MAX_VALUE;

    // 꽃을 생성해서 골드를 반환하는 메서드
    //생성할 수 없다면 -1 반환
    public static int makeFlower(int x, int y) {
        int totalGold = matrix[x][y];
        if (visited[x][y]) return -1;
        visited[x][y] = true;

        // 상 하 좌 우 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];


            // 꽃을 필 수 없는 경우 원복 후 반환
            if (visited[nx][ny]) {
                // 중심 해제
                visited[x][y] = false;

                // 지금까지 방문 처리한 방향만 false
                for (int k = 0; k < d; k++) {
                    int px = x + dx[k];
                    int py = y + dy[k];
                    visited[px][py] = false;
                }
                return -1;
            }
            visited[nx][ny] = true;
            totalGold += matrix[nx][ny];
        }
        return totalGold;
    }

    //꽃 원복 함수
    public static void rollback(int x,int y){
        visited[x][y] = false;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            visited[nx][ny] = false;
        }
    }

    public static void solve(int count, int curGold) {
        if (count == 3) { // 3송이 완성
            minGold = Math.min(minGold, curGold);
            return;
        }
        //이미 골드가 최소 골드보다 많으면 리턴
        if(curGold>minGold) return;

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                int gold = makeFlower(i, j);
                if(gold!=-1){
                    solve(count+1,curGold+gold);
                    // 방금 심은 꽃만 원복
                    rollback(i,j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //초기세팅 끝

        //탐색 시작
        visited = new boolean[N][N];
        solve(0,0);
        System.out.println(minGold);

    }


}
