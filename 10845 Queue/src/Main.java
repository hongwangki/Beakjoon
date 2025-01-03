import java.util.Scanner;
import java.util.Vector;

public class Main {

    //push 함수
    public static void push(Vector vector, int PushNumber){
        vector.add(PushNumber); //Queue에 숫자 추가
    }

    //pop 함수
    public static void pop(Vector vector){
        if(vector.isEmpty()) System.out.println(-1);
        else{
            System.out.println(vector.firstElement()); //첫번 째 문자 출력
            vector.remove(vector.firstElement());
        }
    }

    //size 함수
    public static void size(Vector vector){
        System.out.println(vector.size());
    }

    //empty 함수
    public static void empty(Vector vector){
        if(vector.isEmpty()) System.out.println(1);
        else System.out.println(0);
    }

    //front 함수
    public static void front(Vector vector){
        if(vector.isEmpty()) System.out.println(-1);
        else System.out.println(vector.firstElement());
    }

    //back 함수
    public static void back(Vector vector){
        if(vector.isEmpty()) System.out.println(-1);
        else System.out.println(vector.lastElement());
    }

    //메인함수
    public static void main(String[] args) {
        int count; //입력 횟수 변수
        //Vector 생성
        Vector<Integer> vector=new Vector<>();

        Scanner scanner=new Scanner(System.in);

        count= scanner.nextInt(); //횟수 입력

        for(int i=0; i<count; i++) {
            String str; //명령어 입력 변수
            str = scanner.next();

            switch (str) {
                case "push":
                    int PushNumber;
                    PushNumber= scanner.nextInt();
                    push(vector,PushNumber);
                    break;
                case "pop":
                    pop(vector);
                    break;
                case "size":
                    size(vector);
                    break;
                case "empty":
                    empty(vector);
                    break;
                case "front":
                    front(vector);
                    break;
                case "back":
                    back(vector);
                    break;
                default:
                    break;
            }
        }

    }
}