import java.util.Scanner;

public class Main {

    public static int Counting(int num){
        int count=0;
        int length=String.valueOf(Math.abs(num)).length();//자리수

        //자리수가 1이면 즉시 리턴
        if(length==1){
            return num;
        }

        //3자리라면 이전 1자리 2자리 개수 모두 카운팅
        for(int i=0; i<length-1; i++){
            count+=9*Math.pow(10,i)*(i+1);
        }

        //3자리 수만 카운팅
        count += (num - Math.pow(10, length - 1) + 1) * length;

        //결과 리턴
        return count;

    }

    public static void main(String[] args) {
        int num;

        //수 입력
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        //결과 출력
        System.out.println(Counting(num));


    }
}