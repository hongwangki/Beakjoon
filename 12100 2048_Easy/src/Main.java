import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[][] matrix;
    static int maxValue=Integer.MIN_VALUE;

    public static void solve(int pos, int count){
        //5번 이동했다면 최대값 갱신
        if(count==5) {
            checkMax();
            return;
        }

        //행렬 복사해두기
        int[][] backUp= new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                backUp[i][j]=matrix[i][j];
            }
        }

        // 3) 현재 pos 방향으로 한 번 이동(상=0, 하=1, 좌=2, 우=3)
        switch (pos) {
            case 0: moveUp(matrix);    break;
            case 1: moveDown(matrix);  break;
            case 2: moveLeft(matrix);  break;
            case 3: moveRight(matrix); break;
            default:
        }


        for(int i=0; i<4; i++){
            solve(i,count+1);
        }

        //원복
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                matrix[i][j]= backUp[i][j];
            }
        }
    }

    // 위로 이동
    public static void moveUp(int[][] matrix) {
        int N = matrix.length;
        for (int col = 0; col < N; col++) {
            boolean[] merged = new boolean[N];               // 이번 턴에 합쳐진 위치(해당 열)
            for (int row = 1; row < N; row++) {
                if (matrix[row][col] == 0) continue;

                // 1) 바로 위가 같으면 즉시 합치기
                if (matrix[row - 1][col] == matrix[row][col] && !merged[row - 1]) {
                    matrix[row - 1][col] *= 2;
                    matrix[row][col] = 0;
                    merged[row - 1] = true;
                    continue;
                }

                // 2) 위가 0이면 쭉 올리기
                if (matrix[row - 1][col] == 0) {
                    int k = row;
                    while (k > 0 && matrix[k - 1][col] == 0) {
                        matrix[k - 1][col] = matrix[k][col];
                        matrix[k][col] = 0;
                        k--;
                    }
                    // 올린 뒤 바로 위가 같으면 1회 합치기
                    if (k > 0 && matrix[k - 1][col] == matrix[k][col] && !merged[k - 1]) {
                        matrix[k - 1][col] *= 2;
                        matrix[k][col] = 0;
                        merged[k - 1] = true;
                    }
                }
            }
        }
    }

    // 아래로 이동
    public static void moveDown(int[][] matrix) {
        int N = matrix.length;
        for (int col = 0; col < N; col++) {
            boolean[] merged = new boolean[N];               // 이번 턴에 합쳐진 위치(해당 열)
            for (int row = N - 2; row >= 0; row--) {
                if (matrix[row][col] == 0) continue;

                // 1) 바로 아래가 같으면 즉시 합치기
                if (matrix[row + 1][col] == matrix[row][col] && !merged[row + 1]) {
                    matrix[row + 1][col] *= 2;
                    matrix[row][col] = 0;
                    merged[row + 1] = true;
                    continue;
                }

                // 2) 아래가 0이면 쭉 내리기
                if (matrix[row + 1][col] == 0) {
                    int k = row;
                    while (k + 1 < N && matrix[k + 1][col] == 0) {
                        matrix[k + 1][col] = matrix[k][col];
                        matrix[k][col] = 0;
                        k++;
                    }
                    // 내린 뒤 바로 아래가 같으면 1회 합치기
                    if (k + 1 < N && matrix[k + 1][col] == matrix[k][col] && !merged[k + 1]) {
                        matrix[k + 1][col] *= 2;
                        matrix[k][col] = 0;
                        merged[k + 1] = true;
                    }
                }
            }
        }
    }

    // 좌로 이동
    public static void moveLeft(int[][] matrix) {
        int N = matrix.length;
        for (int row = 0; row < N; row++) {
            boolean[] merged = new boolean[N];               // 이번 턴에 합쳐진 위치(해당 행)
            for (int col = 1; col < N; col++) {
                if (matrix[row][col] == 0) continue;

                // 1) 바로 왼쪽이 같으면 즉시 합치기
                if (matrix[row][col - 1] == matrix[row][col] && !merged[col - 1]) {
                    matrix[row][col - 1] *= 2;
                    matrix[row][col] = 0;
                    merged[col - 1] = true;
                    continue;
                }

                // 2) 왼쪽이 0이면 쭉 당기기
                if (matrix[row][col - 1] == 0) {
                    int k = col;
                    while (k - 1 >= 0 && matrix[row][k - 1] == 0) {
                        matrix[row][k - 1] = matrix[row][k];
                        matrix[row][k] = 0;
                        k--;
                    }
                    // 당긴 뒤 바로 왼쪽이 같으면 1회 합치기
                    if (k - 1 >= 0 && matrix[row][k - 1] == matrix[row][k] && !merged[k - 1]) {
                        matrix[row][k - 1] *= 2;
                        matrix[row][k] = 0;
                        merged[k - 1] = true;
                    }
                }
            }
        }
    }

    // 우로 이동
    public static void moveRight(int[][] matrix) {
        int N = matrix.length;
        for (int row = 0; row < N; row++) {
            boolean[] merged = new boolean[N];               // 이번 턴에 합쳐진 위치(해당 행)
            for (int col = N - 2; col >= 0; col--) {
                if (matrix[row][col] == 0) continue;

                // 1) 바로 오른쪽이 같으면 즉시 합치기
                if (matrix[row][col + 1] == matrix[row][col] && !merged[col + 1]) {
                    matrix[row][col + 1] *= 2;
                    matrix[row][col] = 0;
                    merged[col + 1] = true;
                    continue;
                }

                // 2) 오른쪽이 0이면 쭉 밀기
                if (matrix[row][col + 1] == 0) {
                    int k = col;
                    while (k + 1 < N && matrix[row][k + 1] == 0) {
                        matrix[row][k + 1] = matrix[row][k];
                        matrix[row][k] = 0;
                        k++;
                    }
                    // 민 뒤 바로 오른쪽이 같으면 1회 합치기
                    if (k + 1 < N && matrix[row][k + 1] == matrix[row][k] && !merged[k + 1]) {
                        matrix[row][k + 1] *= 2;
                        matrix[row][k] = 0;
                        merged[k + 1] = true;
                    }
                }
            }
        }
    }

    //5번 시행 후 최대 값 갱신
    public static void checkMax(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                maxValue=Math.max(maxValue,matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
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

        //탐색 시작(0: 상,  1: 하,  2: 좌,  3: 우)
        for(int i=0; i<4; i++){
            solve(i,0);
        }

        System.out.println(maxValue);
    }
}