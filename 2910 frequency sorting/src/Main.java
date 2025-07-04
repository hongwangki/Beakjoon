import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer, Integer> frequency;
    static int[] input;
    static int[] inputFrequency;
    static StringBuilder sr;
    static int N, C;

    public static void frequencySort() {
        sr = new StringBuilder();

        // 빈도 계산
        for (int i = 0; i < input.length; i++) {
            frequency.put(input[i], frequency.getOrDefault(input[i], 0) + 1);
        }

        // 각 숫자의 빈도를 배열에 저장
        for (int i = 0; i < input.length; i++) {
            inputFrequency[i] = frequency.get(input[i]);
        }

        // 최댓값(최대 빈도) 찾기
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            if (inputFrequency[i] > max) {
                max = inputFrequency[i];
            }
        }

        // 이미 출력한 숫자인지 체크하기 위한 HashSet
        HashSet<Integer> visited = new HashSet<>();

        // 최대 빈도부터 1까지 내려가면서 출력
        while (max != 0) {
            for (int i = 0; i < input.length; i++) {
                if (inputFrequency[i] == max && !visited.contains(input[i])) {
                    visited.add(input[i]);
                    for (int j = 0; j < max; j++) {
                        sr.append(input[i]).append(" ");
                    }
                }
            }
            max--;
        }
    }

    public static void main(String[] args) throws IOException {
        frequency = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 C 입력
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 숫자 입력
        input = new int[N];
        inputFrequency = new int[N];

        String inputString = br.readLine();
        String[] parts = inputString.split(" ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(parts[i]);
        }

        // 빈도 정렬 수행
        frequencySort();

        // 결과 출력
        System.out.println(sr.toString());
    }
}
