import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Vector;

public class Main {
    static Vector<BigInteger> resultVector= new Vector<>(); //결과를 담을 벡터 생성

    //한 입력에 대해 숫자를 추출하는 메서드
    public static void parseInteger(StringBuilder sb){
         boolean numflag= false;
         StringBuilder result=new StringBuilder();

         for(int i=0; i<sb.length(); i++){
             char c= sb.charAt(i);
             //현재 검사하는 문자가 숫자면
             if(Character.isDigit(c)){
                 result.append(c);
                 numflag=true;
             }

             //현재검사하는 문자가 문자면
             else if(Character.isLetter(c)){
                 numflag=false;
             }

             //플레그가 false이고 결과 안에 무언가 있으면
             //즉 저장된 숫자를 저장해야 하는 경우
             if(!numflag && result.length()!=0){
                 BigInteger b= new BigInteger(result.toString());
                 resultVector.add(b);
                 //결과 초기화
                 result=new StringBuilder();
             }

             // 마지막 문자인 경우 체크
             if(i==sb.length()-1 && numflag){
                 BigInteger b= new BigInteger(result.toString());
                 resultVector.add(b);
                 //결과 초기화
                 result=new StringBuilder();
             }
         }
    }


    public static void main(String[] args) throws IOException {
        int count; //입력 횟수
        StringBuilder sb= new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(br.readLine()); // 입력 횟수 읽기

        for (int i = 0; i < count; i++) {
            String str = br.readLine(); // 한 줄씩 입력 받기
            sb.append(str);
            parseInteger(sb); //한줄 전달
            sb=new StringBuilder();
        }


        //벡터 정렬
        Collections.sort(resultVector);

        //결과 출력
        for(BigInteger i : resultVector){
            System.out.println(i);
        }

    }
}
