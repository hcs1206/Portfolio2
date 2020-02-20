import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon4485_녹색옷입은애가젤다지 {
	private static int N;
	private static int[][] map;
	private static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case=0;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j * 2) - '0';
				}
			}

			dp = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}

			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] { 0, 0 });
			dp[0][0] = map[0][0];

			while (!q.isEmpty()) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(dp[i][j]+ " ");
					}
					System.out.println();
				}
				System.out.println();

				
				int[] arr = q.poll();
				int curR = arr[0];
				int curC = arr[1];

				if (curR - 1 >= 0 && dp[curR-1][curC] > dp[curR][curC]+map[curR-1][curC] ) {
					dp[curR-1][curC] = dp[curR][curC]+map[curR-1][curC];
					q.offer(new int[] {curR-1, curC});
				}
				
				if (curR + 1 < N && dp[curR+1][curC] > dp[curR][curC]+map[curR+1][curC] ) {
					dp[curR+1][curC] = dp[curR][curC]+map[curR+1][curC];
					q.offer(new int[] {curR+1, curC});
				}
				
				if (curC - 1 >= 0 && dp[curR][curC-1] > dp[curR][curC]+map[curR][curC-1] ) {
					dp[curR][curC-1] = dp[curR][curC]+map[curR][curC-1];
					q.offer(new int[] {curR, curC-1});
				}
				
				if (curC + 1 < N && dp[curR][curC+1] > dp[curR][curC]+map[curR][curC+1] ) {
					dp[curR][curC+1] = dp[curR][curC]+map[curR][curC+1];
					q.offer(new int[] {curR, curC+1});
				}

			}
			
			System.out.println("Problem " + ++test_case + ": " + dp[N-1][N-1]);
		}

	}
}
