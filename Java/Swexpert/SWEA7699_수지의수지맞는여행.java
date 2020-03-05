import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7699_수지의수지맞는여행 {
	private static boolean[] visited;
	private static int ans;
	private static char[][] map;
	private static int R;
	private static int C;
    private static int maxNum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
            maxNum = 0;

			boolean[] visited2 = new boolean['Z'-'A'+1];

			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(!visited2[str.charAt(j) - 'A']) {
						maxNum++;
						visited2[str.charAt(j) - 'A'] = true;
					}
				}
			}

			visited = new boolean['Z' - 'A' + 1];
			visited[map[0][0] - 'A'] = true;
			ans = 0;

			dfs(0, 0, 1);

			System.out.println("#" + test_case + " " + ans);
		}
	}

	private static void dfs(int r, int c, int count) {
		if (count > ans)
			ans = count;
        
        if(ans >= maxNum) return;

		if (r - 1 >= 0 && !visited[map[r - 1][c] - 'A']) {
			visited[map[r - 1][c] - 'A'] = true;
			dfs(r - 1, c, count + 1);
			visited[map[r - 1][c] - 'A'] = false;
		}

		if (r + 1 < R && !visited[map[r + 1][c] - 'A']) {
			visited[map[r + 1][c] - 'A'] = true;
			dfs(r + 1, c, count + 1);
			visited[map[r + 1][c] - 'A'] = false;
		}

		if (c - 1 >= 0 && !visited[map[r][c - 1] - 'A']) {
			visited[map[r][c - 1] - 'A'] = true;
			dfs(r, c - 1, count + 1);
			visited[map[r][c - 1] - 'A'] = false;
		}

		if (c + 1 < C && !visited[map[r][c + 1] - 'A']) {
			visited[map[r][c + 1] - 'A'] = true;
			dfs(r, c + 1, count + 1);
			visited[map[r][c + 1] - 'A'] = false;
		}

	}
}
