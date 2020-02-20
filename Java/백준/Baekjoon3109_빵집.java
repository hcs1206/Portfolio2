import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon3109_빵집 {
	private static int R;
	private static int C;
	private static int[][] map;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		answer = 100000;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j) == 'x')
					map[i][j] = 100000;
			}
		}
		
		for(int i=0; i<R; i++) {
			map[i][0] = 1;
		}
		
		
		for (int j = 0; j < C-1; j++) {
			for (int i = 0; i < R; i++) {
				if(map[i][j] > 0 && map[i][j] < 100000) {
					for (int k = 0; k < dr.length; k++) {
						int nr = i +dr[k];
						int nc = j + 1;
						if(nr >=0 && nr<R && map[i][j] != 100000) {
							map[nr][nc]++;
						}
					}
				}
				
			}	
		}
		
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		for (int i = 1; i < C-1; i++) {
			int temp = 0;
			for (int j = 0; j < R; j++) {
				if(temp < map[j][i] && map[j][i] < 100000) {
					temp = map[j][i];
				}
			}
			if(temp < answer) {
				answer = temp;
			}
		}

		System.out.println(answer);

	}

	static int dr[] = { -1, 0, 1 };


}
