import java.util.Scanner;
import java.util.Vector;

public class Main {

    // push_back 함수
    public static void push_back(Vector<Integer> vector, int PushNumber) {
        vector.add(PushNumber); // deque에 숫자 추가
    }

    // push_front 함수
    public static void push_front(Vector<Integer> vector, int PushNumber) {
        vector.add(0, PushNumber); // deque 첫 번째에 숫자 추가
    }

    // pop_front 함수
    public static void pop_front(Vector<Integer> vector) {
        if (vector.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(vector.firstElement()); // 첫 번째 요소 출력
            vector.remove(0); // 첫 번째 요소 제거
        }
    }

    // pop_back 함수
    public static void pop_back(Vector<Integer> vector) {
        if (vector.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(vector.lastElement()); // 마지막 요소 출력
            vector.remove(vector.size() - 1); // 마지막 요소 제거
        }
    }

    // size 함수
    public static void size(Vector<Integer> vector) {
        System.out.println(vector.size());
    }

    // empty 함수
    public static void empty(Vector<Integer> vector) {
        System.out.println(vector.isEmpty() ? 1 : 0);
    }

    // front 함수
    public static void front(Vector<Integer> vector) {
        if (vector.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(vector.firstElement());
        }
    }

    // back 함수
    public static void back(Vector<Integer> vector) {
        if (vector.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(vector.lastElement());
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        int count; // 입력 횟수 변수
        Vector<Integer> vector = new Vector<>(); // Vector 생성
        Scanner scanner = new Scanner(System.in);

        count = scanner.nextInt(); // 횟수 입력

        for (int i = 0; i < count; i++) {
            String str = scanner.next(); // 명령어 입력

            switch (str) {
                case "push_back":
                    int PushNumber = scanner.nextInt();
                    push_back(vector, PushNumber);
                    break;
                case "push_front":
                    int PushNumber1 = scanner.nextInt();
                    push_front(vector, PushNumber1);
                    break;
                case "pop_front":
                    pop_front(vector);
                    break;
                case "pop_back":
                    pop_back(vector);
                    break;
                case "size":
                    size(vector);
                    break;
                case "empty":
                    empty(vector);
                    break;
                case "front":
                    front(vector);
                    break;
                case "back":
                    back(vector);
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }
}
