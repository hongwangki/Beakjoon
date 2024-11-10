import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a,b,c,d,e,f;

        // a b c d e f 입력
        Scanner scanner=new Scanner(System.in);
        a=scanner.nextInt();
        b=scanner.nextInt();
        c=scanner.nextInt();
        d=scanner.nextInt();
        e=scanner.nextInt();
        f=scanner.nextInt();

        // 주어진 범위 x y에 대해 모두 탐색 후 찾았다면 return
        for(int i=(-999); i<1000; i++) {
            for (int j = (-999); j < 1000; j++) {
                if((a*i)+(b*j)==c && (d*i)+(e*j)==f){
                    System.out.println(i +" "+j);
                    return;
                }


            }
        }

    }
}