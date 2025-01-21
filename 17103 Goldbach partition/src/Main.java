import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count;
        int []maxArr=new int[1000000];

        Scanner scanner=new Scanner(System.in);
        for (int i=0; i<maxArr.length; i++){
            maxArr[i]=1;
        }

        //0과 1은 소수로 취급 안함
        maxArr[0]=0;
        maxArr[1]=0;
        //에라토스테네스의 체를 활용하여 소수제외한 값은 0으로 변경
        for (int i=2; i< maxArr.length; i++){
            int change=i*2;
            while (change<maxArr.length){
                maxArr[change]=0;
                change+=i;
            }
        }

        count= scanner.nextInt();

        for (int i=0; i< count; i++){
            int num= scanner.nextInt();
            int check=0;
            int sameFlag=0;
            //입력한수 -소수 = 소수면 두 소수의 합이므로 check변수 증가
            for (int j=2; j<num+1; j++){
                if(maxArr[j]==1 && maxArr[Math.abs(j-num)]==1){
                    check++;
                    if(j==Math.abs(j-num)) sameFlag++;
                }
            }
            //ex)10일때 3 7, 7,3 즉 중복 카운트 가 되었으므로 2로 나누기
            check=(check/2)+sameFlag;//3 3 같은 경우에 대비해 falg 변수를 더함
            if(check!=0)System.out.println(check);

        }
    }
}