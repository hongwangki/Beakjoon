import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int x1,y1,x2,y2;
    static char[][] matrix;
    static boolean[][]visited=new boolean[301][301];


    public static int bfs(int x, int y){
        int result=0;
        boolean flag=false;
        visited[x][y]=true;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});

        while (true){
            result++;
            visited=new boolean[301][301]; //방문여부 초기화
            visited[x][y]=true;
            q.add(new int[]{x,y});
            while (!q.isEmpty()){
                int[] arr = q.poll();
                int curX= arr[0];
                int curY= arr[1];
                //상하좌우에 목적지가 있을 경우
                if((curX>0&&matrix[curX-1][curY]=='#')||( curY<M-1&&matrix[curX][curY+1]=='#')
                    ||(curX<N-1 &&matrix[curX+1][curY]=='#')||(curY>0 && matrix[curX][curY-1]=='#')) return result;

                //상 이며 0일 경우
                if(curX>0 && !visited[curX-1][curY] && matrix[curX-1][curY]=='0'){
                    q.add(new int[]{curX-1,curY});
                    visited[curX-1][curY]=true;
                }

                //상 이며 1일 경우
                if(curX>0 && !visited[curX-1][curY] && matrix[curX-1][curY]=='1'){
                    matrix[curX-1][curY]='0';
                    visited[curX-1][curY]=true;
                }


                //하 이며 0일 경우
                if(curX<N-1 && !visited[curX+1][curY] && matrix[curX+1][curY]=='0'){
                    q.add(new int[]{curX+1,curY});
                    visited[curX+1][curY]=true;
                }

                //하 이며 1일 경우
                if(curX<N-1 && !visited[curX+1][curY] && matrix[curX+1][curY]=='1'){
                    matrix[curX+1][curY]='0';
                    visited[curX+1][curY]=true;
                }


                //좌 이며 0일 경우
                if(curY>0 && !visited[curX][curY-1] && matrix[curX][curY-1]=='0'){
                    q.add(new int[]{curX,curY-1});
                    visited[curX][curY-1]=true;
                }
                //좌 이며 1일 경우
                if(curY>0 && !visited[curX][curY-1] && matrix[curX][curY-1]=='1'){
                    matrix[curX][curY-1]='0';
                    visited[curX][curY-1]=true;
                }

                //우 이며 0일 경우
                if(curY<M-1 && !visited[curX][curY+1] && matrix[curX][curY+1]=='0'){
                    q.add(new int[]{curX,curY+1});
                    visited[curX][curY+1]=true;

                }

                //우 이며 1일 경우
                if(curY<M-1 && !visited[curX][curY+1] && matrix[curX][curY+1]=='1'){
                    matrix[curX][curY+1]='0';
                    visited[curX][curY+1]=true;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        matrix=new char[N][M];

        StringTokenizer st1=new StringTokenizer(br.readLine());
        x1=Integer.parseInt(st1.nextToken());
        y1=Integer.parseInt(st1.nextToken());
        x2=Integer.parseInt(st1.nextToken());
        y2=Integer.parseInt(st1.nextToken());

        for (int i=0; i<N; i++){
            StringBuilder sb=new StringBuilder(br.readLine());
            for(int j=0; j<M; j++){
                matrix[i][j]=sb.charAt(j);
            }
        }

        //탐색 시작
        int result = bfs(x1-1, y1-1);

        //결과 출력
        System.out.println(result);


    }
}