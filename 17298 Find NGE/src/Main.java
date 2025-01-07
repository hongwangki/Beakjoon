import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[] arr = new int[count];
        int[] result = new int[count];  // 오큰수를 저장할 배열

        // 입력 받기
        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Stack<Integer> stack = new Stack<>();

        // 오큰수 탐색
        for (int i = count - 1; i >= 0; i--) {
            // 스택에서 현재 요소보다 작거나 같은 값을 제거
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // 오큰수를 저장, 없으면 -1
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // 현재 요소를 스택에 추가
            stack.push(arr[i]);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
