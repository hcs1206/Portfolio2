import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Baekjoon3190_뱀 {

	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2;
		}

		map[1][1] = 1;
		int L = Integer.parseInt(br.readLine());
		ArrayList<int[]> info = new ArrayList<int[]>();

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			if (C == 'L') {
				info.add(new int[] { X, 0 });
			} else {
				info.add(new int[] { X, 1 });
			}
		}

		Deque<int[]> snake = new LinkedList<int[]>();
		snake.add(new int[] { 1, 1 });
		int dest = 1;
		int answer = 0;

		for (int i = 0;;) {

			int[] arr = new int[2];
			if(i< info.size()) {
				arr = info.get(i);
			}
			
			answer++;

			int nextR = snake.getFirst()[0] + dr[dest];
			int nextC = snake.getFirst()[1] + dc[dest];

			if (nextR > N || nextC > N || nextR < 1 || nextC < 1 || map[nextR][nextC] == 1) {
				break;
			}

			if (map[nextR][nextC] == 2) {
				map[nextR][nextC] = 1;
				snake.addFirst(new int[] { nextR, nextC });
			} else if (map[nextR][nextC] == 0) {
				int[] tail = snake.removeLast();
				map[tail[0]][tail[1]] = 0;
				map[nextR][nextC] = 1;
				snake.addFirst(new int[] { nextR, nextC });
			}

			if (answer == arr[0]) {
				if (arr[1] == 0) {
					dest = (dest + 3) % 4;
				} else {
					dest = (dest + 1) % 4;
				}
				i++;
			}
		}

		System.out.println(answer);

	} // end of main
} // end of class