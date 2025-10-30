import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,L;
    static int appleCount; //사과 개수
    static int [][]map;
    static int[] changeTime; //위치가 변하는 시간
    static char[] changePos; // 변하는 위치
    static Set<List<Integer>> set = new HashSet<>();
    static int result=0;


    public static void game(int x, int y){
        int time=0;
        int changeIdx=0;
        int dir=3;  //현재 가는 방향 (Up: 1, Down: 2, Right: 3, Left: 4)

        Deque<int[]> dq= new ArrayDeque<>();

        set.add(Arrays.asList(x,y));
        dq.add(new int[]{x,y});

        while (true){
            //뱀 머리 가져오기
            int[] arr = dq.getLast();
            int curX=arr[0];
            int curY=arr[1];
            boolean flag=false;

            //위치를 변경할 시간이면 위치 변경
            if(changeIdx<L && time==changeTime[changeIdx] ){
                switch (dir){
                    case 1:
                        if(changePos[changeIdx]=='D') dir=3;
                        if(changePos[changeIdx]=='L') dir=4;
                        break;
                    case 2:
                        if(changePos[changeIdx]=='D') dir=4;
                        if(changePos[changeIdx]=='L') dir=3;
                        break;
                    case 3:
                        if(changePos[changeIdx]=='D') dir=2;
                        if(changePos[changeIdx]=='L') dir=1;
                        break;
                    case 4:
                        if(changePos[changeIdx]=='D') dir=1;
                        if(changePos[changeIdx]=='L') dir=2;
                        break;
                    default:
                }
                changeIdx++;
            }

            //실제 이동
            switch (dir){
                //위
                case 1:
                    //자기 자신과 만나는 경우
                    if(set.contains(Arrays.asList(curX-1,curY))) flag=true;
                    dq.add(new int[]{curX-1,curY});

                    break;
                //아래
                case 2:
                    if(set.contains(Arrays.asList(curX+1,curY)))flag=true;
                    dq.add(new int[]{curX+1,curY});
                    break;
                //우
                case 3:
                    if(set.contains(Arrays.asList(curX,curY+1)))flag=true;
                    dq.add(new int[]{curX,curY+1});
                    break;
                //좌
                case 4:
                    if(set.contains(Arrays.asList(curX,curY-1)))flag=true;
                    dq.add(new int[]{curX,curY-1});
                    break;
                default:
            }


            int[] last = dq.getLast();
            //게임이 끝난 경우
            if(last[0]<0 || last[1]<0 || last[0]>=N  || last[1]>=N ||flag) {
                time++;
                break;
            }

            //사과를 먹지 못한경우 꼬리 제거
            if(map[last[0]][last[1]]==0){
                int[] first = dq.getFirst();
                set.remove(Arrays.asList(first[0], first[1]));
                dq.removeFirst();
                set.add(Arrays.asList(last[0], last[1]));
            }
            else map[last[0]][last[1]]=0;

            time ++;
        }

        result=time;
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        appleCount=Integer.parseInt(br.readLine());

        map=new int[N][N];

        for(int i=0; i<appleCount; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            map[x-1][y-1]=1; //사과 위치 1로 갱신
        }

        L=Integer.parseInt(br.readLine());
        changePos=new char[L];
        changeTime=new int[L];
        for(int i=0; i<L; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            changeTime[i]=Integer.parseInt(st.nextToken());
            changePos[i]=st.nextToken().charAt(0);
        }
        //초기 세팅 끝

        //Game Start
        game(0,0);

        //결과 출력
        System.out.println(result);
        }
}