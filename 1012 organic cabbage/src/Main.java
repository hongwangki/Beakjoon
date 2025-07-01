import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int [][] matrix;
    static boolean [][] visited;

    //bfs 탐색
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            //상
            if(x1>0 && matrix[x1-1][y1] == 1 &&  !visited[x1-1][y1] ){
                q.offer(new int[]{x1-1, y1});
                visited[x1-1][y1] = true;
            }
            //하
            if(x1+1<matrix.length && !visited[x1+1][y1] && matrix[x1+1][y1] == 1){
                q.offer(new int[]{x1+1, y1});
                visited[x1+1][y1] = true;
            }
            //좌
            if (y1>0  && matrix[x1][y1-1] == 1 &&  !visited[x1][y1-1]){
                q.offer(new int[]{x1, y1-1});
                visited[x1][y1-1] = true;
            }
            //우
            if(y1+1<matrix[0].length && !visited[x1][y1+1] && matrix[x1][y1+1] == 1){
                q.offer(new int[]{x1, y1+1});
                visited[x1][y1+1] = true;
            }
        }

    }

    //dfs 탐색
    public static void dfs(int x, int y){
        visited[x][y] = true;

        //상
        if(x>0 && matrix[x-1][y] == 1 &&  !visited[x-1][y] ){
            dfs(x-1, y);
        }
        //하
        if(x+1<matrix.length && !visited[x+1][y] && matrix[x+1][y] == 1){
            dfs(x+1, y);
        }
        //좌
        if (y>0  && matrix[x][y-1] == 1 &&  !visited[x][y-1]){
            dfs(x, y-1);
        }
        //우
        if(y+1<matrix[0].length && !visited[x][y+1] && matrix[x][y+1] == 1){
            dfs(x, y+1);
        }

    }


    public static void main(String[] args) throws IOException {

        int count; //실행 횟수
        int N, M; //행열 사이즈
        int inputSize; //배추 입력 횟수
        int result = 0; //결과

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(br.readLine()); //실행 횟수 입력


        for (int z = 0; z < count; z++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //행열 사이즈와 배추 입력 횟수 입력
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            inputSize = Integer.parseInt(st.nextToken());

            //행열과 배추 방문 영역 사이즈 할당
            matrix = new int[N][M];
            visited = new boolean[N][M];

            //입력으로 배추 심기
            for (int i = 0; i < inputSize; i++) {
                    String[] input = br.readLine().split(" ");
                    int a = Integer.parseInt(input[0]);
                    int b = Integer.parseInt(input[1]);

                    matrix[a][b] = 1;
            }

            //dfs or bfs 탐색 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == 1 && !visited[i][j]) {
//                        dfs(i, j);
                        bfs(i,j);
                        result++;
                    }
                }
            }

            //결과 출력

            System.out.println(result);

            //초기화
            visited = new boolean[N][M];
            result=0;

        }
    }
}