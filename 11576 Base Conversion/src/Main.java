import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int radixA, radixB;
        int count;
        int[]numArr;
        long radixAto10radix=0;
        int flag;

        Scanner scanner=new Scanner(System.in);
        radixA=scanner.nextInt();
        radixB=scanner.nextInt();
        count=scanner.nextInt();

        flag=count-1;

        numArr=new int[count];
        //A진법을 10진수로 변환
        for (int i=0; i<count; i++){
            numArr[i]=scanner.nextInt();
            radixAto10radix+=(Math.pow(radixA,flag)*numArr[i]);
            flag--;
        }

        Stack<Long> stack=new Stack<>();
        //10진법을 B진법으로 변환
        while (radixAto10radix>=radixB){
            stack.push(radixAto10radix%radixB);
            radixAto10radix/=radixB;
        }
        stack.push(radixAto10radix);

        //결과 출력
        while (!stack.isEmpty()) System.out.print(stack.pop()+" ");

    }
}