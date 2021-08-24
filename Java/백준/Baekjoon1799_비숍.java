package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1799_비숍 {

	static int answer;

	static class Bishop {
		int x;
		int y;

		public Bishop(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			Bishop b = (Bishop) o;
			if (Math.abs(this.x - b.x) == Math.abs(this.y - b.y))
				return true;

			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j * 2) - '0';
			}
		}
		List<Bishop> list = new ArrayList<Bishop>();

		placeBishop(map, 0, 0, 1, list, 0);
		placeBishop(map, answer, 0, 0, list, 1);

		System.out.print(answer);

	}

	private static void placeBishop(int[][] map, int cnt, int r, int c, List<Bishop> list, int flag) {
		if (answer < cnt)
			answer = cnt;

		for (int i = r; i < map.length; i++) {
			loop: for (int j = i == r ? c : 0; j < map.length; j++) {
				if ((i + j) % 2 == flag) {
					continue;
				}

				if (map[i][j] > 0) {
					Bishop temp = new Bishop(i, j);

					for (int k = 0; k < list.size(); k++) {
						if (temp.equals(list.get(k)))
							continue loop;
					}

					list.add(temp);

					placeBishop(map, cnt + 1, i, j + 1, list, flag);

					list.remove(list.size() - 1);
				}
			}
		}
	}

}
