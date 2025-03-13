import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int result=1;
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] inputArr = new int[count];

        int max = 0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            inputArr[i] = sc.nextInt();
            if (inputArr[i] > max) {
                max = inputArr[i]; // 최댓값 찾기
            }
            if (inputArr[i] < min) {
                min = inputArr[i];
            }
        }
        System.out.println(max*min);

    }
}
