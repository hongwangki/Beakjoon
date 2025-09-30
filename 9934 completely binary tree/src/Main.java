import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] nodeArr;
    static List<List<Integer>> levelLists = new ArrayList<>();

    //즁위순회 해결
    public static void inorder(int start, int end, int depth) {
        if (start > end) return;

        int mid = (start + end) / 2; // 중앙이 현재 서브트리의 루트
        levelLists.get(depth).add(nodeArr[mid]);

        inorder(start, mid - 1, depth + 1); // 왼쪽 서브트리
        inorder(mid + 1, end, depth + 1);   // 오른쪽 서브트리
    }

    public static void main(String[] args) throws IOException {
        //초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        nodeArr = new int[(int) Math.pow(2, k) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = Integer.parseInt(st.nextToken());
        }

        // k개의 레벨 리스트 준비
        for (int i = 0; i < k; i++) {
            levelLists.add(new ArrayList<>());
        }
        //초기세팅 끝

        //레벨 찾기
        inorder(0, nodeArr.length - 1, 0);

        // 결과 출력
        for (int i = 0; i < k; i++) {
            for (int val : levelLists.get(i)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
