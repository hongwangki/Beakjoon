import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();

        if(n==1){
            System.out.println(1);
            return;
        }
        //피보나치 dp 2x2가 추가되므로 점화식 바뀜
        int []fibo=new int[n+1];
        fibo[1]=1;
        fibo[2]=3;
        for (int i=3; i<n+1; i++){
            fibo[i] = (fibo[i-1] + 2*fibo[i-2]) % 10007; //오버플로우 방지
        }
        System.out.println(fibo[n]);
    }
}