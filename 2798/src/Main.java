import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n,m;
        int max=0;
        int temp;
        //n과 m 입력
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();

        int[] arr=new int [n];

        //n개의 수 입력
        for(int i=0; i<n; i++){
            arr[i]=scanner.nextInt();
        }

        //모든 경우의 수 탐색
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int z=j+1; z<n; z++){
                    temp=arr[i]+arr[j]+arr[z];
                    //m과 같으면 최대 이기에 종료
                    if(temp==m) {
                        System.out.println(temp);
                        return;
                    }
                    if(temp<m){
                        if(max<=temp){
                            max=temp;
                        }
                    }

                }
            }
        }

        //결과 출력
        System.out.println(max);

    }
}