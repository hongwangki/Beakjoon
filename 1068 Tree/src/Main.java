import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] graph;       // 각 노드의 부모 인덱스 저장
    static boolean[] isNotLeaf;
    static int nodeCount, deleteNode, rootNode, result = 0;

    // 삭제 노드와 그 자식들을 -2로 표시
    private static void removeNode(int deleteNode) {
        for (int i = 0; i < nodeCount; i++) {
            if (graph[i] == deleteNode) {
                graph[i] = -2;
                removeNode(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodeCount = Integer.parseInt(br.readLine());
        graph = new int[nodeCount];
        isNotLeaf = new boolean[nodeCount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeCount; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
            if (graph[i] == -1) rootNode = i; // 루트 찾기
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == rootNode) { // 루트 삭제 시 리프 없음
            System.out.println(0);
            return;
        }

        graph[deleteNode] = -2;
        removeNode(deleteNode);

        // 부모가 된 노드 표시
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                if (i == graph[j]) isNotLeaf[i] = true;
            }
        }

        // 리프 노드 세기
        for (int i = 0; i < nodeCount; i++) {
            if (!isNotLeaf[i] && graph[i] != -2) result++;
        }

        System.out.println(result);
    }
}
