import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	
	private static final int MAX_SIZE = 500;
	static int[][] arr = new int[MAX_SIZE][MAX_SIZE];

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int j = 0; j <= i; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				int LU = 0;
				int RU = 0;
				if (i - 1 < 0 || j - 1 < 0)
					LU = 0;
				else
					LU = arr[i - 1][j - 1];

				if (j == i)
					RU = 0;
				else
					RU = arr[i - 1][j];

				arr[i][j] = Math.max(LU, RU) + arr[i][j];
			}
		}

		int ret = 0;
		for (int i = 0; i < N; i++) {
			ret = Math.max(ret, arr[N - 1][i]);
		}

		System.out.println(ret);
	}
} // 268ms
