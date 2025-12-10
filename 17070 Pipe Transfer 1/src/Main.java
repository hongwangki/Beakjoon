import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static int result=0;

    //pos 1:현재 가로방향, 2:현재 세로방향 3: 현재 대각선방향
    public static void solve(int x, int y, int pos){

        if(x==N-1 && y==N-1){
            result++;
            return;
        }

        //가로 배치가 가능한 경우
        if(pos!=2 && y+1<matrix[0].length && matrix[x][y+1]!=1){
            solve(x, y+1, 1);
        }

        //세로 배치가 가능한 경우
        if(pos !=1 && x+1<matrix.length && matrix[x+1][y]!=1){
            solve(x+1, y, 2);
        }

        //대각선 배치가 가능한 경우
        if(x+1<matrix.length && y+1<matrix[0].length
                && matrix[x+1][y+1]!=1 && matrix[x][y+1]!=1 && matrix[x+1][y]!=1){
            solve(x+1, y+1, 3);
        }
    }

    public static void main(String[] args) throws IOException {
        //초기세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        matrix=new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //초기 세팅 끝

        //파이프 시작위치 (0,1)
        solve(0,1,1);

        //결과 출력
        System.out.println(result);
    }
}
