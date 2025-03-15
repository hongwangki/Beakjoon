import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int MAX = 1_000_000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 입력: 정수 개수
        int count = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[count];
        int maxInput = 0;

        // count 개수만큼 입력 받아 배열 저장 & 최대값 찾기
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
            maxInput = Math.max(maxInput, arr[i]);
        }

        maxInput = Math.min(maxInput, MAX);
        long[] resultArr = new long[maxInput + 1];

        // 배수 합 계산 (O(N log N))
        for (int i = 1; i <= maxInput; i++) {
            for (int j = i; j <= maxInput; j += i) {
                resultArr[j] += i;
            }
        }

        // 누적합 계산 (O(N))
        for (int i = 1; i <= maxInput; i++) {
            resultArr[i] += resultArr[i - 1];
        }

        // 결과 저장 및 출력 최적화
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(resultArr[num]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
