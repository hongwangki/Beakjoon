import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count; //입력 횟수
        int []arr;
        int []dp; //dp 배열
        int max=0;

        Scanner scanner=new Scanner(System.in);
        count= scanner.nextInt(); //count 입력
        arr=new int[count];
        //입력숫자를 저장과 동시에 최대 크기 저장
        for (int i=0; i<count; i++){
            arr[i]= scanner.nextInt();
            if(arr[i]>max){
                max=arr[i];
            }
        }
        dp=new int[max+1]; //n만큼 dp 배열 할당

        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for (int i=4; i<=max; i++){
            //추출한 재귀식
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        //결과 출력
        for (int i=0; i<count; i++) {
            System.out.println(dp[arr[i]]);
        }
    }
}