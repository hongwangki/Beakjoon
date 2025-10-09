import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder str; //입력 문자
    static StringBuilder explosion; // 입력 폭발 문자
    static int explosionSize;
    static Stack<Character> stack=new Stack<>();

    public static void solve() {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.add(c);

            // 스택 안에 요소가 폭발문자열 길이보다 작으면 검사 불필요
            if (stack.size() < explosionSize) continue;

            // 스택 끝 부분부터 폭발문자열 검사
            boolean match = true;
            for (int k = 0; k < explosionSize; k++) {
                if (stack.get(stack.size() - explosionSize + k) != explosion.charAt(k)) {
                    match = false;
                    break;
                }
            }

            // 폭발 문자열이면 제거
            if (match) {
                for (int j = 0; j < explosionSize; j++) {
                    stack.pop();
                }
            }
        }

        // 결과 출력
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str1=br.readLine();
        str=new StringBuilder(str1);

        String str2= br.readLine();
        explosion=new StringBuilder(str2);
        explosionSize=explosion.length();
        //초기 세팅 끝

        //폭팔 시작
        solve();
    }
}

