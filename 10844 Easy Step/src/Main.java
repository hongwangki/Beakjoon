import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        int mod = 1000000000;
        long[][] dp = new long[num + 1][10];

        // 한 자리 계단수 초기화
        for (int j = 1; j <= 9; j++) { // 0이 아닌 숫자만 시작 가능
            dp[1][j] = 1;
        }

        // 점화식 적용
        for (int i = 2; i <= num; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod; // j-1에서 j로 오는 경우
                }
                if (j < 9) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod; // j+1에서 j로 오는 경우
                }
            }
        }

        // 결과값 계산 (num 자리에서 1~9까지의 계단수 합)
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[num][j]) % mod;
        }

        System.out.println(result);
    }
}
