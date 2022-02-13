import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int dir;
	static int moveCnt;
	static List<Node> nodes = new ArrayList<>();
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] diagR = { -1, -1, 1, 1 };
	static int[] diagC = { -1, 1, 1, -1 };

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(count());
	}

	private static int count() {
		int ret = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ret += arr[i][j];
			}
		}
		return ret;
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}

	}

	private static void calcMove(Node n) {
		int nr = n.r + dr[dir];
		int nc = n.c + dc[dir];

		if (nr == 0)
			nr = N;
		else if (nr > N)
			nr = 1;

		if (nc == 0)
			nc = N;
		else if (nc > N)
			nc = 1;

		n.r = nr;
		n.c = nc;
	}

	private static int checkDiag(Node n) {

		int ret = 0;
		for (int j = 0; j < 4; j++) {
			int nr = n.r + diagR[j];
			int nc = n.c + diagC[j];

			if (nr < 1 || nc < 1 || nr > N || nc > N)
				continue;

			if (arr[nr][nc] > 0)
				ret++;
		}
		return ret;
	}

	private static void move() {
		// 구름 이동
		for (int i = 0; i < nodes.size(); i++) {
			for (int j = 0; j < moveCnt; j++) {
				calcMove(nodes.get(i));
			}
		}

		for (int i = 0; i < nodes.size(); i++) {
			Node n = nodes.get(i);
			arr[n.r][n.c]++;
		}

		for (int i = 0; i < nodes.size(); i++) {
			Node n = nodes.get(i);
			arr[n.r][n.c] += checkDiag(n); // 1은 물의양, checkDiag는 대각선 물의 양
		}

		int[][] visit = new int[N + 1][N + 1];
		for (Node n : nodes) {
			visit[n.r][n.c] = 1;
		}
		nodes.clear();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] >= 2 && visit[i][j] == 0) {
					nodes.add(new Node(i, j));
					arr[i][j] -= 2;
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

		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init cloud
		nodes.add(new Node(N - 1, 1));
		nodes.add(new Node(N - 1, 2));
		nodes.add(new Node(N, 1));
		nodes.add(new Node(N, 2));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			moveCnt = Integer.parseInt(st.nextToken());
			move();
		}
	}
}
