import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,p,d;
    static Queue<Integer> q=new PriorityQueue<>();
    static Map<Integer,LinkedList<Integer>> map=new HashMap<>();
    static Set<Integer> day=new TreeSet<>(); //day를 담을 set(자동 정렬)

    public static int calMoney(){
        int result=0;
        for(int calDay: day){
            for(int pay: map.get(calDay)){
                q.add(pay);
            }
            //q안에 요소가 day와 맞춰질때까지 pop
            while (q.size()>calDay){
                q.poll();
            }
        }

        //Queue안에 있는 모든 요소를 result에 합
        while (!q.isEmpty()){
            result+=q.poll();
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            //일수와 pay를 맵에 저장
            p=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken());

            //현재 day에 해당하는 key가 맵에 없으면 생성
            map.putIfAbsent(d,new LinkedList<>());

            //꼬리에 추가
            map.get(d).add(p);

            //set에 추가
            day.add(d);
        }

        //초기 세팅 끝

        //돈 구하기
        int result = calMoney();

        //결과 출력
        System.out.println(result);


    }
}