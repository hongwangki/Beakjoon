import java.util.Scanner;

public class Main {
    public static void print(String str) {
        int lower = 0, upper = 0, number = 0, empty = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) lower++;
            else if (Character.isUpperCase(ch)) upper++;
            else if (Character.isDigit(ch)) number++;
            else empty++;
        }
        System.out.println(lower + " " + upper + " " + number + " " + empty);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.isEmpty()) break;  // 빈 줄 입력 시 종료
            print(str);
        }
        scanner.close();
    }
}
