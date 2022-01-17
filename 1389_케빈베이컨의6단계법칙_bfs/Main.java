import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	static int N;
	static int M;
	static List<Integer>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[u].add(v);
			arr[v].add(u);
		}

		int min = Integer.MAX_VALUE;
		int ret = 0;
		for (int i = 1; i < N + 1; i++) {
			int sum = 0;
			for (int j = 1; j < N + 1; j++) {
				if (i != j) {
					visited = new boolean[N + 1];
					sum += bfs(i, j, 0);
				}
			}

			System.out.print(sum);

			if (min > sum) {
				min = Math.min(min, sum);
				ret = i;
			}
		}
		System.out.println(ret);
	}

	static class Node {
		int num;
		int dist;

		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}

	static int bfs(int start, int end, int cnt) {
		Queue<Node> que = new LinkedList<>();
		visited[start] = true;
		que.offer(new Node(start, cnt));

		while (!que.isEmpty()) {
			Node n = que.poll();
			
			for (int next : arr[n.num]) {
				if (!visited[next]) {
					if (next == end) {
						return n.dist + 1;
					}
					visited[next] = true;
					que.offer(new Node(next, n.dist + 1));
				}
			}
		}

		return 0;
	}
}
