import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int channel; // 목표 채널
        int faultCount; // 고장난 리모컨 입력 횟수
        int[] faultNum; // 고장난 버튼 번호
        int channelLen; // 채널 길이
        int copyChannel, copyChannel1;

        Scanner sc = new Scanner(System.in);
        channel = sc.nextInt();
        faultCount = sc.nextInt();
        channelLen = String.valueOf(channel).length();

        // 현재 위치에서 +,- 버튼만 사용했을 때 버튼 누르는 횟수
        int minPress = Math.abs(channel - 100);

        // 고장난 번호가 없을 때 숫자 길이가 정답이므로 바로 출력
        if (faultCount == 0) {
            System.out.println(Math.min(minPress, channelLen));
            return;
        }

        // 고장난 버튼 입력
        faultNum = new int[faultCount];
        boolean[] broken = new boolean[10]; // 빠른 체크를 위한 boolean 배열
        for (int i = 0; i < faultCount; i++) {
            faultNum[i] = sc.nextInt();
            broken[faultNum[i]] = true;
        }

        // 모든 숫자 버튼이 고장난 경우 -> +, -만 가능
        boolean allBroken = true;
        for (int i = 0; i < 10; i++) {
            if (!broken[i]) {
                allBroken = false;
                break;
            }
        }
        if (allBroken) {
            System.out.println(minPress);
            return;
        }

        // 채널이 100번이면 이동할 필요 없음
        if (channel == 100) {
            System.out.println(0);
            return;
        }

        copyChannel = channel;
        copyChannel1 = channel;

        // - 방향으로 가장 가까운 유효한 채널 찾기
        while (copyChannel >= 0) {
            if (isValid(copyChannel, broken)) break;
            copyChannel--;
        }

        // + 방향으로 가장 가까운 유효한 채널 찾기
        while (copyChannel1 <= 999999) {
            if (isValid(copyChannel1, broken)) break;
            copyChannel1++;
        }

        // 예외 처리: upperNo가 1,000,000을 넘거나 lowerNo가 0 미만이면 배제
        if (copyChannel1 > 999999) copyChannel1 = Integer.MAX_VALUE;
        if (copyChannel < 0) copyChannel = Integer.MAX_VALUE;

        // 가까운 채널 중 최소 버튼 누르는 횟수 계산
        int pressLower = (copyChannel != Integer.MAX_VALUE) ? Math.abs(channel - copyChannel) + String.valueOf(copyChannel).length() : Integer.MAX_VALUE;
        int pressUpper = (copyChannel1 != Integer.MAX_VALUE) ? Math.abs(channel - copyChannel1) + String.valueOf(copyChannel1).length() : Integer.MAX_VALUE;

        int result = Math.min(minPress, Math.min(pressLower, pressUpper));
        System.out.println(result);
    }

    // 채널이 고장난 버튼 없이 입력 가능한지 확인
    private static boolean isValid(int num, boolean[] broken) {
        String strNum = String.valueOf(num);
        for (char c : strNum.toCharArray()) {
            if (broken[c - '0']) return false;
        }
        return true;
    }
}
