import java.util.Scanner;

public class Main {

    public static String radix8into2(StringBuilder str) {
        // 8진수 -> 2진수 매핑
        String[] octalToBinary = {
                "000", "001", "010", "011",
                "100", "101", "110", "111"
        };

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int num = Character.getNumericValue(str.charAt(i));
            result.append(octalToBinary[num]);
        }

        // 앞쪽 불필요한 0 제거
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder radix2 = new StringBuilder(scanner.next());

        // 변환된 결과 출력
        String result = radix8into2(radix2);
        System.out.println(result);
    }
}
