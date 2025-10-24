import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int min=Integer.MAX_VALUE;
    static int [][]matrix;
    static boolean[] visited;
    static int total=0;
    static Stack<Integer> stack= new Stack<>();

    //1팀 능력치  -  2팀 능력치
    public static void calAbility(Stack<Integer> stack) {
        //1팀 능력치 구하기
        int sum = 0;
        int[] arr = new int[stack.size()];

        // 스택의 내용을 배열로 복사
        for (int k = 0; k < stack.size(); k++) {
            arr[k] = stack.get(k);
        }

        // 팀 내 모든 (i, j) 쌍에 대해 능력 합산
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += matrix[arr[i]][arr[j]];
                sum += matrix[arr[j]][arr[i]];
            }
        }

        //2팀 능력치 구하기
        Stack<Integer> st= new Stack<>();
        for (int k = 1; k < N+1; k++) {
            if(!visited[k]) st.add(k);
        }
        int sum1 = 0;
        int[] arr1 = new int[st.size()];

        // 스택의 내용을 배열로 복사
        for (int k = 0; k < st.size(); k++) {
            arr1[k] = st.get(k);
        }

        // 팀 내 모든 (i, j) 쌍에 대해 능력 합산
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                sum1 += matrix[arr1[i]][arr1[j]];
                sum1 += matrix[arr1[j]][arr1[i]];
            }
        }

        //최소값 갱신
        min=Math.min(min,Math.abs(sum1-sum));
    }


    public static void solve(int human,int count){
        //1팀에 포함
        stack.add(human);
        visited[human]=true;

        //팀을 결성 했다면
        if(count==N/2){
            calAbility(stack);
            stack.pop();
            //백트래킹
            visited[human] = false;
            return;
        }

        for (int i=human+1; i<N+1; i++){
            solve(i,count+1);
        }

        //백트래킹
        stack.pop();
        visited[human] = false;
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        matrix=new int[N+1][N+1];
        visited=new boolean[N+1];

        for (int i=1; i<N+1; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
                total+=matrix[i][j];
            }
        }

        //초기 세팅 끝

        //탐색 시작
        for(int i=1; i<N; i++){
            solve(i,1);
        }

        //결과 출력
        System.out.println(min);


    }
}