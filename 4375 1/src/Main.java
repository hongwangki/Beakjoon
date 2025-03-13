import java.util.Scanner;

public class Main {
    public static int changeNum(int n) {
        int length = 1; // 결과 길이 (최소 1부터 시작)
        int num = 1 % n; // 첫 번째 숫자는 1

        while (num != 0) { // 나머지가 0이 되면 종료
            num = (num * 10 + 1) % n; // 새로운 숫자의 나머지 계산
            length++; // 자리수 증가
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력이 끝날 때까지 반복 처리
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(changeNum(n));
        }

        sc.close(); // Scanner 닫기
    }
}
