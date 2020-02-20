import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14503_로봇청소기 {
	private static int M;
	private static int N;
	private static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }; // 북 동 남 서
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		int answer = 0;

		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(2 * j) - '0';
			}
		}

		while (true) {
			if (map[r][c] == 0) {
				map[r][c] = 2;
				answer++;
			}

			boolean check = true;
			for (int i = 0; i < 4; i++) {
				// 2
				int nextDest = (dest + 3) % 4;
				int nextR = r + dr[nextDest];
				int nextC = c + dc[nextDest];

				// 2-a
				if (map[nextR][nextC] == 0) {
					r = nextR;
					c = nextC;
					dest = nextDest;
					check = false;
					break;
				}
				else {
					dest = nextDest;
					continue;
				}
			}

			if (check) {
				// 2-c
				int backDest = (dest + 2) % 4;
				int backR = r + dr[backDest];
				int backC = c + dc[backDest];
				if (checkBound(backR, backC) && map[backR][backC] != 1) {
					r = backR;
					c = backC;
				}
				// 2-d
				else {
					break;
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

		} // end of while

		System.out.println(answer);

	}

	public static boolean checkBound(int r, int c) {
		if (r < N && r >= 0 && c < M && c >= 0)
			return true;

		return false;
	}

}
