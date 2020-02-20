import java.util.Scanner;

public class Baekjoon11559_PuyoPuyo_Hwang {
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new char[14][8];
		visited = new boolean[14][8];

		int answer = -1;

		// 뿌요뿌요 상태 입력
		for (int i = 1; i <= 12; i++) {
			String str = sc.next();
			for (int j = 1; j <= 6; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

		boolean toggle = true; // 터지는 뿌요가 있으면 true 없으면 false
		while (toggle) { // 터지는 뿌요가 없을때까지
			answer++;
			toggle = false;
			
			// 4개 이상 연결된 뿌요 터트리기
			for (int i = 1; i <= 12; i++) {
				for (int j = 1; j <= 6; j++) {
					if (map[i][j] > 64) {
						if (findLink(i, j, map[i][j], 1)) {
							toggle = true; // 터졌으면 true
						}
					}
				}
			}

			// 터진 후 뿌요 내려오기
			for (int i = 12; i >= 1; i--) {
				for (int j = 1; j <= 6; j++) {
					if (map[i][j] > 64) {
						int down = 1;
						while (map[i + down][j] == '.') {
							down++;
						}
						char temp = map[i][j];
						map[i][j] = '.';
						map[i + down - 1][j] = temp;
					}
				}
			}

		} // end of while

		System.out.println(answer);
	} // end of main

	public static boolean findLink(int curR, int curC, char Alpha, int linkNum) {
		visited[curR][curC] = true;

		for (int i = 0; i < 4; i++) {
			int nextR = curR + dr[i];
			int nextC = curC + dc[i];
			if (map[nextR][nextC] == Alpha && !visited[nextR][nextC]) { // 상하좌우
				if (findLink(nextR, nextC, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

			if (visited[curR - 1][curC] && !visited[curR - 1][curC - 1] && map[curR - 1][curC - 1] == Alpha) { // ㅜ
				if (findLink(curR - 1, curC - 1, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

			if (visited[curR - 1][curC] && !visited[curR - 1][curC + 1] && map[curR - 1][curC + 1] == Alpha) { // ㅜ
				if (findLink(curR - 1, curC + 1, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

			if (visited[curR + 1][curC] && !visited[curR + 1][curC - 1] && map[curR + 1][curC - 1] == Alpha) { // ㅗ
				if (findLink(curR + 1, curC - 1, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

			if (visited[curR + 1][curC] && !visited[curR + 1][curC + 1] && map[curR + 1][curC + 1] == Alpha) { // ㅗ
				if (findLink(curR + 1, curC + 1, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

			if (visited[curR][curC + 1] && !visited[curR - 1][curC + 1] && map[curR - 1][curC + 1] == Alpha) { // ㅓ
				if (findLink(curR - 1, curC + 1, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

			if (visited[curR][curC + 1] && !visited[curR + 1][curC + 1] && map[curR + 1][curC + 1] == Alpha) { // ㅓ
				if (findLink(curR + 1, curC + 1, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

			if (visited[curR][curC - 1] && !visited[curR - 1][curC - 1] && map[curR - 1][curC - 1] == Alpha) { // ㅏ
				if (findLink(curR - 1, curC - 1, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

			if (visited[curR][curC - 1] && !visited[curR + 1][curC - 1] && map[curR + 1][curC - 1] == Alpha) { // ㅏ
				if (findLink(curR + 1, curC - 1, Alpha, linkNum + 1)) {
					map[curR][curC] = '.';
					visited[curR][curC] = false;
					return true;
				}
			}

		}

		visited[curR][curC] = false;

		if (linkNum >= 4) { // 4개이상 연결되었으면 뿌요 터트리기
			map[curR][curC] = '.';
			return true;
		} else {
			return false;
		}

	} // end of findLink

}