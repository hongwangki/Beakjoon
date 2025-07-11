import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void findYesOrNo(StringBuilder sb){
        Stack<Character> stack= new Stack<>();
        int i=0;
        boolean yesOrNo=true;
        //판별 시작
        while (i!=sb.length()-1){

            //해당 문자열이 여는 소괄호나, 여는 대괄호면
            if(sb.charAt(i)=='[' || sb.charAt(i)=='('){
                stack.push(sb.charAt(i)); //push
            }

            //해당 문자열이 닫는 소괄호나, 닫는 대괄호면
            if(sb.charAt(i)==']' || sb.charAt(i)==')'){
                //여는 괄호가 없는데 닫힌 괄호가 먼저나오면 매칭x
                if(stack.isEmpty()){
                    yesOrNo=false;
                    break;
                }
                char c= stack.pop();

                //닫는 대괄호인데 stack top이 여는 대괄호이면 성공
                if(sb.charAt(i)==']' && c=='['){
                    yesOrNo=true;
                }
                if(sb.charAt(i)==']' && c!='['){
                    yesOrNo=false;
                    break;
                }


                //닫는 소괄호인데 stack top이 여는 소괄호이면 성공
                if(sb.charAt(i)==')' && c=='('){
                    yesOrNo=true;
                }
                if(sb.charAt(i)==')' && c!='('){
                    yesOrNo=false;
                    break;
                }
            }
            i++;
        }

        //스택이 비어있고 모두 매칭이 된경우
        if(yesOrNo && stack.isEmpty())System.out.println("yes");
        else System.out.println("no");
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String str= br.readLine(); //문장 입력
            sb=new StringBuilder(str);

            //종료 조건
            if(str.equals(".")){
                break;
            }

            findYesOrNo(sb);

        }
    }
}