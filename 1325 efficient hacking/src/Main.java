import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[]arr;
    static boolean[] visited;
    static int[] result;
    static int max = 0;


    //dfs탐색
    public static void dfs(int start, int cur) {
        visited[cur] = true;
        for (int next : arr[cur]) {
            if (!visited[next]) {
                result[start]++;
                dfs(start, next);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기 세팅
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            String[] split = str.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            arr[b].add(a); // b -> a 간선
        }
        // 세팅 끝

        // dfs 탐색
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            dfs(i, i);
        }

        // 최대값 찾기
        for (int i = 1; i <= N; i++) {
            if (result[i] > max) max = result[i];
        }

        // 최대값 가진 노드 번호 출력
        for (int i = 1; i <= N; i++) {
            if (max == result[i]) System.out.print(i + " ");
        }
    }
}
