import java.util.Scanner;

public class Main {

    //가장 긴 부분을 찾는 함수
    public static int checkMax(char[][] arr){
        int resultMax = 1;

        //행의 가장 긴 부분을 찾는 로직
        for(int i=0;i<arr.length;i++){
            int max=1;
            for(int j=1;j<arr[i].length;j++){
                //행의 최댓값을 찾는 로직
                if(arr[i][j-1]==arr[i][j])max++;
                    //연속해서 아니라면 초기화
                else max=1;
                resultMax = Math.max(resultMax,max);

            }
        }

        //열의 가장 긴 부분을 찾는 로직
        for(int i=0;i<arr.length;i++){
            int max=1;
            for(int j=1;j<arr[i].length;j++){
                //행의 최댓값을 찾는 로직
                if(arr[j-1][i]==arr[j][i])max++;
                //연속해서 아니라면 초기화
                else max=1;

                resultMax = Math.max(resultMax,max);

            }
        }
        //가장 긴 결과 반환
        return resultMax;

    }
    /// /////////////////////


    public static void main(String[] args) {
        int n; //n x n 행렬 사이즈
        int resultMax = 1;
        // n입력
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine(); //개행제거

        char [][]arr = new char[n][n];


        //행열 입력
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }


        //행을 한칸씩 차례대로 바꾸어 가장 긴부분 연산 수행
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {

                char[][] copyArr = new char[n][];
                for (int k = 0; k < n; k++) {
                    copyArr[k] = arr[k].clone(); // clone()을 사용하여 각 행 복사
                }

                //행 오른쪽 요소와 순서 변환
                char temp = copyArr[i][j];
                copyArr[i][j]=copyArr[i][j - 1];
                copyArr[i][j - 1] = temp;

                int result = checkMax(copyArr); //가장 긴부분 결과
                //최대값이면 최대값 갱신
                if (resultMax < result) resultMax = result;
            }
        }


        //행을 한칸씩 차례대로 바꾸어 가장 긴부분 연산 수행
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                //복사본 생성
                char[][] copyArr = new char[n][];
                for (int k = 0; k < n; k++) {
                    copyArr[k] = arr[k].clone(); // clone()을 사용하여 각 행 복사
                }

                //열 밑에 부분과 결과 스왑
                char temp = copyArr[j][i];
                copyArr[j][i]=copyArr[j-1][i];
                copyArr[j-1][i] = temp;

                int result = checkMax(copyArr);
                //최대값이면 최대값 갱신
                if (resultMax < result) resultMax = result;
            }
        }

        //결과출력
        System.out.println(resultMax);

    }
}