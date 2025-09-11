import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] matrix;
    static int N,M;
    static boolean[][] visited;
    static int maxResult=0;


    public static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        int sx = startX, sy = startY;

        // 방문/거리 초기화
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        dist[sx][sy] = 0;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];


            // 상
            if (curX > 0 && !visited[curX-1][curY] && matrix[curX-1][curY] == 'L') {
                visited[curX-1][curY] = true;
                dist[curX-1][curY] = dist[curX][curY] + 1;
                q.add(new int[]{curX-1, curY});
                if(maxResult<dist[curX-1][curY]) maxResult=dist[curX-1][curY];
            }
            // 하
            if (curX + 1 < N && !visited[curX+1][curY] && matrix[curX+1][curY] == 'L') {
                visited[curX+1][curY] = true;
                dist[curX+1][curY] = dist[curX][curY] + 1;
                q.add(new int[]{curX+1, curY});
                if(maxResult<dist[curX+1][curY]) maxResult=dist[curX+1][curY];
            }
            // 좌
            if (curY > 0 && !visited[curX][curY-1] && matrix[curX][curY-1] == 'L') {
                visited[curX][curY-1] = true;
                dist[curX][curY-1] = dist[curX][curY] + 1;
                q.add(new int[]{curX, curY-1});
                if(maxResult<dist[curX][curY-1]) maxResult=dist[curX][curY-1];
            }
            // 우
            if (curY + 1 < M && !visited[curX][curY+1] && matrix[curX][curY+1] == 'L') {
                visited[curX][curY+1] = true;
                dist[curX][curY+1] = dist[curX][curY] + 1;
                q.add(new int[]{curX, curY+1});
                if(maxResult<dist[curX][curY+1]) maxResult=dist[curX][curY+1];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        //초기 입력 세팅
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        matrix=new char[N][M];
        visited=new boolean[N][M];

        for (int i=0; i<N; i++){
            StringBuilder sb= new StringBuilder(br.readLine());
            for (int j=0; j<M; j++){
                matrix[i][j]=sb.charAt(j);
            }
        }
        //세팅 끝

        //육지지역에서 탐색 시작
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(matrix[i][j]=='L'){
                    bfs(i,j);
                }
            }
        }

        //결과 출력
        System.out.println(maxResult);

    }
}