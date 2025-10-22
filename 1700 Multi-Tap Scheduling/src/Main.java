import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] arr; // 전기용품 배열
    static boolean []flag;
    static int[] dist;
    static int max=-1;
    static int result=0;
    static Set<Integer> curPlug=new HashSet<>();

    //OS Optimal page 기법 스케줄링
    public static void scheduling(){
        //초기에 멀티탭이 찰때까지 연결
        for(int i=0; i<K; i++){
            if(curPlug.size()==N)break;
            flag[arr[i]]=true;
            curPlug.add(arr[i]);
        }


        //가득 찰때 이후부터 스케줄링 시작
        for(int i=N; i<K; i++){
            Arrays.fill(dist,101);
            //이미 연결되어있는 플러그인 경우
            if(flag[arr[i]]) continue;

            //플러그를 교체해야 하는 경우
            //가장 나중에 연결할 플러그 거리 계산 안꼽혀있으면 101
            for(int j=K-1; j>=i; j--){
                if(curPlug.contains(arr[j])){
                    dist[arr[j]]=j;
                }
            }

            int max=-1;
            int maxIndex=-1;

            //꼽혀 있는 플러그중 가장 먼것 찾기
            for(Integer plug: curPlug){
                if(max<dist[plug]) {
                    max=dist[plug];
                    maxIndex=plug;
                }
            }

            //가장 먼것을 제거하고 새로운 플러그 연결
            if(maxIndex!=-1) curPlug.remove(maxIndex);
            flag[maxIndex]=false;
            curPlug.add(arr[i]);
            flag[arr[i]]=true;
            result++;

        }


    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        arr=new int[K];

        st=new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(max<arr[i]) max=arr[i];

        }
        flag=new boolean[max+1];
        dist=new int[max+1];
        //초기 세팅 끝

        //스케줄링 시작
        scheduling();

        //결과 출력
        System.out.println(result);

    }
}