import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Queue<int[]> q = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // 끝나는 시간 같으면 시작 빠른 순
                return Integer.compare(a[1], b[1]); // 끝나는 시간 기준
            }
    );

    public static int solve(){
        int result=0;
        int[] first = q.peek();
        int lastEnd=first[0];

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int start=arr[0];
            int end=arr[1];
            //탐색한 마지막 시간이 다음 시작시간보다 작은 경우에만 탐색 가능
            if(lastEnd<=start){
                result++;
                lastEnd=end;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int time=end-start;
            //q에 시작시간, 끝나는시간, 회의시간 추가
            q.add(new int[]{start,end,time});
        }
        //초기 세팅 끝

        //탐색 시작
        int result = solve();

        //결과 출력
        System.out.println(result);

    }
}