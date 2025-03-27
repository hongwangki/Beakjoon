import java.util.Scanner;

public class Main {
    static int max=-1;

    //4개 다선택하는 경우 ㅡ ㅣ 검사
    public static int choise4(int[][] arr, int N, int M){
        int max = Integer.MIN_VALUE;
        int result=0;
        //열
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
               if(j+3<N) {
                   result = arr[j][i] + arr[j + 1][i] + arr[j + 2][i] + arr[j + 3][i];
                   if(max<result) max=result;
               }

            }
        }
        //행
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                if(j+3<M){
                    result= arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
                    if(max<result) max=result;
                }
            }
        }
        return max;
    }

    //3개선택하고 아래 하나있는 경우
    public static int choise3(int[][] arr, int N, int M) {
        int max = Integer.MIN_VALUE;
        int result=0;
        //행
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                ///위 3개 선택 해서 아래 올 수 있는 3개지 경우의수 계산
                if(j+2<M && i+1<N)  {
                    for(int k=0; k<3; k++) {
                        if(j+k<M){
                            result = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + k];
                            if(max<result) max=result;
                        }
                    }
                }
            }
        }

        //열
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                ///위 3개 선택
                if(j+2<N && i+1<M)  {
                    for(int k=0; k<3; k++) {
                        if(j+k<N){
                            result = arr[j][i] + arr[j+1][i] + arr[j+2][i] + arr[j+k][i+1];
                            if(max<result) max=result;
                        }
                    }
                }
            }
        }

        return max;
    }

    //2 개 선택하는 경우
    public static int choise2(int[][] arr, int N, int M){
        int max = Integer.MIN_VALUE;
        int result=0;

        //행
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                ///위 2개 선택
                if(j+1<M && i+1<N)  {
                    //위에 두개 선택후  아래두개 있는 case 4개

                    //   ㅁ ㅁ
                    //ㅁ ㅁ
                    if(j!=0) {
                        result = arr[i][j] + arr[i][j+1] + arr[i+1][j-1] + arr[i+1][j];
                        if (max < result) max = result;
                    }
                    //case 2 두개 밑 바로 두개인경우
                    //ㅁㅁ
                    //ㅁㅁ
                    if(j+1<M) {
                        result = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
                        if (max < result) max = result;
                    }

                    //case 3 두개중 오른쪽 밑에 두개 연속으로 있는 경우
                    //ㅁㅁ
                    //  ㅁㅁ
                    if(j+2<M) {
                        result = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
                        if (max < result) max = result;
                    }

                    //ㅁ
                    //ㅁ ㅁ
                    //  ㅁ
                    //case 4 위하나 아래하나 있는경우
                    if(i!=0 && i+1<N){
                        result = arr[i][j] + arr[i][j+1] + arr[i-1][j] + arr[i+1][j+1];
                        if (max < result) max = result;
                        result = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i+1][j];
                        if (max < result) max = result;
                    }

                }
            }
        }
        //열
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){

                ///위 2개 선택
                if(j+1<N && i+1<M)  {
                    //위에 두개 선택후  아래두개 있는 case 3개
                    if(j!=0) {
                        result = arr[j][i] + arr[j + 1][i] + arr[j - 1][i + 1] + arr[j][i + 1];
                        if (max < result) max = result;
                    }
                    //case 2 두개 밑 바로 두개인경우
                    if(j+1<N) {
                        result = arr[j][i] + arr[j + 1][i] + arr[j][i + 1] + arr[j + 1][i + 1];
                        if (max < result) max = result;
                    }

                    //case 3 두개중 오른쪽 밑에 두개 연속으로 있는 경우
                    if(j+2<N) {
                        result = arr[j][i] + arr[j + 1][i] + arr[j + 1][i + 1] + arr[j + 2][i + 1];
                        if (max < result) max = result;
                    }

                    if(i!=0 && i+1<M){
                        result = arr[j][i] + arr[j+1][i] + arr[j][i-1] + arr[j+1][i+1];
                        if (max < result) max = result;
                        result = arr[j][i] + arr[j+1][i] + arr[j+1][i-1] + arr[j][i+1];
                        if (max < result) max = result;
                    }

                }
            }
        }

        return max;
    }

    //1개 선택하고 아래 3개있는 경우
    public static int choise1(int[][] arr, int N, int M) {
        int max = Integer.MIN_VALUE;
        int result=0;
        //열
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){

                ///위 한개
                if( i+1<M)  {
                    //위에 한개 선택후  ㄴ 대칭인 경우
                    //   ㅁ
                    //ㅁㅁㅁ
                    if(j>1) {
                        result = arr[j][i] + arr[j-2][i+1]+arr[j-1][i+1]+arr[j][i+1];
                        if (max < result) max = result;
                    }
                    //case 2 위에 한개 선택후 ㅗ 모양인 경우
                    //  ㅁ
                    //ㅁㅁㅁ
                    if(j+1<N && j>0) {
                        result = arr[j][i] + arr[j-1][i+1]+arr[j][i+1]+arr[j+1][i+1];
                        if (max < result) max = result;
                    }
                    //ㅁ
                    //ㅁㅁㅁ
                    //case 3 위에 한개 선택후 ㄴ 모양인 경우
                    if(j+2<N) {
                        result = arr[j][i] + arr[j][i+1]+arr[j+1][i+1]+arr[j+2][i+1];
                        if (max < result) max = result;
                    }

                }
            }
        }

        //행
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                ///위 한개
                if(i+1<N)  {
                    //위에 한개 선택후  ㄴ 대칭인 경우
                    if(j>1) {
                        result = arr[i][j] + arr[i+1][j-2]+arr[i+1][j-1]+arr[i+1][j];
                        if (max < result) max = result;
                    }
                    //case 2 위에 한개 선택후 ㅗ 모양인 경우
                    if(j+1<M && j>0) {
                        result = arr[i][j] + arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
                        if (max < result) max = result;
                    }

                    //case 3 위에 한개 선택후 ㄴ 모양인 경우
                    if(j+2<M) {
                        result = arr[i][j] + arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2];
                        if (max < result) max = result;
                    }

                }
            }
        }

        return max;
    }



    public static void main(String[] args) {
        int N,M;

        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        int [][] arr = new int[N][M];

        //행열 입력
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        //4개 다선택하는 경우
        int result1=choise4(arr,N,M);

        //3개 선택하고 아래 하나있는 경우
        int result2=choise3(arr,N,M);

        //2개 선택하고 아래 두개 있는 경우
        int result3=choise2(arr,N,M);

        //1개 선택하고 아래 3개 있는 경우
        int result4=choise1(arr,N,M);




//        // 결과
//        System.out.println("4개 선택 최대 값 = " + result1);
//        System.out.println("3개 선택 최대 값 = " + result2);
//        System.out.println("2개 선택 최대 값 = " + result3);
//        System.out.println("1개 선택 최대 값 = " + result4);

        int result=Math.max(result1,Math.max(result4,(Math.max(result2,result3))));
        System.out.println(result);
    }


}