import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int count; // 입력 횟수
        int flag =0;

        //count 입력 후 str 배열 할당
        Scanner scanner=new Scanner(System.in);
        count= scanner.nextInt();
        String []str=new String[count];

        //Stack 선언
        Stack<String> stackstr=new Stack<>();

        //횟수만큼 ps 입력
        for (int i=0; i<count; i++){
            str[i]= scanner.next();
            stackstr.clear();
            flag=0;
            //첫 입력 ps가 vps 인지 확인하는 반복문
            for(int j=0; j<str[i].length(); j++) {
                char ch = str[i].charAt(j); //Sring 요소 하나 추출

                // 여는 괄호가 나오면 스택에 삽입
                if (ch == '(') {
                    stackstr.push(String.valueOf(ch));
                }
                //스택이 비었는데 닫는 괄호 부터 나온다면 즉시 VPS x
                if (ch == ')' && stackstr.empty()) {
                    flag = 1;
                    break;
                }
                //닫는 괄호과 나오면 스택 top 여는 괄호를 빼서 매칭
                if (ch == ')') {
                    stackstr.pop();
                }
            }
            if(!stackstr.empty()) flag=1; //여는 괄호가 남았을 경우 Vps x
            if(flag==1) str[i]="NO"; //스택이 비었는데 닫는 괄호가 나온 경우 Vps x
            else str[i]="YES"; //그 외에 경우는 Vps o
        }

        //최종 결과 출력
        for (int i = 0; i < count; i++) {
            System.out.println(str[i]);
        }
    }
}