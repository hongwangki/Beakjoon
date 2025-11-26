import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] series; //수열 배열
    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;
    static int[][] oper=new int[4][1];

    public static void solve(int curNum,int count){
        if(count ==N-1){
            min=Math.min(min,curNum);
            max=Math.max(max,curNum);
            return;
        }

        // 4가지 연산자에 처리
        for (int op = 0; op < 4; op++) {
            if (oper[op][0] > 0) {   // 해당 연산자가 남아 있으면 사용
                oper[op][0]--;

                int nextNum = cal(curNum, op, series[count + 1]);
                solve(nextNum, count + 1);

                // 백트래킹
                oper[op][0]++;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        series=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            series[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            oper[i][0]=Integer.parseInt(st.nextToken());
        }

        //초기 세팅 끝


        //첫 인덱스만 계산
        for(int i=0; i<4; i++){
            int num=0;
            if(oper[i][0]!=0) {
                oper[i][0]--;
                num = cal(series[0], i, series[1]);
                solve(num, 1);
                oper[i][0]++;
            }
        }

        //결과 출력
        System.out.println(max);
        System.out.println(min);
    }

    public static int cal(int num1, int oper, int num2){
        if(oper == 0){
            return num1 + num2;
        }

        else if(oper == 1){
            return num1 - num2;
        }

        else if(oper == 2){
            return num1 * num2;
        }

        else{
            return num1/num2;
        }
    }
}