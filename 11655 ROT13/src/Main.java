import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder str;
        Scanner scanner=new Scanner(System.in);
        str= new StringBuilder(scanner.nextLine());
        //알파벳에 따라 +13 번째위치일지 -13번쨰 위치일지 결정
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=' ') {
                char ch = str.charAt(i);
                if(ch>='a' && ch<='a'+12)ch+=13;
                else if(ch>='a'+13 && ch<='z')ch-=13;
                else if(ch>='A' && ch<='A'+12)ch+=13;
                else if(ch>='A'+13 && ch<='Z')ch-=13;
                //+- 13한것으로 수정
                str.setCharAt(i, ch);
            }
        }
        //결과 출력
        for (int j=0; j<str.length(); j++) System.out.print(str.charAt(j));
    }
}