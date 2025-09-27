import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char [][]matrix;
    static boolean[][]visited;
    static int max=Integer.MIN_VALUE;
    static int []dx={-1,1,0,0};
    static int []dy={0,0,-1,1};
    static boolean [] usedAlphabet=new boolean[26];

    public static void dfs(int x, int y, int depth){
        max=Math.max(max,depth);

        //상하좌우 탐색
        for(int d=0; d<4; d++){
            int nx= x+dx[d];
            int ny= y+dy[d];

            if(nx<0 || ny<0 || nx>=R || ny>=C) continue;

            int c = matrix[nx][ny] - 'A';
            if (!usedAlphabet[c]) {
                usedAlphabet[c] = true;
                dfs(nx, ny, depth+1);
                usedAlphabet[c] = false; // 백트래킹
            }

        }

    }

    public static void main(String[] args)throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        matrix=new char[R][C];
        visited=new boolean[R][C];

        for (int i=0; i<R; i++){
            StringBuilder sb=new StringBuilder(br.readLine());
            for (int j=0; j<C; j++){
                matrix[i][j]=sb.charAt(j);
            }
        }

        //초기 세팅 끝

        //탐색 시작
        usedAlphabet[matrix[0][0]-'A'] = true; //시작점은 방문 표시
        dfs(0, 0,1);

        //결과 출력
        System.out.println(max);


    }
}