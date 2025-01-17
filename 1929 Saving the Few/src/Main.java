import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int start, end;

        Scanner scanner=new Scanner(System.in);
        start= scanner.nextInt();
        end= scanner.nextInt();

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

        for(int j=start; j<=end; j++){
            if (arr[j]==1) System.out.println(j);
        }

    }
}