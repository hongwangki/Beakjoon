import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][][] dp = new int[61][61][61]; // 체력 최대 60

    static int attack(int hp1, int hp2, int hp3){
        // 바닥 처리
        if (hp1 < 0) hp1 = 0;
        if (hp2 < 0) hp2 = 0;
        if (hp3 < 0) hp3 = 0;

        // 모두 0이면 종료
        if (hp1 == 0 && hp2 == 0 && hp3 == 0) return 0;

        // 상태 정규화(내림차순) -> 중복 상태 감소
        int[] s = {hp1, hp2, hp3};
        Arrays.sort(s);                  // 오름차순
        hp1 = s[2]; hp2 = s[1]; hp3 = s[0]; // 내림차순으로 재배치

        // 메모 체크(0은 '미방문' 의미로 쓰기 어려우니 -1을 초기값으로 사용)
        if (dp[hp1][hp2][hp3] != -1) return dp[hp1][hp2][hp3];

        // 여섯 가지 분배 모두 시도
        int r1 = attack(Math.max(hp1-9,0), Math.max(hp2-3,0), Math.max(hp3-1,0));
        int r2 = attack(Math.max(hp1-9,0), Math.max(hp2-1,0), Math.max(hp3-3,0));
        int r3 = attack(Math.max(hp1-3,0), Math.max(hp2-9,0), Math.max(hp3-1,0));
        int r4 = attack(Math.max(hp1-3,0), Math.max(hp2-1,0), Math.max(hp3-9,0));
        int r5 = attack(Math.max(hp1-1,0), Math.max(hp2-9,0), Math.max(hp3-3,0));
        int r6 = attack(Math.max(hp1-1,0), Math.max(hp2-3,0), Math.max(hp3-9,0));

        // 이번 공격 1회 + 다음 상태의 최소
        int best = Math.min(Math.min(r1,r2), Math.min(r3,r4));
        best = Math.min(best, Math.min(r5,r6));
        return dp[hp1][hp2][hp3] = 1 + best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x=0, y=0, z=0;
        if (N >= 1) x = Integer.parseInt(st.nextToken());
        if (N >= 2) y = Integer.parseInt(st.nextToken());
        if (N == 3) z = Integer.parseInt(st.nextToken());

        // dp 초기화
        for (int i=0;i<=60;i++)
            for (int j=0;j<=60;j++)
                Arrays.fill(dp[i][j], -1);

        System.out.println(attack(x, y, z));
    }
}
