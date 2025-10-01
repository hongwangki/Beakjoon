import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,H;
    static boolean [][]matrix;
    static int min= Integer.MAX_VALUE;

    /**
     * 사다리게임
     * 모든 시작점들 결과가 마지막 시점이랑 일치하는지검사
     */
    public static boolean game() {
        for(int i=0; i<N; i++) {
            int pos = i;
            for (int h = 0; h < H; h++) {
                if (pos < N-1 && matrix[h][pos]) {
                    // 오른쪽 이동
                    pos++;
                } else if (pos > 0 && matrix[h][pos - 1]) {
                    // 왼쪽 이동
                    pos--;
                }
                // else: 그냥 아래로 이동
            }
            if(pos!=i){
                return false;
            }
        }
        return true;
    }

    public static void solve(int num ,int height,int addCount){

        if (addCount >= min || addCount > 3) return;

        // 모든 위치를 다 훑었으면 여기서 판정
        if (height == H) {
            if (game()) min = Math.min(min, addCount);
            return;
        }

        //  먼저 "안 놓고 진행" 
        if (num == N - 1) solve(0, height + 1, addCount);
        else solve(num + 1, height, addCount);

        // 가로선을 추가할 수 없는 경우 → 이미 '안 놓고' 진행했으니 더 탐색하지 않고 종료
        if ( (matrix[height][num])
                || num == N - 1
                || (num > 0 && matrix[height][num - 1])
                || (num < N - 1 && matrix[height][num + 1]) ) {
            return;
        }

        // 가로선을 추가할 수 있는 경우 (놓고 진행)
        matrix[height][num] = true;
        if (num == N - 1) solve(0, height + 1, addCount + 1);
        else solve(num + 1, height, addCount + 1);
        matrix[height][num] = false;
    }


    public static void main(String[] args)throws IOException {
        //초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        matrix = new boolean[H][N]; //높이, 세로선 부 확인 로직

        //가로선 추가
        for (int i = 0; i < M; i++) {
            int height, connect;
            st = new StringTokenizer(br.readLine());
            height = Integer.parseInt(st.nextToken());
            connect = Integer.parseInt(st.nextToken());
            matrix[height - 1][connect - 1] = true;
        }

        //초기 세팅 끝

        //탐색 시작
        solve(0, 0, 0);


        //결과 출력
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);


    }

}