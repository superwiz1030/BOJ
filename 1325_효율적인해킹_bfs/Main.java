import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static int N;
	static int M;
	static List<Integer>[] arr;
	static int[] visit;
	static int[] ans;

	public static void main(String[] args) throws Exception {
//		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		ans = new int[N+1];		

		for (int i = 0; i <= N; i++) {
			arr[i]= new ArrayList<>();
		}
		
		String[] inputs = new String[2];
		for (int i = 1; i <= M; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			arr[from].add(to);
		}

		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (arr[i].size() <= 0) continue;
			
			visit = new int[N+1];			
			que.add(i);
			visit[i] = 1;
			
			int cnt = 0;
			while (!que.isEmpty()) {
				int cur = que.poll();
				cnt++;
				
				for (int j = 0; j < arr[cur].size(); j++) {
					if (visit[arr[cur].get(j)] == 0 && arr[cur].get(j) != 0) {
						visit[arr[cur].get(j)] = 1;
						que.add(arr[cur].get(j));
					}
				}
			}			
			ans[i] = cnt;
		}

		int maxN = 0;
		for(int i = 1; i <= N; i++) {
			maxN = Math.max(maxN, ans[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (ans[i]== maxN) {
				System.out.print(i + " ");
			}
		}
	}
} // 8772 ms

//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.ObjectInputStream.GetField;
//
//class Main {
//	static int N;
//	static int M;
//
//	public static void main(String[] args) throws Exception {
//		class Node implements Comparable<Node> {
//			public Node(int num, int cnt) {
//				this.id = num;
//				this.cnt = cnt;
//			}
//
//			int id;
//			int cnt;
//
//			@Override
//			public int compareTo(Node o) {
//				if (cnt == o.cnt) {
//					return id - o.id;
//				} else {
//					return o.cnt - cnt;
//				}
//			}
//		}
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String input = br.readLine();
//		StringTokenizer st = new StringTokenizer(input);
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//
//		List<Integer>[] arr = new ArrayList[N+1];
//		
//		for (int i = 0; i <= N; i++) {
//			arr[i]= new ArrayList<>();
//		}
//		
//		String[] inputs = new String[2];
//		
//		for (int i = 1; i <= M; i++) {
//			input = br.readLine();
//			st = new StringTokenizer(input);
//			int to = Integer.parseInt(st.nextToken());
//			int from = Integer.parseInt(st.nextToken());
//			arr[from].add(to);
//		}
//
//		Queue<Integer> que = new LinkedList<>();
//		PriorityQueue<Node> pq = new PriorityQueue<>();
//
//		for (int i = 1; i <= N; i++) {
//			if (arr[i].size() <= 0) continue;
//
//			int[] visit = new int[N + 1];
//			que.add(i);
//			visit[i] = 1;
//			
//			int cnt = 0;
//
//			while (!que.isEmpty()) {
//				int cur = que.poll();
//				cnt++;
//				
//				for (int j = 0; j < arr[cur].size(); j++) {
//					if (visit[arr[cur].get(j)] == 0 && arr[cur].get(j) != 0) {
//						visit[arr[cur].get(j)] = 1;
//						que.add(arr[cur].get(j));
//					}
//				}
//			}
//			pq.add(new Node(i, cnt));
//		}
//
//		int maxN = 0;
//		List<Integer> result = new ArrayList<>();
//		while (!pq.isEmpty()) {
//			Node n = pq.poll();
//			if (maxN > n.cnt)
//				break;
//			maxN = n.cnt;
//			result.add(n.id);
//		}
//
//		for (int i = 0; i < result.size(); i++) {
//			System.out.print(result.get(i) + " ");
//		}
//	}
//}

// 9244 ms