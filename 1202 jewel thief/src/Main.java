import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static TreeMap<Integer, Integer> bagMap = new TreeMap<>();

    static Queue<double[]> q = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) return Double.compare(a[0], b[0]);
                return Double.compare(b[1], a[1]);
            }
    );

    public static long solve() {
        long result = 0L;
        while (!q.isEmpty()) {
            double[] arr = q.poll();
            long m = (long) arr[0];
            long v = (long) arr[1];

            // 현재 무게 m 이상 중 가장 작은 가방 찾기
            Integer bag = bagMap.ceilingKey((int) m);

            if (bag != null) {
                result += v;
                // 가방 하나 사용 처리
                if (bagMap.get(bag) == 1) bagMap.remove(bag);
                else bagMap.put(bag, bagMap.get(bag) - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 보석 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long m = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            q.add(new double[]{m, v});
        }

        // 가방 입력
        for (int i = 0; i < K; i++) {
            int c = Integer.parseInt(br.readLine());
            bagMap.put(c, bagMap.getOrDefault(c, 0) + 1); // 같은 무게 가방 처리
        }

        long result = solve();
        System.out.println(result);
    }
}
