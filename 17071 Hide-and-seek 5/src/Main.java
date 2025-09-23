import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[][] visited = new boolean[500001][2]; // visited[pos][time%2]

    public static int solve(int pos) {
        Queue<int[]> q = new LinkedList<>();
        // queue : 현재 위치, 현재 시간, 동생 가속 누적
        q.add(new int[]{pos, 0, 0});
        visited[pos][0] = true; // 시작점 방문 표시(짝수 시간)

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int curPos = arr[0];
            int curTime = arr[1];
            int curSpeed = arr[2]; // t(t+1)/2 누적값

            // 현재 시간의 동생 위치
            int broPos = K + curSpeed;
            if (broPos > 500000) return -1;

            // 같은 시간대에 도달 가능한 모든 칸 중 broPos가 포함되면 만남
            if (visited[broPos][curTime % 2]) return curTime;

            // 아래는 다음 시간대로 전이
            int nextTime = curTime + 1;
            int nextParity = nextTime % 2;
            int nextSpeed = curSpeed + nextTime;

            // +1 이동
            if (curPos < 500000 && !visited[curPos + 1][nextParity]) {
                visited[curPos + 1][nextParity] = true;
                q.add(new int[]{curPos + 1, nextTime, nextSpeed});
            }
            // -1 이동
            if (curPos > 0 && !visited[curPos - 1][nextParity]) {
                visited[curPos - 1][nextParity] = true;
                q.add(new int[]{curPos - 1, nextTime, nextSpeed});
            }
            // *2 이동
            if (curPos * 2 <= 500000 && !visited[curPos * 2][nextParity]) {
                visited[curPos * 2][nextParity] = true;
                q.add(new int[]{curPos * 2, nextTime, nextSpeed});
            }
        }
        return -1; // 못 만나는 경우
    }

    public static void main(String[] args) throws IOException {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 탐색 시작
        int result = solve(N);

        // 결과 출력
        System.out.println(result);
    }
}
