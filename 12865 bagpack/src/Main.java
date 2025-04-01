import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N ,V;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();

        int [][]dp=new int[N+1][V+1];
        int []w=new int[N+1];
        int []v=new int[N+1];


        for(int i=1; i<=N; i++){
            w[i]=sc.nextInt();
            v[i]=sc.nextInt();
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0]=0;
        }
        for (int i= 0; i <= V; i++) {
            dp[0][i]=0;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=V; j++){
                if(w[i]<=j){
                    //선택한 경우
                    if(v[i]+dp[i-1][j-w[i]]>dp[i-1][j]){
                        dp[i][j]=dp[i-1][j-w[i]]+v[i];
                    }
                    //선택하지 않은경우
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][V]);
        /*
        for i = 1 to n {
            for w = 0 to W {
                if w[i] <= w {
                    if v[i] + F[i-1, w-w[i]] > F[i-1, w] {
                        F[i, w] = v[i] + F[i-1, w-w[i]]
                    } else {
                        F[i, w] = F[i-1, w]
                    }
                } else {
                    F[i, w] = F[i - 1, w]
                }
            }
        }
        */
    }
}