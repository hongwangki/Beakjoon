import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int T,K;
    static int [][]cogs;


    //시게 방향 회전
    public static void rightDirection(int pos){
        int []temp=new int[8];

        //임시 배열 복사
        for(int i=0; i<8; i++){
            temp[i]=cogs[pos][i];
        }

        //시계 방향으로 회전
        for(int i=0; i<8; i++){
            if(i<7){
                cogs[pos][i+1]=temp[i];
            }
            else{
                cogs[pos][0]=temp[7];
            }
        }

    }

    //반시게 방향 회전
    public static void leftDirection(int pos){
        int []temp=new int[8];

        //임시 배열 복사
        for(int i=0; i<8; i++){
            temp[i]=cogs[pos][i];
        }

        //반시계 방향으로 회전
        for(int i=7; i>=0; i--){
            if(i==7){
                cogs[pos][7]=temp[0];
            }
            else{
                cogs[pos][i]=temp[i+1];

            }
        }

    }

    public static void rotation(int pos, int direction){
        List<int[]> list=new ArrayList<>();
        //시계 방향 회전
        if(direction==1){
            boolean flag=true;
            list.add(new int[]{pos,1});
            int temp=pos;

            //시계 방향으로 회전했을때 왼쪽 톱니바퀴들에게 전파
            while (temp>0){
                if(cogs[temp][6]!=cogs[temp-1][2]){
                    if(flag){
                        list.add(new int[]{temp-1,-1});
                        flag=false;
                    }
                    else{
                        list.add(new int[]{temp-1,1});
                        flag=true;
                    }
                    temp--;
                }
                else break;
            }

            temp=pos;
            flag=true;
            //시계 방향으로 회전했을때 오른쪽 톱니바퀴들에게 전파
            while (temp<T-1){
                if(cogs[temp][2]!=cogs[temp+1][6]){
                    if(flag){
                        list.add(new int[]{temp+1,-1});
                        flag=false;
                    }
                    else{
                        list.add(new int[]{temp+1,1});
                        flag=true;
                    }
                    temp++;
                }
                else break;
            }
        }

        else{
            list.add(new int[]{pos,-1});

            int temp=pos;
            boolean flag=true;

            //반시계 방향으로 회전했을때 왼쪽 톱니바퀴들에게 전파
            while (temp>0){
                if(cogs[temp][6]!=cogs[temp-1][2]){
                    if(flag){
                        list.add(new int[]{temp-1,1});
                        flag=false;
                    }
                    else{
                        list.add(new int[]{temp-1,-1});
                        flag=true;
                    }
                    temp--;
                }
                else break;
            }

            temp=pos;
            flag=true;
            //반시계 방향으로 회전했을때 오른쪽 톱니바퀴들에게 전파
            while (temp<T-1){
                if(cogs[temp][2]!=cogs[temp+1][6]){
                    if(flag){
                        list.add(new int[]{temp+1,1});
                        flag=false;
                    }
                    else{
                        list.add(new int[]{temp+1,-1});
                        flag=true;
                    }
                    temp++;
                }
                else break;
            }
        }

        //동시 회전
        for(int[] arr : list ){
            int pos1=arr[0];
            int dir=arr[1];

            if(dir==1){
                rightDirection(pos1);
            }
            else{
                leftDirection(pos1);
            }
        }

    }

    //결과 메서드
    public static int printResult(){
        int result=0;
        for(int i=0; i<T; i++){
            if(cogs[i][0]==1) result++;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        //초기 세팅
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());

        cogs=new int[T][8];

        for(int i=0; i<T; i++){
            StringBuilder sb=new StringBuilder(br.readLine());
            for(int j=0; j<8; j++){
                cogs[i][j]=sb.charAt(j)-'0';
            }
        }

        K=Integer.parseInt(br.readLine());
        //초기 세팅 끝

        for(int i=0; i<K; i++){
            int n1,n2;
            StringTokenizer st=new StringTokenizer(br.readLine());
            n1=Integer.parseInt(st.nextToken());
            n2=Integer.parseInt(st.nextToken());
            //회전 시작
            rotation(n1-1,n2);

        }

        //최종 결과 출력
        int result = printResult();
        System.out.println(result);


    }

}