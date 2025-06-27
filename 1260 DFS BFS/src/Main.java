import java.io.*;
import java.util.*;

public class Main {

    public static void dfs(int V, boolean[][] nodes, boolean[] visited){
        /**
         * node[i][j] = i j가 트루이면 i와 j가 연결된 간선이 존재한다는 변수
         */
        visited[V] = true; // 방문 표시
        System.out.print(V + " ");

        for(int i = 1; i < nodes[V].length; i++){
            // 방문하지 않았고 간선이 존재하는 경우
            if(!visited[i] && nodes[V][i]){
                dfs(i, nodes, visited);
            }
        }
    }

    public static void bfs(int V, boolean[][] nodes, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[V] = true; // 방문 표시
        q.add(V);

        // 큐가 비어있을 때까지 큐를 pop 하면서 인접한 곳 모두 방문
        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v + " ");
            for(int i = 1; i < nodes[v].length; i++){
                // 방문하지 않았고 간선이 존재하는 경우
                if(!visited[i] && nodes[v][i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int N, M, V;
        int v1, v2; // v1과 v2와 연결된 간선

        // N, M, V 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 방문 여부
        boolean[] visited = new boolean[N + 1];
        boolean[][] nodes = new boolean[N + 1][N + 1];

        // 간선 정보 입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            nodes[v1][v2] = true; // 간선이 있다는 것을 true
            nodes[v2][v1] = true;
        }

        dfs(V, nodes, visited); // dfs 탐색 실행
        System.out.println();

        // dfs에서 사용했기 때문에 방문 초기화
        for (int i = 0; i <= N; i++) {
            visited[i] = false;
        }

        bfs(V, nodes, visited); // bfs 탐색 실행
    }
}
