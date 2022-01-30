import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static final int MAX_N = 200000;

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 1; // �ּ� ���� �Ÿ�
		int right = arr[N - 1] - arr[0]; // �ִ� ���� �Ÿ�

		int ret = 0;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (possible(mid) >= C) {
				ret = Math.max(ret, mid);
				left = mid + 1; // �� ���� ������ ��ġ ����. ���� �Ÿ� �ø���.
			} else {

				right = mid - 1; // ���� ��ġ �Ұ�. ���� �Ÿ� ������
			}
		}

		System.out.println(ret);
	}

	static int possible(int diff) {
		int cnt = 1;
		int prev = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - prev >= diff) {
				prev = arr[i];
				cnt++;
			}
		}
		return cnt;
	}
}
