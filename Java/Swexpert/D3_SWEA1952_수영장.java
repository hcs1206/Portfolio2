import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952_수영장 {
	private static int[] ticket;
	private static int[] year;
	private static int answer;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ticket = new int[4];
			for (int i = 0; i < 4; i++) {
				ticket[i] = Integer.parseInt(st.nextToken());
			}

			year = new int[12];
			visited = new boolean[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < year.length; i++) {
				year[i] = Integer.parseInt(st.nextToken());
			}
			answer = ticket[3];

			for (int i = 0; i <= 12; i++) {
				for (int j = 0; j <= 4; j++) {
					if (i + 3 * j <= 12) {
						// System.out.println("month: " + i + " tmonth: " + j);
						calPrice(i, j, 0, 0, 0);
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		} // end of tc
	} // end of main

	public static void calPrice(int month, int tMonth, int index, int index2, int sum) {
		if (month == 0 && tMonth == 0) {
			for (int i = 0; i < year.length; i++) {
				if (!visited[i]) {
					sum += year[i] * ticket[0];
				}
			}
			if (answer > sum)
				answer = sum;
		} else {
			for (int i = index; i < year.length; i++) {
					if (!visited[i] && month > 0) {
						visited[i] = true;
						calPrice(month - 1, tMonth, i, index2, sum + ticket[1]);
						visited[i] = false;
					}
			}
			for (int i = index2; i < year.length-2; i++) {
				if (!visited[i] && !visited[i + 1] && !visited[i + 2] && tMonth > 0) {
					visited[i] = true;
					visited[i + 1] = true;
					visited[i + 2] = true;
					calPrice(month, tMonth - 1, index, i, sum + ticket[2]);
					visited[i] = false;
					visited[i + 1] = false;
					visited[i + 2] = false;
				}
			}
		}

	}
}
