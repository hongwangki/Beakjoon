import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static char[][] matrix = new char[5][5];

    // "현재 선택된 7칸 집합" 표시
    static boolean[][] selected = new boolean[5][5];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result = 0;

    // 같은 7칸 집합(순서/시작점 다름) 중복 제거용
    static HashSet<Integer> seen = new HashSet<>();

    static void solve(int count, int yCount) {
        // Y가 4명 이상이면 불가능
        if (yCount >= 4) return;

        // 7칸 선택 완료: 중복 제거 후 카운트
        if (count == 7) {
            int mask = 0;
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (selected[x][y]) {
                        int idx = x * 5 + y;
                        mask |= (1 << idx);
                    }
                }
            }
            if (seen.add(mask)) result++;
            return;
        }

        // 현재 선택된 모든 칸에서 확장(프론티어 확장)
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (!selected[x][y]) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                    if (selected[nx][ny]) continue;

                    selected[nx][ny] = true;
                    solve(count + 1, yCount + (matrix[nx][ny] == 'Y' ? 1 : 0));
                    selected[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        // 시작점 25개 모두 시도 (여기서 중복은 seen이 제거해줌)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                selected = new boolean[5][5];
                selected[i][j] = true;
                solve(1, matrix[i][j] == 'Y' ? 1 : 0);
            }
        }

        System.out.println(result);
    }
}
