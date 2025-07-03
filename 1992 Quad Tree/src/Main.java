import java.awt.geom.QuadCurve2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static int[][] matrix;
    static StringBuilder sb=new StringBuilder();


    //분할한 영역이 모두 같은지 확인
    public static boolean allSame(int startX,int startY, int size){
        for(int i=startX; i< startX+size;i++){
            for(int j=startY; j<startY+ size;j++){
                if(matrix[startX][startY]!=matrix[i][j]) return false;
            }
        }

        return true;
    }

    public static void QuadTree(int startX,int startY, int size){
        if(allSame(startX,startY,size)){
            sb.append(matrix[startX][startY]);
            return;
        }

        int newSize= size/2;
        sb.append('(');

        //쿼드 트리 4갈래로 분할

        //1사분면
        QuadTree(startX,startY,newSize);
        //2사분면
        QuadTree(startX,startY+newSize,newSize);
        //3사분면
        QuadTree(startX+newSize,startY,newSize);
        //4사분면
        QuadTree(startX+newSize,startY+newSize,newSize);

        sb.append(')');
    }



    public static void main(String[] args) throws IOException {
        int matrixSize;

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        matrixSize = Integer.parseInt(br.readLine());

        matrix = new int[matrixSize][matrixSize];

        //행렬 입력
        for (int i = 0; i < matrixSize; i++) {
            String input= br.readLine();
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }

        //쿼드트리 탐색 시작
        QuadTree(0,0,matrixSize);


        //결과 출력
        System.out.println(sb.toString());

    }
}