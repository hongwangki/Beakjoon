import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] matrix;
    static int[][] dist;
    static int[][] fireTime;
    static boolean [][]fireVisited;
    static boolean [][]visited;
    static int startX,startY;
    static int startFireX,startFireY;
    static int resultX, resultY; //미로를 나가기전 마지막 위치

    public static void fireTimeBFS(int x, int y){
        Queue<int[]> q=new LinkedList<>();

        //fireTime/visited 초기화 + INF 세팅
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                fireVisited[i][j] = false;
                fireTime[i][j] = 1000000000;
            }
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (matrix[i][j] == 'F') {
                    fireVisited[i][j] = true;
                    fireTime[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 상
            if (curX > 0 && !fireVisited[curX - 1][curY] && matrix[curX-1][curY] != '#') {
                fireVisited[curX - 1][curY] = true;
                fireTime[curX-1][curY]=fireTime[curX][curY]+1;
                q.add(new int[]{curX-1, curY });
            }
            // 하
            if (curX + 1 < N && !fireVisited[curX + 1][curY] && matrix[curX+1][curY] != '#') {
                fireVisited[curX + 1][curY] = true;
                fireTime[curX+1][curY]=fireTime[curX][curY]+1;
                q.add(new int[]{curX+1, curY});
            }
            // 좌
            if (curY > 0 && !fireVisited[curX][curY - 1] && matrix[curX][curY-1] != '#') {
                fireVisited[curX][curY - 1] = true;
                fireTime[curX][curY-1]=fireTime[curX][curY]+1;
                q.add(new int[]{curX, curY - 1});
            }
            // 우
            if (curY + 1 < M && !fireVisited[curX][curY + 1] && matrix[curX][curY+1] != '#'){
                fireVisited[curX][curY + 1] = true;
                fireTime[curX][curY+1]=fireTime[curX][curY]+1;
                q.add(new int[]{curX, curY + 1});
            }
        }
    }

    public static int bfs(int x, int y){
        Queue<int[]> q=new LinkedList<>();
        visited[x][y]=true;
        dist[x][y]=0;
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            //탈출할 수 있는지 확인
            if (curX == 0 || curX == N - 1 || curY == 0 || curY == M - 1) {
                resultX=curX;
                resultY=curY;
                return dist[curX][curY] + 1;
            }

            //상
            if (curX > 0 && !visited[curX - 1][curY]
                    && (matrix[curX-1][curY]=='.'||matrix[curX-1][curY]=='J')) {
                int nx = curX-1, ny = curY;
                int nextT = dist[curX][curY] + 1;
                if (fireTime[nx][ny] > nextT) {
                    q.add(new int[]{nx, ny});
                    dist[nx][ny]=nextT;
                    visited[nx][ny]=true;
                }
            }
            //하
            if (curX + 1 < N && !visited[curX + 1][curY]
                    && (matrix[curX+1][curY]=='.'||matrix[curX+1][curY]=='J')) {
                int nx = curX+1, ny = curY;
                int nextT = dist[curX][curY] + 1;
                if (fireTime[nx][ny] > nextT) {
                    q.add(new int[]{nx, ny});
                    dist[nx][ny]=nextT;
                    visited[nx][ny]=true;
                }
            }
            //좌
            if (curY > 0 && !visited[curX][curY - 1]
                    && (matrix[curX][curY-1]=='.'||matrix[curX][curY-1]=='J')) {
                int nx = curX, ny = curY-1;
                int nextT = dist[curX][curY] + 1;
                if (fireTime[nx][ny] > nextT) {
                    q.add(new int[]{nx, ny});
                    dist[nx][ny]=nextT;
                    visited[nx][ny]=true;
                }
            }
            //우
            if (curY + 1 < M && !visited[curX][curY + 1]
                    && (matrix[curX][curY+1]=='.'||matrix[curX][curY+1]=='J')){
                int nx = curX, ny = curY+1;
                int nextT = dist[curX][curY] + 1;
                if (fireTime[nx][ny] > nextT) {
                    q.add(new int[]{nx, ny});
                    dist[nx][ny]=nextT;
                    visited[nx][ny]=true;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        //초기세팅
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        matrix=new char[N][M];
        visited=new boolean[N][M];
        fireVisited=new boolean[N][M];
        dist=new int[N][M];
        fireTime=new int[N][M];

        for (int i=0; i<N; i++){
            StringBuilder sb=new StringBuilder(br.readLine());
            for (int j=0; j<M; j++){
                matrix[i][j]=sb.charAt(j);
                //시작 위치 기억
                if(matrix[i][j]=='J'){
                    startX=i;
                    startY=j;
                }
                //불 시작위치 기억
                if(matrix[i][j]=='F'){
                    startFireX=i;
                    startFireY=j;
                }
            }
        }

        //탐색시작
        fireTimeBFS(startFireX,startFireY);
        int ans = bfs(startX, startY);

        //결과출력
        if(ans==0 || ans-1>=fireTime[resultX][resultY]){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(ans);
        }
    }
}
