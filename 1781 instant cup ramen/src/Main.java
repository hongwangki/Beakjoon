import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static Map<Integer, LinkedList<Integer>> map=new HashMap<>();
    static Queue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
    static Set<Integer> day=new TreeSet<>(); //day를 담을 set(자동 정렬)

    public static int solve(){
        int result=0;
        int max = ((TreeSet<Integer>) day).last(); //set에서 가장 큰 값 꺼내기

        //큰 deadLine부터 1일차까지 역순 탐색
        for(int i=max; i>=1; i--){
            //해당 deadLine이 기한인 컵라면 개수 Queue에 추가
            if(map.containsKey(i)){
                for(int num: map.get(i)){
                    q.add(num);
                }
            }
            //큐에 서 가장 큰값 빼면서 결과에 더하기.
            if(!q.isEmpty()) result+=q.poll();

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            int deadLine=Integer.parseInt(st.nextToken());
            int remenCount=Integer.parseInt(st.nextToken());

            //map에 마감일과 라면 개수 추가
            map.putIfAbsent(deadLine,new LinkedList<>());
            map.get(deadLine).add(remenCount);

            //set에 마감일 추가
            day.add(deadLine);
        }
        //초기 세팅 끝

        //탐색 시작
        int result = solve();

        //결과 출력
        System.out.println(result);


    }
}