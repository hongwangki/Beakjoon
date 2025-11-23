import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, L; // 널빤지 최소 개수 구할 때 쓸 변수
    static PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(o -> o[0]) // 시작점 기준 오름차순
    );

    public static int solve() {
        int result = 0;
        int covered = 0; // 지금까지 널빤지로 덮은 끝 위치

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int start = arr[0];
            int end = arr[1];

            // 이미 덮은 위치보다 앞에서 웅덩이가 시작하면, 덮은 위치를 웅덩이 시작점까지 당겨줌
            if (covered < start) {
                covered = start;
            }

            // 아직 웅덩이 끝까지 못 덮었으면 널빤지를 계속 깔아줌
            while (covered < end) {
                covered += L; // 널빤지 하나 깔면 L만큼 더 덮임
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int start, end;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end});
        }
        //초기세팅 끝

        //탐색 시작
        int result = solve();

        //결과 출력
        System.out.println(result);
    }
}
