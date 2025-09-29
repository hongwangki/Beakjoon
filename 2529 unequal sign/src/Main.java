import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static char[] us; //부등호 담을 배열
    static boolean [] visited=new boolean[10]; //사용한 숫자
    static List<String> resultList=new ArrayList<>();
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;

    //등호 비교
    public static boolean compare(int num1, char c, int num2){
        if(c=='<') return num1 < num2;
        else return num1 > num2;
    }

    public static void dfs(int num,int index,StringBuilder result){

        //모두 탐색 되었다면
        if(index==us.length){
            resultList.add(String.valueOf(result));
            return;
        }

        char c=us[index];

        for(int i=0; i<10; i++){
            if(!visited[i] && compare(num,c,i) ){
                visited[i]=true;
                result.append(i);
                dfs(i,index+1,result);
                //백트레킹
                result.deleteCharAt(result.length()-1);
                visited[i]=false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        k=Integer.parseInt(st.nextToken());
        us=new char[k];

        //부등호 저장
        StringTokenizer st1=new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            us[i] = st1.nextToken().charAt(0);
        }
        //초기세팅 끝

        //탐색 시작
        for(int i=0; i<10; i++){
            visited=new boolean[10];
            visited[i]=true;
            dfs(i,0, new StringBuilder(String.valueOf(i)));
        }

        //최대 최소 구하기
        for(String str:resultList){
            Long value=Long.parseLong(str);
            if(min>value){
                min=value;
            }
            if(max<value){
                max=value;
            }
        }

        //결과 출력
        System.out.println(max);

        StringBuilder minStr= new StringBuilder(String.valueOf(min));
        if(minStr.length()!=k+1){
            minStr.insert(0,"0");
        }
        System.out.println(minStr);

    }
}