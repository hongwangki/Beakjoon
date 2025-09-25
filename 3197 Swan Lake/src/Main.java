import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] matrix;
    static boolean[][] visited;      // 물 확장 방문(재활용)
    static boolean[][] swanVisited;  // 백조 이동 방문
    static List<Integer> swanPos = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> nextWaterQ = new LinkedList<>();
    static Queue<int[]> swanQ = new LinkedList<>();
    static Queue<int[]> nextSwanQ = new LinkedList<>();

    // 두 백조가 만날 수 있으면 true
    public static boolean swanBFS(int x, int y) {
        while (!swanQ.isEmpty()) {
            int[] cur = swanQ.poll();
            int cx = cur[0], cy = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (swanVisited[nx][ny]) continue;

                // 다른 백조를 만난 경우 즉시 종료
                if (matrix[nx][ny] == 'L') return true;

                // 물이면 오늘 계속 이동
                if (matrix[nx][ny] == '.') {
                    swanQ.add(new int[]{nx, ny});
                    swanVisited[nx][ny] = true;
                }
                // 얼음이면 내일 시도 목록에 추가
                else if (matrix[nx][ny] == 'X') {
                    nextSwanQ.add(new int[]{nx, ny});
                    swanVisited[nx][ny] = true;
                }
            }
        }
        return false;
    }

    // 물의 경계에서만 얼음을 녹인다
    public static void melt() {
        while (!waterQ.isEmpty()) {
            int[] cur = waterQ.poll();
            int cx = cur[0], cy = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visited[nx][ny]) continue;

                // 물이 새로 퍼질 수 있는 얼음이면 녹여서 내일의 물로
                if (matrix[nx][ny] == 'X') {
                    matrix[nx][ny] = '.';
                    nextWaterQ.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
                // 이미 물인 칸이면 오늘 물로 이어서 확장(경계 넓히기)
                else {
                    waterQ.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void bfs() {
        // 초기: 첫 번째 백조 위치에서 시작
        swanVisited = new boolean[R][C];
        int sx = swanPos.get(0), sy = swanPos.get(1);
        swanQ.add(new int[]{sx, sy});
        swanVisited[sx][sy] = true;

        // 하루 단위 반복
        while (true) {
            // 오늘 물 위에서 백조가 갈 수 있는 만큼만 이동
            if (swanBFS(sx, sy)) break;

            // 아직 못 만났다면 하루 경과
            result++;

            // 오늘 물의 경계에서 얼음을 녹임(내일 물 준비)
            melt();

            // 내일 준비된 큐로 교체
            waterQ = nextWaterQ;
            nextWaterQ = new LinkedList<>();

            swanQ = nextSwanQ;
            nextSwanQ = new LinkedList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        matrix = new char[R][C];
        visited = new boolean[R][C];   // 물 확장 방문

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = line.charAt(j);
                matrix[i][j] = ch;

                // 백조 위치 저장 (두 번 들어옴)
                if (ch == 'L') {
                    swanPos.add(i);
                    swanPos.add(j);
                    // 백조가 있는 칸도 물 취급
                    waterQ.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (ch == '.') {
                    // 초기 물들을 전부 물 큐에 넣고 방문 표시
                    waterQ.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 시뮬레이션 시작
        bfs();

        System.out.println(result);
    }
}
