import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13460_±∏ΩΩ≈ª√‚2 {
	private static int N;
	private static int M;
	private static char[][] board;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		int rbR = 0, rbC = 0, bbR = 0, bbC = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
				if (board[i][j] == 'R') {
					rbR = i;
					rbC = j;
				} else if (board[i][j] == 'B') {
					bbR = i;
					bbC = j;
				}
			}
		}

		answer = Integer.MAX_VALUE;

		dfs(rbR, rbC, bbR, bbC, 0, -1);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

	}

	private static void dfs(int rbR, int rbC, int bbR, int bbC, int count, int dir) {
		if (board[rbR][rbC] == 'O') {
			if (board[bbR][bbC] == 'O')
				return;

			if (answer > count)
				answer = count;
		} else if (board[bbR][bbC] == 'O') {
			return;
		} else {
			if (count < 10) {
				if (dir != 0) { // ¡¬ øÏ
					/////////////// ¡¬ ///////////////
					if (rbC < bbC) {
						int nRbC;
						int nBbC;
						for (int i = rbC - 1;; i--) {
							if (board[rbR][i] == 'O') {
								nRbC = i;
								break;
							}

							if (board[rbR][i] == '#') {
								nRbC = i + 1;
								break;
							}
						}

						for (int i = bbC - 1;; i--) {
							if (board[bbR][i] == 'O') {
								nBbC = i;
								break;
							}

							if (board[bbR][i] == '#') {
								nBbC = i + 1;
								break;
							}

							if (bbR == rbR && i == nRbC) {
								nBbC = i + 1;
								break;
							}
						}

						dfs(rbR, nRbC, bbR, nBbC, count + 1, 0);
					} else {
						int nRbC;
						int nBbC;

						for (int i = bbC - 1;; i--) {
							if (board[bbR][i] == 'O') {
								nBbC = i;
								break;
							}

							if (board[bbR][i] == '#') {
								nBbC = i + 1;
								break;
							}
						}

						for (int i = rbC - 1;; i--) {
							if (board[rbR][i] == 'O') {
								nRbC = i;
								break;
							}

							if (board[rbR][i] == '#') {
								nRbC = i + 1;
								break;
							}

							if (bbR == rbR && i == nBbC) {
								nRbC = i + 1;
								break;
							}
						}

						dfs(rbR, nRbC, bbR, nBbC, count + 1, 0);
					}

					/////////////////// øÏ //////////////////
					if (rbC < bbC) {
						int nRbC;
						int nBbC;

						for (int i = bbC + 1;; i++) {
							if (board[bbR][i] == 'O') {
								nBbC = i;
								break;
							}

							if (board[bbR][i] == '#') {
								nBbC = i - 1;
								break;
							}
						}

						for (int i = rbC + 1;; i++) {
							if (board[rbR][i] == 'O') {
								nRbC = i;
								break;
							}

							if (board[rbR][i] == '#') {
								nRbC = i - 1;
								break;
							}

							if (bbR == rbR && i == nBbC) {
								nRbC = i - 1;
								break;
							}
						}

						dfs(rbR, nRbC, bbR, nBbC, count + 1, 0);
					} else { // øÏ
						int nRbC;
						int nBbC;
						for (int i = rbC + 1;; i++) {
							if (board[rbR][i] == 'O') {
								nRbC = i;
								break;
							}

							if (board[rbR][i] == '#') {
								nRbC = i - 1;
								break;
							}
						}

						for (int i = bbC + 1;; i++) {
							if (board[bbR][i] == 'O') {
								nBbC = i;
								break;
							}

							if (board[bbR][i] == '#') {
								nBbC = i - 1;
								break;
							}

							if (bbR == rbR && i == nRbC) {
								nBbC = i - 1;
								break;
							}
						}

						dfs(rbR, nRbC, bbR, nBbC, count + 1, 0);
					}

				} // end of ¡¬øÏ

				if (dir != 1) { // ªÛ «œ

					//////////////////// «œ ///////////////////
					if (rbR < bbR) {
						int nRbR;
						int nBbR;

						for (int i = bbR + 1;; i++) {
							if (board[i][bbC] == 'O') {
								nBbR = i;
								break;
							}

							if (board[i][bbC] == '#') {
								nBbR = i - 1;
								break;
							}
						}

						for (int i = rbR + 1;; i++) {
							if (board[i][rbC] == 'O') {
								nRbR = i;
								break;
							}

							if (board[i][rbC] == '#') {
								nRbR = i - 1;
								break;
							}

							if (rbC == bbC && i == nBbR) {
								nRbR = i - 1;
								break;
							}
						}

						dfs(nRbR, rbC, nBbR, bbC, count + 1, 1);
					} else {
						int nRbR;
						int nBbR;

						for (int i = rbR + 1;; i++) {
							if (board[i][rbC] == 'O') {
								nRbR = i;
								break;
							}

							if (board[i][rbC] == '#') {
								nRbR = i - 1;
								break;
							}
						}

						for (int i = bbR + 1;; i++) {
							if (board[i][bbC] == 'O') {
								nBbR = i;
								break;
							}

							if (board[i][bbC] == '#') {
								nBbR = i - 1;
								break;
							}

							if (rbC == bbC && i == nRbR) {
								nBbR = i - 1;
								break;
							}
						}

						dfs(nRbR, rbC, nBbR, bbC, count + 1, 1);
					}

					//////////////////// ªÛ ///////////////////
					if (rbR < bbR) {
						int nRbR;
						int nBbR;

						for (int i = rbR - 1;; i--) {
							if (board[i][rbC] == 'O') {
								nRbR = i;
								break;
							}

							if (board[i][rbC] == '#') {
								nRbR = i + 1;
								break;
							}
						}

						for (int i = bbR - 1;; i--) {
							if (board[i][bbC] == 'O') {
								nBbR = i;
								break;
							}

							if (board[i][bbC] == '#') {
								nBbR = i + 1;
								break;
							}

							if (rbC == bbC && i == nRbR) {
								nBbR = i + 1;
								break;
							}
						}

						dfs(nRbR, rbC, nBbR, bbC, count + 1, 1);
					} else {
						int nRbR;
						int nBbR;

						for (int i = bbR - 1;; i--) {
							if (board[i][bbC] == 'O') {
								nBbR = i;
								break;
							}

							if (board[i][bbC] == '#') {
								nBbR = i + 1;
								break;
							}
						}

						for (int i = rbR - 1;; i--) {
							if (board[i][rbC] == 'O') {
								nRbR = i;
								break;
							}

							if (board[i][rbC] == '#') {
								nRbR = i + 1;
								break;
							}

							if (rbC == bbC && i == nBbR) {
								nRbR = i + 1;
								break;
							}
						}

						dfs(nRbR, rbC, nBbR, bbC, count + 1, 1);
					}
				} // end of ªÛ «œ

			} // end of count
		}

	}

}
