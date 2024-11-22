import java.util.Scanner;
import java.util.Vector;

public class Main {
    // pop 함수
    public static void pop(Vector<Integer> v) {
        // 벡터가 비었다면 -1 출력
        if (v.isEmpty()) {
            System.out.println(-1);
        }
        // 벡터가 비어 있지 않다면 마지막 요소 출력 후 제거
        else {
            System.out.println(v.lastElement());
            v.remove(v.size() - 1); // 수정: index로 삭제
        }
    }

    // push 함수
    public static void push(Vector<Integer> v, int num) {
        v.add(num); // 인자로 받은 num 벡터에 추가
    }

    // size 함수
    public static void size(Vector<Integer> v) {
        System.out.println(v.size()); // 벡터 크기 출력
    }

    // empty 함수
    public static void empty(Vector<Integer> v) {
        // 비어있으면 1, 아니면 0
        if (v.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // top 함수
    public static void top(Vector<Integer> v) {
        // 벡터가 비었다면 -1 출력
        if (v.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(v.lastElement());
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        int count;
        String str;

        // count 입력
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();

        // 명령어 처리
        while (count > 0) {
            str = scanner.next(); // 명령어 입력

            // 명령어 처리
            if (str.equals("push")) {
                int num = scanner.nextInt();
                push(v, num);
            } else if (str.equals("pop")) {
                pop(v);
            } else if (str.equals("size")) {
                size(v);
            } else if (str.equals("empty")) {
                empty(v);
            } else if (str.equals("top")) {
                top(v);
            } else {
                System.out.println("잘못된 입력입니다.");
            }

            count--; // 처리된 명령 개수 감소
        }

        scanner.close(); // 스캐너 닫기
    }
}
