import java.util.Scanner;

public class Main {
    //GCD 찾는 함수
    public static int GCD(int num1, int num2){
        if(num1>=num2){
            int tmp;
            while(num2!=0){
                tmp = num1 % num2;
                num1 = num2;
                num2 = tmp;
            }
            return num1;
        }
        else{
            int tmp;
            while(num1!=0){
                tmp = num2 % num1;
                num2 = num1;
                num1 = tmp;
            }
            return num2;
        }
    }


    public static void main(String[] args) {
        int count; //입력 횟수
        long totalSum=0;
        Scanner scanner=new Scanner(System.in);
        count= scanner.nextInt();

        for (int i=0; i<count; i++){
            int subCount;
            subCount=scanner.nextInt();
            int []inputArr=new int[subCount];

            for (int j=0; j<subCount; j++){
                inputArr[j]=scanner.nextInt();
            }

            totalSum=0;

            // 중첩 반복문으로 모든 쌍 생성
            for (int z = 0; z < subCount; z++) {
                for (int k = z + 1; k < subCount; k++) {
                    totalSum+=GCD(inputArr[z],inputArr[k]);
                }
            }
            System.out.println(totalSum);
        }

    }
}