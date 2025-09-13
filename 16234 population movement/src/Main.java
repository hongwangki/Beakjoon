import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,L,R;
    static int[][] matrix;
    static boolean[][] visited;
    static int result=0;

    //두개의 땅이 공유가 가능한지 검사하는 메서드
    public static boolean canSharing(int delA, int delB){
        int num=Math.abs(delA-delB);
        if(num>=L && num<=R) return true;
        return false;
    }

    //bfs 탐색
    public static boolean bfs(int x, int y){
        int totalHuman=0; //공유하는 사람 총 합
        int totalLand=0;  // 공유하는 땅 개수

        Queue<int[]> q=new LinkedList<>();
        //공유하는 xy좌표 (중복 방지 위해 set 사용)
        Set<List<Integer>> sharingXY = new HashSet<>();

        visited[x][y]=true;
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            //상
            if (curX > 0 && !visited[curX - 1][curY]) {
                if(canSharing(matrix[curX][curY], matrix[curX - 1][curY])) {
                    visited[curX - 1][curY] = true;
                    q.add(new int[]{curX - 1, curY});
                    sharingXY.add(Arrays.asList(curX, curY));
                    sharingXY.add(Arrays.asList(curX - 1, curY));
                }
            }
            //하
            if (curX + 1 < N && !visited[curX + 1][curY]) {
                if(canSharing(matrix[curX][curY], matrix[curX +1][curY])) {
                    visited[curX + 1][curY] = true;
                    q.add(new int[]{curX + 1, curY});
                    sharingXY.add(Arrays.asList(curX, curY));
                    sharingXY.add(Arrays.asList(curX + 1, curY));
                }
            }
            //좌
            if (curY > 0 && !visited[curX][curY - 1]) {
                if(canSharing(matrix[curX][curY], matrix[curX][curY-1])) {
                    visited[curX][curY - 1] = true;
                    q.add(new int[]{curX, curY - 1});
                    sharingXY.add(Arrays.asList(curX, curY));
                    sharingXY.add(Arrays.asList(curX, curY - 1));
                }
            }
            //우
            if (curY + 1 < N && !visited[curX][curY + 1]) {
                if(canSharing(matrix[curX][curY], matrix[curX][curY+1])) {
                    visited[curX][curY + 1] = true;
                    q.add(new int[]{curX, curY + 1});
                    sharingXY.add(Arrays.asList(curX, curY));
                    sharingXY.add(Arrays.asList(curX, curY + 1));
                }
            }
        }

        //연합하는 땅의 개수와 총 인구수 합 구하기
        totalLand=sharingXY.size();
        if(totalLand<2) return false; //연합 없으면 종료

        for (List<Integer> point : sharingXY) {
            int sx = point.get(0);
            int sy = point.get(1);
            totalHuman+=matrix[sx][sy];
        }

        // 각 평균 인원수로 해당 땅에 배분
        int shareHuman=totalHuman/totalLand;
        for (List<Integer> point : sharingXY) {
            int sx = point.get(0);
            int sy = point.get(1);
            matrix[sx][sy]=shareHuman;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        matrix=new int[N][N];
        for (int i=0; i<N; i++){
            StringTokenizer str= new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                matrix[i][j]=Integer.parseInt(str.nextToken());
            }
        }
        //초기 세팅 끝

        while (true){
            visited=new boolean[N][N]; // 하루마다 초기화
            boolean moved=false;

            //전체 탐색
            for (int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        if(bfs(i, j)) moved=true;
                    }
                }
            }

            if(!moved) break;
            else result++;
        }

        //결과 출력
        System.out.println(result);
    }
}
