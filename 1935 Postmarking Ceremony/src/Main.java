import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int count;
        double result = 0;

        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();  // 숫자 개수 입력
        String str = scanner.next();  // 연산 포함 문자열
        double[] num = new double[count];

        for (int i = 0; i < count; i++) {
            num[i] = scanner.nextDouble();
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int index = ch - 'A';  // 'A'는 0, 'B'는 1, 'C'는 2로 매핑
                if (index < count) {
                    stack.push(num[index]);  // 매핑된 숫자를 스택에 추가
                } else {
                    return;
                }
            } else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                if (stack.size() < 2) {
                    System.out.println("잘못된 수식입니다: 피연산자가 부족합니다.");
                    return;
                }
                double num2 = stack.pop();
                double num1 = stack.pop();
                switch (ch) {
                    case '*': stack.push(num1 * num2); break;
                    case '/': stack.push(num1 / num2); break;
                    case '+': stack.push(num1 + num2); break;
                    case '-': stack.push(num1 - num2); break;
                }
            } else {
                System.out.println("잘못된 연산자: " + ch);
                return;
            }
        }

        if (stack.size() == 1) {
            result = stack.pop();
            System.out.printf("%.2f\n", result);
        } else {
            System.out.println("잘못된 수식입니다: 연산이 완료되지 않았습니다.");
        }
    }
}
