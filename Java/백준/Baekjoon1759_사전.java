package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon1759_사전 {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] numArr = new Integer[N];
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		if (numArr.length == 1) {
			System.out.print(-1);
			return;
		}

		for (int i = numArr.length - 1; i > 0; i--) {
			if (numArr[i] < numArr[i - 1]) {

				int index = i - 1;
				int temp = numArr[index];
				for (int j = numArr.length - 1; j > index; j--) {
					if (numArr[j] < numArr[index]) {
						numArr[index] = numArr[j];
						numArr[j] = temp;
						break;
					}
				}
				Integer[] copyArr = new Integer[numArr.length - index - 1];
				System.arraycopy(numArr, index + 1, copyArr, 0, copyArr.length);
				Arrays.sort(copyArr, Collections.reverseOrder());

				for (int j = 0; j <= index; j++) {
					System.out.print(numArr[j] + " ");
				}
				for (int j = 0; j < copyArr.length; j++) {
					System.out.print(copyArr[j] + " ");
				}
				return;
			}
		}

		System.out.print(-1);

	}

}
