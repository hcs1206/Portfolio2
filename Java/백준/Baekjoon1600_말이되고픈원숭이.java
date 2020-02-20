import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1600_말이되고픈원숭이 {

	private static int[][] map;

	static class Monkey {
		public Monkey(int r, int c, int mv, int k) {
			this.r = r;
			this.c = c;
			this.mv = mv;
			this.k = k;
		}

		int r;
		int c;
		int mv;
		int k;
	}

	static int[] dr = { 2, 1, -1, -2, -2, -1, 1, 2, 1, 0, -1, 0 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1, 0, 1, 0, -1 };
	private static int W;
	private static int H;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());

		H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H + 2][W + 2];
		boolean[][][] visited = new boolean[32][H + 2][W + 2];

		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Monkey> q = new LinkedList<Monkey>();

		visited[0][1][1] = true;
		for (int i = 0; i < dr.length; i++) {
			int nextR = 1+dr[i];
			int nextC = 1+dc[i];
			if (nextR > 0 && nextC > 0 && nextR <= H && nextC <= W && map[nextR][nextC] == 0) {
				if (i < 8 && K > 0) {
					visited[1][nextR][nextC] = true;
					q.offer(new Monkey(nextR, nextC, 1, 1));
				} else if (i >= 8) {
					visited[0][nextR][nextC] = true;
					q.offer(new Monkey(nextR, nextC, 1, 0));
				}
			}
		}

		int answer = -1;
		while (!q.isEmpty()) {
			
			Monkey m = q.poll();
			int curR = m.r;
			int curC = m.c;
			int curMv = m.mv;
			int curK = m.k;
			int nextR=0;
			int nextC=0;

			for (int i = 0; i < dr.length; i++) {
				nextR = curR + dr[i];
				nextC = curC + dc[i];
				if (nextR > 0 && nextC > 0 && nextR <= H && nextC <= W) {
					if (!visited[curK+1][nextR][nextC] && map[nextR][nextC] == 0) {
						if (i < 8 && K > curK) {
							visited[curK+1][nextR][nextC] = true;
							q.offer(new Monkey(nextR, nextC, curMv + 1, curK + 1));
							if (nextR == H && nextC == W) {
								answer = curMv+1;
								break;
							}
							
						}
					}
					
					if(!visited[curK][nextR][nextC] && map[nextR][nextC] == 0) {
						if (i >= 8) {
							visited[curK][nextR][nextC] = true;
							q.offer(new Monkey(nextR, nextC, curMv + 1, curK));
							if (nextR == H && nextC == W) {
								answer = curMv+1;
								break;
							}
						}
					}
				}
			} // end of for
			
			if (nextR == H && nextC == W) {
				answer = curMv+1;
				break;
			}
		} // end of while
		System.out.println(answer);

	} // end of main

}
