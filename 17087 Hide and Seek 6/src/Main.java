import java.util.Scanner;

public class Main {
    //GCD 찾는 함수
    public static int GCD(int num1, int num2){
        if(num1>=num2){
            int tmp;
            while(num2!=0){
                tmp = num1 % num2;
                num1 = num2;
                num2 = tmp;
            }
            return num1;
        }
        else{
            int tmp;
            while(num1!=0){
                tmp = num2 % num1;
                num2 = num1;
                num1 = tmp;
            }
            return num2;
        }
    }

    public static void main(String[] args) {
        int N,S;
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        S=scanner.nextInt();

        int []human=new int[N];
        //동생과의 거리 차 계산
        for (int i=0; i<N; i++){
            human[i]=scanner.nextInt();
            human[i]=Math.abs(S-human[i]);
        }

        //GCD를 구한 값과 다음수와 GCD를 구함
        if(N!=1) {
            int tmp = GCD(human[0], human[1]);
            for (int i = 2; i <= N - 1; i++) {
                tmp = GCD(tmp, human[i]);
            }
            System.out.println(tmp);
        }
        else{
            System.out.println(human[0]);
        }


    }
}