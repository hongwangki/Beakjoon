import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        //a1N+a0 <= C * g(n)
        if((a1*n0+a0)<= c*n0 && a1 <= c){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}