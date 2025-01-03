import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        int N, K;

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        Vector<Integer> vector = new Vector<>(); // vector 생성

        // Vector에 1부터 N까지의 숫자 저장
        for (int i = 1; i <= N; i++) {
            vector.add(i);
        }

        System.out.print("<");

        int currentIndex = 0;

        while (!vector.isEmpty()) {
            currentIndex = (currentIndex + K - 1) % vector.size(); // 현재 인덱스 계산
            System.out.print(vector.get(currentIndex)); // 값 출력

            vector.remove(currentIndex); // 해당 값 제거

            if (!vector.isEmpty()) {
                System.out.print(", ");
            }
        }

        System.out.println(">");
    }
}
