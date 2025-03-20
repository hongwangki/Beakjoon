import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int e,s,m; //지구, 태양, 달 수
        int calE=0, calS=0, calM=0; //입력한 e s m을 계산하는 cal e s m
        int result=0;

        //e, s, m 입력
        Scanner sc = new Scanner(System.in);
        e = sc.nextInt();
        s = sc.nextInt();
        m = sc.nextInt();


        //3 개가 같은 경우는 계산 할 필요 없으므로 출력후 return
        if(e == s && s == m){
            System.out.println(e);
            return;
        }

        //입력한 e s m이 될 때 까지 무한반복
        while (true){

            //1 년도 증가
            calE ++;
            calS ++;
            calM ++;
            result ++;

            //주어진 최대 년도를 초과하면 초기화
            if(calE==16)calE=1;
            if(calS==29)calS=1;
            if(calM==20)calM=1;


            //입력한 e, s, m과 같으면 출력후 종료
            if(e == calE && s==calS && m==calM){
                System.out.println(result);
                break;
            }
        }


    }
}