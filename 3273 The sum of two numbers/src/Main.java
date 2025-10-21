import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int []arr;
    static int result=0;
    static int x;

    public static void solve(){
        int L=0;
        int R=N-1;
        while (R>L){
            //투포인터 합이 정답인 경우
            if(arr[L]+ arr[R]== x) {
                result ++;
                L++;
                R--;
            }
            // 투포인터 합이 x보다 작으면 더이상 탐색 불필요
            else if(arr[L]+ arr[R]<x) L++;

            //투포인터 합이 x보다 크면 탐색 수행
            else  R--;
        }

    }
    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        arr=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        x=Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        //초기 세팅 끝

        //탐색 시작
        solve();

        //결과 출력
        System.out.println(result);

    }
}