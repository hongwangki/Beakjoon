import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] divisorSum = new long[num + 1];

        // 1부터 num까지의 모든 수에 대해 약수의 합을 미리 계산
        for (int i = 1; i <= num; i++) {
            for (int j = i; j <= num; j += i) {
                divisorSum[j] += i;
            }
        }

        long result = 0;
        for (int i = 1; i <= num; i++) {
            result += divisorSum[i];
        }

        System.out.println(result);
    }
}
