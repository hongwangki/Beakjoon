import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int count; // 입력 횟수
        int PushCount = 0; // 현재까지 push한 최대 숫자
        int seq; // 수열 입력 변수
        boolean errfalg = true; // 가능한지 여부 플래그
        StringBuilder str = new StringBuilder(); // 결과 저장
        Stack<Integer> stack = new Stack<>(); // 스택 생성

        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt(); // 수열 길이 입력

        for (int i = 0; i < count; i++) {
            seq = scanner.nextInt(); // 수열 값 입력

            // 스택의 top이 seq보다 작으면 push
            while (PushCount < seq) {
                PushCount++;
                stack.push(PushCount);
                str.append("+\n");
            }

            // 스택의 top이 seq와 같으면 pop
            if (!stack.isEmpty() && stack.peek() == seq) {
                stack.pop();
                str.append("-\n");
            } else {
                // 불가능한 경우
                errfalg = false;
                break;
            }
        }

        if (errfalg) {
            System.out.println(str); // 결과 출력
        } else {
            System.out.println("NO");
        }
    }
}
