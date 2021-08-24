package SW;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1600_말이되고픈원숭이_ver2 {
	static class Monkey {
		int r;
		int c;
		int jump;
		int cnt;

		public Monkey(int r, int c, int jump, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.jump = jump;
			this.cnt = cnt;
		}

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int[] hDr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] hDc = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][][] visited = new boolean[K + 1][H][W];

		Queue<Monkey> q = new LinkedList<>();
		q.offer(new Monkey(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Monkey curMonkey = q.poll();

			if (curMonkey.r == H - 1 && curMonkey.c == W - 1) {
				answer = curMonkey.cnt;
				break;
			}

			for (int dest = 0; dest < 4; dest++) {
				int nR = curMonkey.r + dr[dest];
				int nC = curMonkey.c + dc[dest];

				if (nR < 0 || nC < 0 || nR >= H || nC >= W || visited[curMonkey.jump][nR][nC] || map[nR][nC] == 1)
					continue;

				visited[curMonkey.jump][nR][nC] = true;
				q.offer(new Monkey(nR, nC, curMonkey.jump, curMonkey.cnt + 1));
			}

			if (curMonkey.jump < K) {
				for (int dest = 0; dest < 8; dest++) {
					int nR = curMonkey.r + hDr[dest];
					int nC = curMonkey.c + hDc[dest];

					if (nR < 0 || nC < 0 || nR >= H || nC >= W || visited[curMonkey.jump+1][nR][nC] || map[nR][nC] == 1)
						continue;

					visited[curMonkey.jump + 1][nR][nC] = true;
					q.offer(new Monkey(nR, nC, curMonkey.jump + 1, curMonkey.cnt + 1));
				}
			}

		}

		System.out.print(answer);

	}

}
