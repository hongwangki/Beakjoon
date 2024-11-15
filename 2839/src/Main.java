import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int N; // input N kg
        int count=0;

        //N input
        Scanner scanner= new Scanner(System.in);
        N=scanner.nextInt();


        while (N>=0){
            //5로도 나누어지지 않고 3으로도 나누어지지 않을때 -1출력 후 바로 종료
            if(N/5==0 && N/3==0 && N!=0){
                System.out.println(-1);
                return;
            }
            //5로 나눈 나머지가 0이라면 5로만 묶을수 있는 case
            if(N%5==0){
                count+=(N/5);
                System.out.println(count);
                return;
            }
            //N에 3kg 빼고 1묶음 증가시킴
            N-=3;
            count++;
        }
        System.out.println(count);
    }

}