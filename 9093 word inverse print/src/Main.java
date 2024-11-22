import java.util.Scanner;

public class Main {

    //문자를 띄어쓰기 단위로 역순으로 출력하는 함수
    public static void InversePrintString(int count, String str[]) {
        StringBuilder reversed;
        for (int i = 0; i < count; i++) {
            String[] words = str[i].split(" ");  // 띄어쓰기 단위로 문자열을 나눔
            for (String word : words) {
                reversed = new StringBuilder(word);
                System.out.print(reversed.reverse().toString() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int count; // 입력 개수

        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        // 버퍼 비우기
        scanner.nextLine();

        String[] str = new String[count];

        // 개수만큼 문자열 입력
        for (int i = 0; i < count; i++) {
            str[i] = scanner.nextLine();
        }

        // 문자열을 역순으로 출력
        InversePrintString(count, str);
    }
}
