import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1494_사랑의카운슬러 {
	private static ArrayList<int[]> arr;
	private static int N;
	private static boolean[] visited;
	private static long answer;
	private static long allX;
	private static long allY;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			allX = 0;
			allY = 0;

			arr = new ArrayList<int[]>();
			visited = new boolean[N];
			StringTokenizer st;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
				allX += arr.get(i)[0];
				allY += arr.get(i)[1];
			}

			answer = Long.MAX_VALUE;
			visited[0] = true;
			dfs(0, 1, arr.get(0)[0], arr.get(0)[1]);
			
			System.out.println("#" + test_case + " " + answer);
		}

	}

	public static void dfs(int i, int count, long curX, long curY) {
		if (count == N / 2) {
			long tempX = allX-2*curX;
			long tempY = allY-2*curY;
			if(answer > tempX*tempX + tempY*tempY) {
				answer = tempX*tempX + tempY*tempY;
			}

		} else {
			for (int j = i; j < visited.length; j++) {
				if (!visited[j]) {
					visited[j] = true;
					dfs(j, count + 1, curX+arr.get(j)[0], curY+arr.get(j)[1]);
					visited[j] = false;
				}

			}
		}

	}

}
