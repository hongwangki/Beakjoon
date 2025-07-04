import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] apple; //어디에 떨어지는지에 대한 사과 배열
    static int N,M;
    static int result=0;


    public static void appleGame(){
        int curLocation=1; //현재 위치

        //사과를 순차적으로 떨어뜨리는 반복문
        for(int i=0;i<apple.length ;i++){

            //바구니에 들어갈때까지 이동하면서 반복
            while (true){

                //현재 위치에서 사과를 담을 수 있다면
                if(curLocation+(M-1) >= apple[i] && curLocation <= apple[i]){
                    break;
                }
                else {
                    //사과가 현재 바구니 이전에 있다면 위치 감소
                    if(curLocation>apple[i]){
                        curLocation--;
                    }
                    //사과가 현재 바구니 이후에 있다면 위치 증가
                    else{
                        curLocation++;
                    }
                }
                //이동 횟수 증가
                result++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int appleCount;//떨어뜨릴 사과 개수

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        //N과 M입력
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());


        //떨어 뜨릴 사과 횟수 입력
        appleCount= Integer.parseInt(br.readLine());

        //횟수만큼 동적할당
        apple = new int[appleCount];

        //떨어질 위치 입력
        for (int i = 0; i < appleCount; i++) {
            apple[i]=Integer.parseInt(br.readLine());
        }

        //사과 담기 게임 시작
        appleGame();

        //결과 출력
        System.out.println(result);


    }
}