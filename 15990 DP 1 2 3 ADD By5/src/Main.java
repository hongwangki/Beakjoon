import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count; //반복 횟수
        int max=0;
        long [][]dp;
        int mod= 1000000009;
        //input count
        Scanner scanner=new Scanner(System.in);
        count= scanner.nextInt();

        int []arr=new int[count];
        //받은 횟수만큼 숫자 입력
        for (int i=0; i<count; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] > max) max = arr[i];
        }

        dp= new long[max + 1][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        //추출한 재귀식 사용
        for (int i=4; i<=max; i++){
            dp[i][1]=(dp[i-1][2]+dp[i-1][3])%mod;
            dp[i][2]=(dp[i-2][1]+dp[i-2][3])%mod;
            dp[i][3]=(dp[i-3][2]+dp[i-3][1])%mod;
        }
        //결과 출력
        for (int i=0; i<count; i++){
            System.out.println((dp[arr[i]][1]+dp[arr[i]][2]+dp[arr[i]][3])%mod);
        }


    }
}