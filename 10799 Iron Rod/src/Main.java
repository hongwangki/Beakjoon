import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StringBuilder input;
        int reuslt=0;

        //input 입력
        Scanner scanner=new Scanner(System.in);
        input= new StringBuilder(scanner.next());

        //stack 과 flag 생성
        Stack<String> stack=new Stack<>();
        char []flag=new char[1];

        for(int i=0; i<input.length(); i++){
            //( 일경우 스택에 push
           if(input.charAt(i)=='('){
               stack.push(String.valueOf(input.charAt(i)));
               flag[0]='(';
           }
           //) 일 경우
           else{
               //flag가 ( 라면 pop후 스택 안에 있는 파이프 갯수 더하기
               if(flag[0]=='('){
                   stack.pop();
                   reuslt+= stack.size();
               }
               //아니면 1 더하기
               else{
                   stack.pop();
                   reuslt+=1;
               }
               flag[0]=')'; //flag 변경
           }
        }
        //최종 결과 출력
        System.out.print(reuslt);
    }
}