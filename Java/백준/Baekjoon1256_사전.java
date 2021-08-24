package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1256_사전 {

	static int N, M, K;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][M + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				if(dp[i][j] < 0) {
					dp[i][j] = 1000000001;
				}
			}
		}

		if (dp[N][M] < K) {
			System.out.print(-1);
			return;
		}

		System.out.print(findString(N, M, K));

	}

	private static String findString(int n, int m, int target) {
		if (target == 1) {
			String temp = "";
			for (int i = 0; i < n; i++) {
				temp += "a";
			}
			for (int i = 0; i < m; i++) {
				temp += "z";
			}

			return temp;
		} else if (target <= dp[n - 1][m]) {
			return "a" + findString(n - 1, m, target);

		} else {
			return "z" + findString(n, m - 1, target - dp[n - 1][m]);
		}

	}

}
