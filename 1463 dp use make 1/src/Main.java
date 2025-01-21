import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner scanner=new Scanner(System.in);
        num=scanner.nextInt();

        int []dp=new int[num+1];
        dp[1]=0;
        if (num >= 2) dp[2] = 1;
        if (num >= 3) dp[3] = 1;
        for (int i=4; i<num+1; i++){
            //6 으로 나누어 질때
            if(i%6==0){
                dp[i]=Math.min(dp[i-1]+1,Math.min(dp[i/2]+1,dp[i/3]+1));
            }
            //3으로 나누어 질때
            else if (i%3==0) {
                dp[i]=Math.min(dp[i-1]+1,dp[i/3]+1);
            }
            //2로 나누어 잘때
            else if (i%2==0) {
                dp[i]=Math.min(dp[i-1]+1,dp[i/2]+1);
            }
            //3과 2로 나누어 지지않을때
            else{
                dp[i]=dp[i-1]+1;
            }
        }
        System.out.println(dp[num]);
    }
}