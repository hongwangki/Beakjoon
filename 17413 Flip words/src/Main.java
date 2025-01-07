import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        char[] ch = new char[1000001];

        Scanner scanner = new Scanner(System.in);
        ch = scanner.nextLine().toCharArray();


        Vector<String> vector= new Vector<>();
        for (int i = 0; i < ch.length; i++) {
            //< 가 있을 때 정상 출력
            if(ch[i]=='<'){
                for(int j= vector.size()-1; j>=0; j--){
                    System.out.print(vector.get(j));
                }
                vector.clear();
                while(true){
                    System.out.print(ch[i]);
                    i++;
                    if(ch[i]=='>') {
                        System.out.print(ch[i]);
                        break;
                    }
                }
            }
            /// /
            //일반 문자 나올때 출력
            else{
                //공백일 경우 push 된 백터 모두 역출력
                if(ch[i]==' '){
                    for(int j= vector.size()-1; j>=0; j--){
                        System.out.print(vector.get(j));
                    }
                    System.out.print(" ");
                    vector.clear();
                }
                //아닐때 백터에 저장
                else{
                    vector.add(String.valueOf(ch[i]));
                }

            }
        }
    if(!vector.isEmpty()){
        for(int j= vector.size()-1; j>=0; j--){
            System.out.print(vector.get(j));
        }
    }
    }
}