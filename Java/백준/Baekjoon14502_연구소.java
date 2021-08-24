package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon14502_연구소 {

	static int N;
	static int M;
	static int answer;
	static List<int[]> virus;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		answer = 0;

		virus = new ArrayList<>();

		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(2 * j);
				if (map[i][j] == '2') {
					virus.add(new int[] { i, j });
				}
			}
		}

		comb(map, 0);

		System.out.println(answer);
	}

	private static void comb(char[][] map, int wallNum) {
		if (wallNum == 3) {
			char[][] copyMap = new char[map.length][map[0].length];
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
			}

			for (int[] curVirus : virus) {
				diffVirus(copyMap, curVirus[0], curVirus[1]);
			}
			
			int cnt = 0;
			
			for (int i = 0; i < copyMap.length; i++) {
				for (int j = 0; j < copyMap[i].length; j++) {
					if(copyMap[i][j] == '0')
						cnt++;
				}
			}
			
			if(cnt > answer)
				answer = cnt;

			return;

		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '0') {
					map[i][j] = '1';
					comb(map, wallNum + 1);
					map[i][j] = '0';
				}
			}
		}

	}

	private static void diffVirus(char[][] map, int r, int c) {

		for (int dest = 0; dest < 4; dest++) {
			int nR = r + dr[dest];
			int nC = c + dc[dest];

			if (nR < 0 || nC < 0 || nR >= N || nC >= M || map[nR][nC] != '0')
				continue;

			map[nR][nC] = '1';
			diffVirus(map, nR, nC);

		}

	}

}
