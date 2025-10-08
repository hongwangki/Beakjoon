import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C,K;
    static char[][] matrix;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int result=0; //결과


    public static void solve(int x, int y, int dist){
       //거리가 6이고 목적지인 경우
        if(dist==K && x==0 && y==C-1) {
            result++;
            return;
        }

        //탐색이 더이상 필요 없을때
        if(dist>K) return;

        for(int d=0; d<4; d++){
            int nx=x+dx[d];
            int ny=y+dy[d];

            if(nx<0 || ny<0 || nx>R-1 || ny>C-1) continue;
            //방문하지 않았고 장애물이 아니라면 방문
            if(!visited[nx][ny] && matrix[nx][ny]!='T'){
                visited[nx][ny]=true;
                solve(nx,ny,dist+1);
                visited[nx][ny]=false; //백트래킹
            }

        }
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        matrix=new char[R][C];
        visited=new boolean[R][C];

        for(int i=0; i<R; i++){
            StringBuilder sb=new StringBuilder(br.readLine());
            for(int j=0; j<C; j++){
                matrix[i][j]=sb.charAt(j);
            }
        }
        //초기 세팅 끝


        //출발지 부터 탐색 시작
        visited[R-1][0]=true;
        solve(R-1,0,1);

        //결과 출력
        System.out.println(result);


    }
}