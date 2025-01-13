import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //문자열 선언과 알파벳 배열 선언
        String str;
        int []count=new int[26];

        //문자열 입력
        Scanner scanner=new Scanner(System.in);
        str= scanner.next();

        // 0으로 초기화
        for(int i=0; i<count.length; i++) count[i] = 0;

        //알파벳 을 순회하면서 카운트 증가
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i); //알파벳 가져오기
            int place= ch-97;// index 위치 저장
            count[place]++; //해당 index 위치증가
        }
        //결과 출력
        for(int i=0; i<count.length; i++) System.out.print(count[i]+" ");

    }
}