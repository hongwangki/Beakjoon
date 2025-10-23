import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T;
    static int[][] matrix;
    static int[][] temp;
    static int []wind1={-1,-1};
    static int []wind2={-1,-1};
    static int []dx={-1,1,0,0};
    static int []dy={0,0,-1,1};
    static int result;

    public static void solve(){
        //T 초까지 진행
        for(int i=0; i<T; i++){
            //확산
            spread();
            //확산 결과(temp)를 matrix에 반영
            for (int j = 0; j < R; j++) {
                System.arraycopy(temp[j], 0, matrix[j], 0, C);
            }
            //확산 후 바람 전파
            wind();

        }
        //결과 수치량 출력
        sumResult();
    }

    //1초 확산하는 메서드
    public static void spread(){
        temp = new int[R][C];

        for (int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if (matrix[i][j] == -1) { // 청정기 위치 유지
                    temp[i][j] = -1;
                    continue;
                }
                int count=0; //전파 할 수 있는 개수
                //상 하 좌 우 탐색
                for(int d=0; d<4; d++){
                    int nx= i+dx[d];
                    int ny= j+dy[d];

                    //벽이나 공기청정기인 경우
                    if(nx<0 || ny<0 || nx>=R || ny>=C || matrix[nx][ny]==-1) continue;

                    //아닌경우 확산 값 더하기
                    count++;
                    // ⌊Ar,c/5⌋
                    temp[nx][ny]+=matrix[i][j]/5;
                }

                //(r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다
                temp[i][j]+= matrix[i][j]-(matrix[i][j]/5) * count;
            }

        }

    }

    //바람 전파
    public static void wind() {
        int[][] temp1 = new int[R][C];
        for (int i = 0; i < R; i++) {
            System.arraycopy(matrix[i], 0, temp1[i], 0, C);
        }

        int up = wind1[0];
        int down = wind2[0];

        // 위쪽(반시계)
        for (int i = C - 1; i > 1; i--) matrix[up][i] = temp1[up][i - 1]; // 오른쪽
        for (int i = 0; i < up; i++) matrix[i][C - 1] = temp1[i + 1][C - 1]; // 위로
        for (int i = 0; i < C - 1; i++) matrix[0][i] = temp1[0][i + 1]; // 왼쪽
        for (int i = up - 1; i > 0; i--) matrix[i][0] = temp1[i - 1][0]; // 아래로
        matrix[up][1] = 0; matrix[up][0] = -1;

        // 아래쪽(시계)
        for (int i = C - 1; i > 1; i--) matrix[down][i] = temp1[down][i - 1]; // 오른쪽
        for (int i = R - 1; i > down; i--) matrix[i][C - 1] = temp1[i - 1][C - 1]; // 아래로
        for (int i = 0; i < C - 1; i++) matrix[R - 1][i] = temp1[R - 1][i + 1]; // 왼쪽
        for (int i = down + 1; i < R - 1; i++) matrix[i][0] = temp1[i + 1][0]; // 위로
        matrix[down][1] = 0; matrix[down][0] = -1;
    }


    public static void sumResult(){
        int sum=0;
        for (int i=0; i<R; i++){
            for(int j=0; j<C; j++) {
                if(matrix[i][j]==0 || matrix[i][j]==-1) continue;
                sum+=matrix[i][j];
            }
        }
        result=sum;
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        matrix=new int[R][C];
        temp=new int[R][C];

        for (int i=0; i<R; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
                if (matrix[i][j] == -1) {
                    if (wind1[0] == -1) {
                        wind1[0] = i; wind1[1] = j;
                    } else {
                        wind2[0] = i; wind2[1] = j;
                    }
                }
            }

        }

        //초기 세팅 끝


        //탐색 시작
        solve();

        //결과 출력
        System.out.println(result);
    }
}