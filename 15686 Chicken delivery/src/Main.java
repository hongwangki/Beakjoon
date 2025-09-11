import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int N, M;
    static int minResult = 0;
    static int result = 0;
    static List<Integer> chickenHomeX = new ArrayList<>();
    static List<Integer> chickenHomeY = new ArrayList<>();
    static int chickenHomeCount; // 치킨집 개수
    static boolean[] selected; // 선택된 치킨집 표시

    // 두 점 사이 거리
    public static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // 치킨집 M개 조합 생성 (백트래킹)
    static void comb(int depth, int start) {
        if (depth == M) {
            minResult = Math.min(minResult, solve());
            return;
        }
        for (int i = start; i < chickenHomeCount; i++) {
            selected[i] = true;
           comb(depth + 1, i + 1);
            selected[i] = false;
        }
    }

    //최소 거리 합산
    static int solve(){
        int sum=0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == 1){
                    //집 좌표 가져오기
                    int curX= i+1;
                    int curY= j+1;
                    int best =Integer.MAX_VALUE;
                    //거리 계산
                    for(int k = 0; k < chickenHomeCount; k++){
                        if(!selected[k]) continue;
                        int chickenX = chickenHomeX.get(k);
                        int chickenY = chickenHomeY.get(k);

                        int distance = distance(chickenX, chickenY, curX, curY);
                        if(distance < best){
                            best = distance;
                        }
                    }
                    sum+=best;
                    if(sum>=minResult) return sum;
                }
            }
        }
        return sum;
    }


    // 치킨집 위치 수집
    public static void chickenLocation() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 2) {
                    chickenHomeX.add(i + 1);
                    chickenHomeY.add(j + 1);
                }
            }
        }
        chickenHomeCount = chickenHomeX.size();
    }

    public static void main(String[] args) throws IOException {

        //초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        chickenLocation();

        //초기 세팅 끝

        // 최소값 초기화 및 선택배열 준비
        minResult = Integer.MAX_VALUE;
        selected = new boolean[chickenHomeCount];

        // 모든 조합 시도
        comb(0, 0);

        // 정답 출력
        System.out.println(minResult);
    }
}
