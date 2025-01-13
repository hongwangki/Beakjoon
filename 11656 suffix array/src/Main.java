import java.util.*;

public class Main {
    public static void main(String[] args) {

        StringBuilder str; //입력 문자열
        Vector<StringBuilder> vector=new Vector<>(); //사전순으로 정렬하기 위헤 담아두는 벡터

        Scanner scanner=new Scanner(System.in);
        str= new StringBuilder(scanner.next());
        int size=str.length();
        for(int i=0; i<size; i++){
            vector.add(new StringBuilder(str)); // str의 복사본을 추가
            str.deleteCharAt(0);
        }

        Collections.sort(vector);

        //벡터 모두출력
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
    }
}