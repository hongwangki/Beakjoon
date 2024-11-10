import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        // Scanner 객체를 생성하여 사용자로부터 입력을 받음
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 정수 N을 입력받음
        int N = scanner.nextInt();
        // num 변수와 M 변수를 초기화
        int num = 0;
        int M = 0;

        // 0부터 N-1까지의 모든 수를 반복하여 검사
        for(int i = 0; i < N; i++){
            // 현재 반복의 숫자를 num에 저장
            num = i;
            // 각 자릿수의 합을 저장할 sum 변수 초기화
            int sum = 0;

            // 현재 숫자의 자릿수 합을 구하는 반복문
            while(num != 0){
                // 자릿수를 더함
                sum += num % 10;
                // 자릿수를 제거함
                num /= 10;
            }
            // i와 자릿수의 합이 N과 같다면 i는 N의 생성자
            if(sum + i == N){
                M = i; // 생성자를 M에 저장
                break; // 생성자를 찾으면 반복문 종료
            }
        }
        // 결과 출력
        System.out.println(M);
    }
}
