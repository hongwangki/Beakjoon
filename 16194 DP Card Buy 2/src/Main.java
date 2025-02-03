import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        int []d;
        int []p;

        Scanner scanner=new Scanner(System.in);
        N= scanner.nextInt();

        p=new int[N+1];
        d=new int[N+1];

        //p값 입력
        for (int i=1; i<=N; i++){
            p[i]= scanner.nextInt();
        }
        for (int i=1; i<=N; i++){
            d[i]=Integer.MAX_VALUE;
        }

        //재귀식 도출 후 반복
        for (int i=1; i<=N; i++){
            for(int j=1; j<=i; j++) {
                d[i] = Math.min(d[i], d[i - j] + p[j]);
            }
        }
        //결과출력
        System.out.println(d[N]);

    }
}