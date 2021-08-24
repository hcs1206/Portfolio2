package SW;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers_전화번호목록 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] str = { "119", "97674223", "1195524421" };
		solution(str);

	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		for (int i = 0; i < phone_book.length - 1; i++) {
			String prefix = phone_book[i];
			for (int j = i + 1; j < phone_book.length; j++) {
				String compareStr = phone_book[j];
				if (compareStr.substring(0, prefix.length()).equals(prefix)) {
					return false;
				}
			}
		}

		return answer;
	}

}
