package SW;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon3190_뱀_ver2 {

	static class Snake {
		int r;
		int c;
		int dest;

		public Snake(int r, int c, int dest) {
			super();
			this.r = r;
			this.c = c;
			this.dest = dest;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int answer = 0;

		int[] dr = { 1, 0, -1, 0 }; // 남동북서
		int[] dc = { 0, 1, 0, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r - 1][c - 1] = 1;
		}

		int L = Integer.parseInt(br.readLine());

		Deque<Snake> snake = new ArrayDeque<>();
		snake.add(new Snake(0, 0, 1));
		map[0][0] = 2;

		char[] sec = new char[N * N];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			sec[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}

		for (answer = 1; answer < N * N; answer++) {
			Snake head = snake.getLast();

			int nR = head.r + dr[head.dest];
			int nC = head.c + dc[head.dest];

			if (nR < 0 || nC < 0 || nR >= N || nC >= N || map[nR][nC] == 2) {
				break;
			}

			if (map[nR][nC] == 0) {
				Snake tail = snake.pollFirst();
				map[tail.r][tail.c] = 0;
			}

			map[nR][nC] = 2;
			
			if (sec[answer] == 'D') {
				snake.add(new Snake(nR, nC, (head.dest + 3) % 4));
			} else if(sec[answer] == 'L') {
				snake.add(new Snake(nR, nC, (head.dest + 1) % 4));
			} else {
				snake.add(new Snake(nR, nC, head.dest));
			}
		}

		System.out.print(answer);

	}

}
