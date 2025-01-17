import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main {

    //5로 소인수 분해한 승수
    static long fiveCount(long num){
        int count=0;
        while (num>=5) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }

    //2로 소인수 분해한 승수
    static long twoCount(long num){
        int count=0;
        while (num>=2) {
            count += num / 2;
            num /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m, n;
        m = scanner.nextLong();
        n = scanner.nextLong();
        //계산한 승수중 최소값인 것이 마지막 0의 갯수
        long fivcecount=fiveCount(m)-fiveCount(m-n)-fiveCount(n);
        long twocount=twoCount(m)-twoCount(m-n)-twoCount(n);
        System.out.println(min(fivcecount,twocount));
    }
}
