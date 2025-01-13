import java.util.Scanner;

public class Main {
    //최대 공약수 구하는 함수
    public static int GCD(int a, int b){
        int tmp;
        while(b!=0){      //b가 0이 될 때까지
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static void main(String[] args) {
        int num1,num2;
        int gcd;
        Scanner scanner=new Scanner(System.in);

        //두 수 입력
        num1= scanner.nextInt();
        num2=scanner.nextInt();

        //GCD
        if(num1>=num2) {
            gcd = GCD(num1, num2);
        }
        else{
            gcd=GCD(num2,num1);
        }
        System.out.println(gcd);

        //최소 공배수 구하기 (최소 공배수는 두 수의 곱에 최대공약수를 나눈 것이다)
        //LCM
        System.out.println((num1*num2)/gcd);
    }
}