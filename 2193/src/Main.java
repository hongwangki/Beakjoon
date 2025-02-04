import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        long []dp;

        Scanner scanner=new Scanner(System.in);
        num= scanner.nextInt();

        dp=new long[num+1];

        dp[0]=0;
        dp[1]=1;
        //점화식 적용
        for (int i=2; i<=num; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        System.out.println(dp[num]);

    }
}