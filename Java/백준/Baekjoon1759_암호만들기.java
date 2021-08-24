package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759_암호만들기 {

	static int L, C;
	static char[] alpha;
	static String[] vowel = { "a", "e", "i", "o", "u" };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alpha = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alpha);

		comb("", 0, 0);

	}

	private static void comb(String password, int cnt, int c) {
		if (cnt == L) {
			int vowelCnt = 0;
			for (int i = 0; i < vowel.length; i++) {
				if (password.contains(vowel[i])) {
					vowelCnt++;
				}

			}
			
			if(vowelCnt >= 1 && password.length()-vowelCnt >= 2) {
				System.out.println(password);
			}
			
			return;

		} else if (c >= C)
			return;

		comb(password + alpha[c], cnt + 1, c + 1);
		comb(password, cnt, c + 1);

	}

}
