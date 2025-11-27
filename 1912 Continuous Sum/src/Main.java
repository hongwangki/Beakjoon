import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] series;
    static int[] dp;
    static int max=Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        series=new int[N];
        dp=new int[N];


        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            series[i]=Integer.parseInt(st.nextToken());
        }
        //초기 세팅 끝

        dp[0]=series[0];

        for(int i=1; i<N; i++){
            //dp 점화식
            dp[i]=Math.max(dp[i-1]+series[i],series[i]);
            max=Math.max(dp[i],max);
        }

        max=Math.max(dp[0],max);


        //결과 출력
        System.out.println(max);


    }
}