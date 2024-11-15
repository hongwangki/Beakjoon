import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int count = 666;
        int input;
        int temp = 1;

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();

        while (temp != input) {
            count += 1;
            //String으로 바꾸어 666이 포함되어있다면 result 업데이트
            if (String.valueOf(count).contains("666")) {
                temp += 1;
            }
        }
        //최종 결과 출력
        System.out.print(count);
    }
}