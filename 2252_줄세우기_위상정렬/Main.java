import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] indegree;
	static List<Integer>[] arr;
	public static void main(String[] args) throws Exception {
		input();
		
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				que.offer(i); // 진입 차수가 0인 간선 큐에 넣기
			}
		}

		while (!que.isEmpty()) {
			int n = que.poll();
			System.out.print(n + " ");

			for (int v : arr[n]) {
				indegree[v]--;
				if (indegree[v] == 0) {
					que.add(v);
				}
			}
		}
	}

	private static void input() throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		indegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			indegree[v]++;
		}
	}
}
