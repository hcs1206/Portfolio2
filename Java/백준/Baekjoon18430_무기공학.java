package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18430_무기공학 {
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				visited[i][j] = true;
				makeBoom(i, j, 1, map[i][j], 0);
				makeBoom(i, j, 1, map[i][j], 1);
				visited[i][j] = false;
			}
		}

	}

	private static void makeBoom(int curR, int curC, int cnt, int sum, int dest) {
		if (cnt == 3) {
			if (curC >= map[0].length) {
				curC = 0;
			}
			if (curR >= map.length - 1) {

			}

			for (int i = curR; i < map.length; i++) {
				for (int j = curC; j < map[i].length; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						makeBoom(i, j, 1, sum + map[i][j], 0);
						makeBoom(i, j, 1, sum + map[i][j], 1);
						visited[i][j] = false;
					}
				}
			}
		}

		for (int i = 0; i < dc.length; i++) {
			if (dest % 2 != i % 2) {
				int nR = curR + dr[i];
				int nC = curC + dc[i];

				if (nR < 0 || nC < 0 || nR >= map.length || nC >= map[0].length || visited[nR][nC])
					return;

				visited[nR][nC] = true;
//				makeBoom(nR, nC);
			}
		}

	}

}
