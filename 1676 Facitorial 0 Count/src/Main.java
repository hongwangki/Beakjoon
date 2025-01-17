import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static BigInteger factorial(int num) {
        if (num <= 1) return BigInteger.ONE;
        return BigInteger.valueOf(num).multiply(factorial(num - 1));
    }

    public static void main(String[] args) {
        int num;
        BigInteger sum;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();

        if (num == 0) {
            sum = BigInteger.ONE; // 0!은 1
        } else {
            sum = factorial(num); // 팩토리얼 계산
        }

        // 팩토리얼 결과를 스트링으로 변환
        String str = sum.toString();
        int zeroCount = 0;

        // 스트링 인덱스를 통해 뒤에서 부터 0일때 카운트 증가
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                zeroCount++;
            } else {
                break; // '0'이 아닌 문자가 나오면 중지
            }
        }
        System.out.println(zeroCount);
    }
}
