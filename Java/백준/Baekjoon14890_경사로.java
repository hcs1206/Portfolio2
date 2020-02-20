import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon14890_경사로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 2 * N;

		for (int r = 1; r <= N; r++) {
			int curHeight = map[r][1];
			for (int c = 2; c <= N; c++) {
				if (map[r][c] == curHeight - 1) {
					boolean check = true;
					for (int i = 0; i < L; i++) {
						if (c + i <= N) {
							if (map[r][c + i] == curHeight - 1) {
								continue;
							}
							else {
								check = false;
								answer--;
								break;
							}
						} else {
							check = false;
							answer--;
							break;
						}
					}
					
					curHeight = map[r][c];
					
					if(check && c+L <= N) {
						for (int i = 0; i < L; i++) {
							if(map[r][c+L+i] == curHeight+1) {
								answer--;
								break;
							}
						}
										
					}
					
					if (!check)
						break;
				} else if (map[r][c] == curHeight + 1) {
					boolean check = true;
					for (int i = 1; i <= L; i++) {
						if (c - i > 0) {
							if (map[r][c - i] == curHeight) {
								continue;
							}
							else {
								check = false;
								answer--;
								break;
							}
						} else {
							check = false;
							answer--;
							break;
						}
					}
					
					curHeight = map[r][c];
					if (!check)
						break;
					

				} else if (map[r][c] == curHeight) {
					continue;
				} else {
					answer--;
					break;
				}
			}
		}
				
		for (int r = 1; r <= N; r++) {
			int curHeight = map[1][r];
			for (int c = 2; c <= N; c++) {
				if (map[c][r] == curHeight - 1) {
					boolean check = true;
					for (int i = 0; i < L; i++) {
						if (c + i <= N) {
							if (map[c+i][r] == curHeight - 1) {
								continue;
							}
							else {
								check = false;
								answer--;
								break;
							}
						} else {
							check = false;
							answer--;
							break;
						}
					}
					
					curHeight = map[c][r];
					
					if(check && c+L <= N) {
						for (int i = 0; i < L; i++) {
							if(map[c+L][r] == curHeight+1) {
								answer--;
								break;
							}							
						}
							
					}
					
					
					if (!check)
						break;
				} else if (map[c][r] == curHeight + 1) {
					boolean check = true;
					for (int i = 1; i <= L; i++) {
						if (c - i > 0) {
							if (map[c-i][r] == curHeight) {
								continue;
							}
							else {
								check = false;
								answer--;
								break;
							}
						} else {
							check = false;
							answer--;
							break;
						}
					}
					
					curHeight = map[c][r];
					if (!check)
						break;
					

				} else if (map[c][r] == curHeight) {
					continue;
				} else {
					answer--;
					break;
				}
			}
		}
		
		System.out.println(answer);

	}
}
