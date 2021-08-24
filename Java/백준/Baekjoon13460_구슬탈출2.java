package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon13460_구슬탈출2 {
	static int N;
	static int M;
	static int answer;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static class Ball {
		int r;
		int c;

		public Ball() {
			super();
		}

		public Ball(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 11;

		char[][] map = new char[N][M];
		Ball red = new Ball();
		Ball blue = new Ball();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					red = new Ball(i, j);
				} else if (map[i][j] == 'B') {
					blue = new Ball(i, j);
				}
			}
		}

		moveBall(map, -4, 0, red, blue);
		
		System.out.println(answer > 10 ? -1 : answer);

	}

	private static void moveBall(char[][] tempMap, int beforeDest, int moveCount, Ball red, Ball blue) {		
		if (moveCount >= answer)
			return;

		for (int dest = 0; dest < 4; dest++) {
			if (dest != (beforeDest + 2) % 4 && dest != beforeDest) {
				
				char[][] copyMap = new char[tempMap.length][tempMap[0].length];
				for (int i = 0; i < copyMap.length; i++) {
					System.arraycopy(tempMap[i], 0, copyMap[i], 0, tempMap[i].length);
				}

				int goalCnt = 0;
				int rnR = red.r + dr[dest];
				int rnC = red.c + dc[dest];

				int bnR = blue.r + dr[dest];
				int bnC = blue.c + dc[dest];

				while (copyMap[bnR][bnC] == '.') {
					bnR += dr[dest];
					bnC += dc[dest];
				}

				if (copyMap[bnR][bnC] == 'O') {
					goalCnt = -2;
					copyMap[blue.r][blue.c] = '.';

				} else {
					bnR -= dr[dest];
					bnC -= dc[dest];
					copyMap[blue.r][blue.c] = '.';
					copyMap[bnR][bnC] = 'B';
				}
				

				while (copyMap[rnR][rnC] == '.') {
					rnR += dr[dest];
					rnC += dc[dest];
				}
				if (copyMap[rnR][rnC] == 'O') {
					goalCnt++;
					copyMap[red.r][red.c] = '.';

				} else {
					rnR -= dr[dest];
					rnC -= dc[dest];
					copyMap[red.r][red.c] = '.';
					copyMap[rnR][rnC] = 'R';
				}
				
				copyMap[bnR][bnC] = '.';
				bnR += dr[dest];
				bnC += dc[dest];
				while (copyMap[bnR][bnC] == '.') {
					bnR += dr[dest];
					bnC += dc[dest];
				}

				if (copyMap[bnR][bnC] == 'O') {
					goalCnt = -2;
					copyMap[blue.r][blue.c] = '.';

				} else {
					bnR -= dr[dest];
					bnC -= dc[dest];
					copyMap[blue.r][blue.c] = '.';
					copyMap[bnR][bnC] = 'B';
				}

				if (goalCnt == 1) {
					if (moveCount + 1 < answer)
						answer = moveCount + 1;
				} else if (goalCnt == 0) {
					moveBall(copyMap, dest, moveCount + 1, new Ball(rnR, rnC), new Ball(bnR, bnC));
				} else {
					continue;
				}

			}
		}

	}

}
