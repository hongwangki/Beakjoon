import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int win1TotalSeconds = 0; // 1번 팀 리드 시간
    static int win2TotalSeconds = 0; // 2번 팀 리드 시간
    static int prevGoalTime = 0;     // 직전 시간 (초 단위)
    static int team1Score = 0;
    static int team2Score = 0;

    // 리드 시간 계산
    public static void calculateWinTime(String goalTimeStr) {
        String[] parts = goalTimeStr.split(":");
        int minute = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        int currentTime = minute * 60 + second;

        int timeDiff = currentTime - prevGoalTime;

        //team 1이 이기고 있는 경우
        if (team1Score > team2Score) {
            //이전 득점 시간차이 만큼 더해줌
            win1TotalSeconds += timeDiff;
        }
        //team 2가 이기고 있는 경우
        else if (team2Score > team1Score) {
            win2TotalSeconds += timeDiff;
        }

        //이전 골 현재 골로 변경
        prevGoalTime = currentTime;
    }

    // MM:SS 형식 출력
    public static void printTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        System.out.printf("%02d:%02d\n", minutes, seconds);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String goalTimeStr = st.nextToken();

            // 득점 전 상태 기준으로 리드 시간 계산
            calculateWinTime(goalTimeStr);

            // 득점 반영
            if (team == 1) team1Score++;
            else team2Score++;
        }

        // 경기 종료 시점까지 남은 리드 시간 반영
        int endTime = 48 * 60; // 48분 = 2880초
        int remainingTime = endTime - prevGoalTime;

        if (team1Score > team2Score) {
            win1TotalSeconds += remainingTime;
        } else if (team2Score > team1Score) {
            win2TotalSeconds += remainingTime;
        }

        // 결과 출력
        printTime(win1TotalSeconds);
        printTime(win2TotalSeconds);
    }
}
