import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int start, end, number;

        Scanner scanner=new Scanner(System.in);
        ////// 6부터 10000까지 미리 소수를 계산//////////
        start= 6;
        end= 1000000;

        int []arr=new int[end+1];
        for(int i=0; i<arr.length; i++){
            arr[i]=1; //처음에는 모두 소수로 측정.
        }
        arr[0] = 0;
        arr[1] = 0;
        for(int j=2; j<arr.length; j++){
            int num=j;
            while (true){
                num+=j;
                if(num>=end+1) break;
                else arr[num]=0;
            }
        }
        ////////////////////////////////////////
        int flag=0;
        while (true){
            number= scanner.nextInt();
            flag=0;
            if(number==0) break;
            for(int i=2; i<=number; i++){
                if(arr[i]==1 && arr[number-i]==1){
                    int result =number-i;
                    System.out.println(number+" = "+i+" + " +result);
                    flag=1;
                }
                if (flag==1) break;
            }
            if(flag==0) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}