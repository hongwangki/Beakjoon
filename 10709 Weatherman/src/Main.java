import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void ResultPrint(char[][] matrix, int H, int W) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                //해당 자리가 구름인 경우
                if (matrix[i][j] == 'c') {
                    System.out.print(0);
                }

                //구름이 아닌 경우
                else {
                    int count = -1;
                    //해당 자리 이전을 모두 검사하면서 구름이 나올때 까지 검사
                    for (int z = j - 1; z >= 0; z--) {
                        //구름이 등장했다면 해당 간격 출력
                        if (matrix[i][z] == 'c') {
                            count = j - z;
                            break;
                        }
                    }
                    System.out.print(count);
                }

                // 마지막 열이 아니라면 공백 추가
                if (j != W - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println(); // 줄 바꿈
        }
    }


    public static void main(String[] args) throws IOException {
        int H,W;
        char[][]matrix;

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        //H와 W 입력
        H= Integer.parseInt(st.nextToken());
        W= Integer.parseInt(st.nextToken());

        matrix= new char[H][W];


        //maxtrix 입력
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        ResultPrint(matrix,H,W);

    }
}