import java.util.Scanner;

public class Main {

    public static StringBuilder radix2into8(StringBuilder str){
        //길이를 구해 3단위로 나누어 지지 않을경우 앞에 0 삽입
        int size=str.length();
        StringBuilder result=new StringBuilder();
        while (size%3!=0){
            str.insert(0,"0");
            size=str.length();
        }

        int total=0;
        int flag=0;
        int flag1=0;
        //3개로 분할하여 계산해서 결합
        for(int i=size-1; i>=0; i--){
            if(str.charAt(i)=='1'){
                total+=Math.pow(2,flag1);
            }
            flag1++;
            flag++;
            if(flag%3==0){
                result.insert(0,total);
                //System.out.println(total+"값");
                total=0;
                flag1=0;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        StringBuilder radix2;
        Scanner scanner=new Scanner(System.in);
        radix2= new StringBuilder(scanner.next());

        String result= String.valueOf(radix2into8(radix2));
        System.out.println(result);
    }
}