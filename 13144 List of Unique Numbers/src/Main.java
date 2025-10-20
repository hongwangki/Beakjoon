import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int [] progression; //수열 배열


    public static long solve() {
        long result = 0;
        int L = 0;
        Set<Integer> set = new HashSet<>();

        for (int R = 0; R < N; R++) {
            // progression[R]가 중복이면, 중복이 해소될 때까지 L을 이동하며 제거
            while (set.contains(progression[R])) {
                set.remove(progression[L]);
                L++;
            }
            set.add(progression[R]);
            // R을 끝으로 하는 유효 구간 수 = (R - L + 1)
            result += (R - L + 1);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        progression=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            progression[i]=Integer.parseInt(st.nextToken());
        }
        //초기 세팅 끝

        //탐색
        long result = solve();

        //결과 출력
        System.out.println(result);

    }
}