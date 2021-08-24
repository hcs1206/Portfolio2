package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = 0;

		int N;
		boolean[] alphabet;
		String word;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		loop: for (int i = 0; i < N; i++) {
			alphabet = new boolean[26];
			word = br.readLine();
			for (int j = 0; j < word.length(); j++) {
				if (alphabet[word.charAt(j) - 97]) {
					if (word.charAt(j) != word.charAt(j - 1)) {
						continue loop;
					}
				} else {
					alphabet[word.charAt(j) - 97] = true;
				}
			}
			answer++;

		}

		System.out.print(answer);

	}

}
