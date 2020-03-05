import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2115_¹ú²ÜÃ¤Ãë {
	private static int N;
	private static int M;
	private static int C;
	private static int[][] map;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			dp = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j*2) - '0';
				}
			}
			
			int answer = 0;

			for (int firstR = 0; firstR < N; firstR++) {
				for (int firstC = 0; firstC <= N - M; firstC++) {
					for (int secondR = firstR; secondR < N; secondR++) {
						if (firstR == secondR) {
							for (int secondC = firstC + M; secondC <= N - M; secondC++) {
								int firstH = calHoney(firstR, firstC);
								int secondH = calHoney(secondR, secondC);
								if(firstH+secondH > answer)
									answer = firstH+secondH;
							}
						} else {
							for (int secondC = 0; secondC <= N - M; secondC++) {
								int firstH = calHoney(firstR, firstC);
								int secondH = calHoney(secondR, secondC);
								if(firstH+secondH > answer)
									answer = firstH+secondH;
							}
						}
					}
				}
			}
			
			System.out.print("#" + test_case + " " + answer+ "\n");
			
		} // end of testcase
	} // end of main

	private static int max;
	private static int[] trr;
	public static int calHoney(int r, int c) {
		max = 0;
		if (dp[r][c] > 0) {
			return dp[r][c];
		} else {
			for (int i = 1; i <= M; i++) {
				trr = new int[i];
				comb(i, M, r, c);
			}
			

			return dp[r][c] = max;
		}
	}
	
	

	private static void comb(int r, int n, int curR, int curC) {
		if(r == 0) {
			int sum = 0;
			int sum2 = 0;
			for (int i = 0; i < trr.length; i++) {
				sum += trr[i]*trr[i];
				sum2 += trr[i];
			}
			if(max < sum && sum2 <= C) {
				max = sum;
			}
		} else if(n<r) {
			return;
		} else {
			trr[r-1] = map[curR][curC+M-n];
			comb(r-1,n-1,curR,curC);
			comb(r,n-1,curR,curC);
		}
		
	}

}
