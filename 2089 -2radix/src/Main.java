import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Stack<Integer> Change2Radix(int num) {
        Stack<Integer> stack = new Stack<>();
        if (num == 0) {
            stack.push(0);  // 0을 -2진법으로 변환한 결과는 0
            return stack;
        }
        while (num != 0) {
            int remainder = num % -2;
            if (remainder < 0) {
                remainder += 2;  // 나머지를 양수로 보정
                num = (num / -2) + 1;  // 몫에 1을 더하여 보정
            } else {
                num /= -2;
            }
            stack.push(remainder);
        }
        return stack;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Stack<Integer> result = Change2Radix(num);
        while (!result.isEmpty()) {
            System.out.print(result.pop());
        }
    }
}
