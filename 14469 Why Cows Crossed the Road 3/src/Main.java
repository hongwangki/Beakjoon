import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<int[]> q = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
    );

    public static int solve(){
        //처음 검문하는 시간까지는 빠르게 pass
        int[] peek = q.peek();
        int result= peek[0];


        while (!q.isEmpty()){
            int[] arr = q.poll();
            int arrive=arr[0];
            int check= arr[1];

            //아직 검문 시간에 도달하지 못했을 때
            if (result < arrive) {
                result = arrive;
            }

            // 검문 진행
            result += check;

        }
        return result;

    }


    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int arrive=Integer.parseInt(st.nextToken());
            int check= Integer.parseInt(st.nextToken());
            q.add(new int[]{arrive,check}); // 도착시간 검문시간 Push
        }
        //초기 세팅 끝

        //탐색 시작
        int result = solve();

        //결과 출력
        System.out.println(result);



    }
}