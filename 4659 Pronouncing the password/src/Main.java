import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void passWard(String password) {
        String vowels = "aeiou";
        boolean[] check = new boolean[password.length()];
        int count2=1; //2번조건 카운트

        //a e i o u 중에 적어도 하나는 포함되는지 확인 (첫번째 조건)
        if(password.contains("a") || password.contains("e") ||
           password.contains("i")  || password.contains("o") ||
           password.contains("u")) {

            //2번째 조건 모음이 3개 혹은 자음이 3개가 연속으로 안되는 것 확인
            for (int i = 0; i < password.length(); i++) {
                if (vowels.contains(String.valueOf(password.charAt(i)))) {
                    check[i] = true;
                }
            }
            for (int i = 0; i < password.length() - 1; i++) {
                if (check[i] == check[i + 1]) {
                    count2++;
                    if(count2==3) break;
                } else {
                    count2 = 1;
                }
            }

            if (count2 >= 3) {
                System.out.println("<" + password + "> is not acceptable.");
                return;
            }

            //3번째 조건 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
            for (int i = 0; i < password.length() - 1; i++) {
                if (password.charAt(i) == password.charAt(i + 1)
                        && password.charAt(i) != 'e' &&  password.charAt(i) != 'o') {
                    System.out.println("<" + password + "> is not acceptable.");
                    return;
                }
            }

            System.out.println("<" + password + "> is acceptable.");
        }

        else{
            System.out.println("<" + password + "> is not acceptable.");
            }


    }
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str=br.readLine();
            if(str.equals("end")) break;

            passWard(str);
        }
    }
}