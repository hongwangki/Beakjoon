import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(reader.readLine());
        int cursor = sb.length();
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String command = reader.readLine();
            char cmd = command.charAt(0);

            if (cmd == 'L') {
                if (cursor > 0) cursor--;
            } else if (cmd == 'D') {
                if (cursor < sb.length()) cursor++;
            } else if (cmd == 'B') {
                if (cursor > 0) {
                    sb.deleteCharAt(cursor - 1);
                    cursor--;
                }
            } else if (cmd == 'P') {
                sb.insert(cursor, command.charAt(2));
                cursor++;
            }
        }

        System.out.println(sb.toString());
    }
}
