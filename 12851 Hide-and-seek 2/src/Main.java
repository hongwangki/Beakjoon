import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int count = 0; // 최적으로 가능한 방법의 수
    static int[] dist = new int[100001];
    static int minTime=-1;


    public static void solve(int pos) {

        dist[N] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{pos,0});

        while (!q.isEmpty()){
            //현재 위치와 시간
            int[] arr = q.poll();
            int currPos=arr[0];
            int currTime=arr[1];

            // 이미 최단 시간보다 긴 경로는 무시
            if (minTime != -1 && currTime > minTime) break;


            //목적지면
            if (currPos == K) {
                if (minTime == -1) minTime = currTime; // 첫 발견
                if (currTime == minTime) count++;
            }

            //-1 일때
            if(currPos>0&& (dist[currPos-1]==-1 || dist[currPos - 1] == currTime + 1) ){
                dist[currPos-1]=dist[currPos]+1;
                q.offer(new int[]{currPos-1,currTime+1});
            }
            //+1 일떄
            if(currPos<100000 && (dist[currPos+1]==-1|| dist[currPos + 1] == currTime + 1) ){
                dist[currPos+1]=dist[currPos]+1;
                q.offer(new int[]{currPos+1,currTime+1});
            }
            //*2 일때
            if((currPos*2)<=100000 && (dist[currPos*2]==-1 || dist[currPos *2] == currTime + 1)){
                dist[currPos*2]=dist[currPos]+1;
                q.offer(new int[]{currPos*2,currTime+1});
            }
        }


    }

    public static void main(String[] args) throws IOException {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(dist,-1);

        // 탐색 시작
        solve(N);


        // 결과 출력
        System.out.println(minTime);
        System.out.print(count);
    }
}
