import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int []num=new int[4];
        Scanner scanner=new Scanner(System.in);
        for(int i=0; i<num.length; i++) num[i]= scanner.nextInt();

        StringBuilder str1=new StringBuilder();

        //스트링에 두 숫자 결합
        str1.append(num[0]);
        str1.append(num[1]);
        //string형을 int 형으로 변환
        long num1=Long.parseLong(String.valueOf(str1));

        //스트링 빌더 초기화
        str1.setLength(0);

        str1.append(num[2]);
        str1.append(num[3]);
        long num2=Long.parseLong(String.valueOf(str1));

        //결과 출력
        System.out.print(num1+num2);

    }
}