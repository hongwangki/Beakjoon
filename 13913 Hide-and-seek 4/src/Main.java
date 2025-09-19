import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int minTime=Integer.MAX_VALUE;
    static boolean []visited=new boolean[100001];
    static int []prevPos=new int[100001];
    static List<Integer> resultList=new ArrayList<>();


    //bfs 방식으로 최적의 경로 탐색
    public static void solve(int pos){
        visited[pos]= true;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{pos,0});

        while (!q.isEmpty()){
            int[] arr = q.poll();
            int currPos=arr[0];
            int currTime=arr[1];

            //목적지일 경우
            if(currPos==K){
                minTime=currTime;
                resultList.add(K);
                break;
            }

            //+1 일 경우
            if(currPos<100000 &&!visited[currPos+1]){
                q.add(new int[]{currPos+1,currTime+1});
                prevPos[currPos+1]=currPos; //다음 경로에 대해 이전 경로 저장
                visited[currPos+1]=true;
            }

            //-1 일 경우
            if(currPos>0 &&!visited[currPos-1]){
                q.add(new int[]{currPos-1,currTime+1});
                prevPos[currPos-1]=currPos; //다음 경로에 대해 이전 경로 저장
                visited[currPos-1]=true;
            }

            //*2 일 경우
            if(currPos*2<=100000 &&!visited[currPos*2]){
                q.add(new int[]{currPos*2,currTime+1});
                prevPos[currPos*2]=currPos; //다음 경로에 대해 이전 경로 저장
                visited[currPos*2]=true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        Arrays.fill(prevPos,-1);
        //초기 세팅 끝

        //시작
        solve(N);

        //시간 출력
        System.out.println(minTime);

        //역순으로 저장되어있는 경로 reverse 해서 출력
        int index=K;
        while (true){
            if(index==N) break;
            resultList.add(prevPos[index]);
            index=prevPos[index];
        }

        Collections.reverse(resultList);
        for (int i=0; i<resultList.size(); i++){
            System.out.print(resultList.get(i));
            if(i!=resultList.size()-1) System.out.print(" ");
        }
    }
}