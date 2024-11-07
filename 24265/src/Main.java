import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        System.out.println((n*(n-1))/2);
        System.out.print(2);  // O(n^2)
    }
}
