import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] matrix ;
    static boolean[][] visited;
    static int N; //행열 사이즈

    //dfs탐색
    public static void dfs(int x, int y, int N){
        visited[x][y] = true;

        //상
        if(x>0&& matrix[x-1][y] >N && !visited[x-1][y]){
            dfs(x-1,y,N);
        }

        //하
        if(x+1<matrix.length && matrix[x+1][y]>N && !visited[x+1][y]){
            dfs(x+1,y,N);
        }

        //좌
        if(y>0 && matrix[x][y-1]>N && !visited[x][y-1]){
            dfs(x,y-1,N);
        }

        //우
        if(y+1<matrix[0].length && matrix[x][y+1]>N && !visited[x][y+1]){
            dfs(x,y+1,N);
        }

    }

    //bfs탐색
    public static void bfs(int x, int y, int N){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            //상
            if(x1>0&& matrix[x1-1][y1] >N && !visited[x1-1][y1]){
                q.offer(new int[]{x1-1,y1});
                visited[x1-1][y1] = true;
            }

            //하
            if(x1+1<matrix.length && matrix[x1+1][y1]>N && !visited[x1+1][y1]){
                q.offer(new int[]{x1+1,y1});
                visited[x1+1][y1] = true;

            }

            //좌
            if(y1>0 && matrix[x1][y1-1]>N && !visited[x1][y1-1]){
                q.offer(new int[]{x1,y1-1});
                visited[x1][y1-1] = true;
            }

            //우
            if(y1+1<matrix[0].length && matrix[x1][y1+1]>N && !visited[x1][y1+1]){
                q.offer(new int[]{x1,y1+1});
                visited[x1][y1+1] = true;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        int result=0;
        int max=0;
        int matrixMaxValue=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        visited = new boolean[N][N];

        //행렬 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());

                //행렬 원소중 최대값 구하기
                if(matrix[i][j]>matrixMaxValue){
                    matrixMaxValue=matrix[i][j];
                }
            }
        }


      //잠기는 구역을 0부터 행렬 최대 원소까지 반복
       for (int k = 0; k <= matrixMaxValue; k++) {

           //행렬을 모두 순회하면서 && 물에 잠기지 않고 && 방문하지 않은곳이라면
           for(int i=0;i<N;i++){
               for(int j=0;j<N;j++){
                   if(!visited[i][j] && matrix[i][j]>k){
//                       dfs(i,j,k);
                       bfs(i,j,k);
                       result++;
                   }
               }
           }
        if(max<result){
            max = result;
        }
        result=0;
        visited = new boolean[N][N];
       }


        //결과 출력
        System.out.println(max);

    }
}