import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean []primes= new boolean[4000001];
    static int N;
    static int result=0;

    //소수만 true 활성화
    public static void primesSet(){
        primes[1]=false;
        for(int i=2; i<4000001; i++){
            if(!primes[i]) continue;

            else{
                for(int j=2*i; j<4000001; j+=i){
                    primes[j]=false;
                }
            }
        }
    }

    //투포인터 알고리즘을 이용하여 해결
    public static void solve(){
        int target=N;
        int left=2;
        int sum=0;
        boolean flag=true;
        for(int R=2; R<=N; R++){
            if(primes[R]){
                sum += R;
                flag=true;
            }

            //왼쪽 한칸 전진
            while (sum > target && left <= R){
                sum -= left;
                for(int i=left+1; i<=N; i++){
                    if(primes[i]){
                        left=i;
                        break;
                    }
                }
            }

            //소수의 합들이 입력한 N이면 개수 증가
            if (flag && sum == target){
                result++;
                flag=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        Arrays.fill(primes, true);
        //초기 세팅 끝

        //에라토스테네스의 체 적용하여 소수만 ture
        primesSet();

        //탐색 시작
        solve();

        //결과 출력
        System.out.println(result);
    }
}