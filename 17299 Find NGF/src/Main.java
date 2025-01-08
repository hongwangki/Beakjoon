import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt(); // 입력 횟수
        int[] arr = new int[count]; // 입력된 숫자 배열
        int[] result = new int[count]; // 결과 저장 배열
        int[] frequency = new int[1000001]; // 등장 횟수를 저장하는 배열 (숫자 범위가 1~1,000,000)

        // 배열 초기화
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
            result[i] = -1; // 결과 배열 초기화
            frequency[arr[i]]++; // 등장 횟수 계산
        }

        Stack<Integer> stack = new Stack<>();

        // 오등큰수 계산
        for (int i = 0; i < count; i++) {
            while (!stack.isEmpty() && frequency[arr[stack.peek()]] < frequency[arr[i]]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i); // 현재 인덱스를 스택에 추가
        }

        // 결과 출력
        for (int i = 0; i < count; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
