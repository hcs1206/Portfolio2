package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2941_크로아티아알파벳 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();

		for (int i = 0; i < word.length(); i++) {
			if (i == word.length() - 1) {
				answer++;
				break;
			}

			if (word.charAt(i) == 'c') {
				if (word.charAt(i + 1) == '=' || word.charAt(i + 1) == '-') {
					i++;
				}
			} else if (word.charAt(i) == 'd') {
				if (word.charAt(i + 1) == '-') {
					i++;
				} else if (i + 2 < word.length() && word.charAt(i + 1) == 'z' && word.charAt(i + 2) == '=') {
					i = i + 2;
				}

			} else if (word.charAt(i) == 'l') {
				if (word.charAt(i + 1) == 'j') {
					i++;
				}
			} else if (word.charAt(i) == 'n') {
				if (word.charAt(i + 1) == 'j') {
					i++;
				}
			} else if (word.charAt(i) == 's') {
				if (word.charAt(i + 1) == '=') {
					i++;
				}
			} else if (word.charAt(i) == 'z') {
				if (word.charAt(i + 1) == '=') {
					i++;
				}
			}

			answer++;

		}

		System.out.print(answer);

	}

}
