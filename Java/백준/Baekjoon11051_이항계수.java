package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11051_이항계수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] comb = new int[N + 1][K + 1];

		for (int i = 0; i < comb.length; i++) {
			comb[i][0] = 1;
		}
		

		for (int i = 1; i < comb.length; i++) {
			for (int j = 1; j < comb[i].length; j++) {
				comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % 10007;

			}
		}

		System.out.println(comb[N][K]);

	}

}
