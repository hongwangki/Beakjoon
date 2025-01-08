import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //스트링 선언 후 중위 연산 입력
        String str;
        Scanner scanner=new Scanner(System.in);
        str=scanner.next();

        Stack<Character> stack=new Stack<>();

        for(int i=0; i<str.length(); i++){
            //피연산자일 경우
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                System.out.print(str.charAt(i));
            }
            //* , / 연산자일 경우
            else if(str.charAt(i)=='*' ||str.charAt(i)=='/'){
                //+ 나 -일때 우선순위가 높으므로 stack에 push
                if( !stack.isEmpty() && ((stack.peek()=='+')||(stack.peek()=='-')|| stack.peek()=='(')) {
                    stack.push(str.charAt(i));
                }
                //아닐 때
                else{
                    //우선순위가 높아질때 까지 pop
                    while(!stack.isEmpty() && !((stack.peek()=='+') || (stack.peek()=='-')|| stack.peek()=='(')){
                        System.out.print(stack.pop());
                    }
                    //해당 연산자 push
                    stack.push(str.charAt(i));
                }

            }
            // + - 연산자일 경우
            else if(str.charAt(i)=='+' ||str.charAt(i)=='-') {
                //+ 나 -일때 (가 나오면 우선순위가 높으므로 stack에 push
                if( !stack.isEmpty() && stack.peek()=='('){
                    //해당 연산자 push
                    stack.push(str.charAt(i));
                }
                //아닐 때
                else{
                    //우선순위가 높아질때 까지 pop
                    while(!stack.isEmpty() && stack.peek()!='('){
                        System.out.print(stack.pop());
                    }
                    stack.push(str.charAt(i));
                }

            }
            // ( 일경우 무조건 push
            else if( str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            // )일 경우
            else{
                while(stack.peek()!='('){
                    System.out.print(stack.pop());
                }
                stack.pop();
            }

        }
        //반복이 끝났지만 스택에 요소가 남아있을 경우 모두 출력
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}