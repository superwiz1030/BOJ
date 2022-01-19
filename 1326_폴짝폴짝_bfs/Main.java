import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	private static final int MAX_N = 10001;
	static int[] arr;
	static int s;
	static int e;
	static int N;
	static int[] visited;
	static int found;

	static class Node {
		int idx;
		int cnt;

		public Node(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	static Queue<Node> que = new LinkedList<>();

	static void addCandidate(Node node) {
		int idx = node.idx;

		// 정방향
		for (int i = 1; idx + (arr[idx] * i) <= N; i++) {
			int next = idx + (arr[idx] * i);
			if (visited[next] == 1)
				continue;

			visited[next] = 1;
			que.offer(new Node(next, node.cnt + 1));
		}
		// 역방향
		for (int i = 1; idx - (arr[idx] * i) >= 1; i++) {
			int next = idx - (arr[idx] * i);
			if (visited[next] == 1)
				continue;

			visited[next] = 1;
			que.offer(new Node(next, node.cnt + 1));
		}
	}

	static void bfs() {
		visited = new int[N + 1];
		visited[s] = 1;
		que.offer(new Node(s, 0));

		while (!que.isEmpty()) {
			Node node = que.poll();
			if (node.idx == e) {
				found = 1;
				System.out.println(node.cnt);
				return;
			}
			addCandidate(node);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[MAX_N];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		bfs();
		if (found == 0) {
			System.out.print("-1");
		}
	}
}
