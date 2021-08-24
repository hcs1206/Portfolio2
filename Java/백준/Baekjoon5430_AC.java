package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			String arr = br.readLine();
			String[] sp = arr.substring(1, arr.length() - 1).split(",");
			for (int j = 0; j < n; j++) {

				dq.offer(Integer.parseInt(sp[j]));

			}
			boolean toggle = false;
			boolean errorDisplay = false;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'R') {
					toggle = !toggle;
				} else {
					if (dq.size() == 0) {
						sb.append("error\n");
						errorDisplay = true;
						break;
					}
					if (toggle) {
						dq.removeLast();
					} else {
						dq.remove();
					}
				}
			}

			if (!errorDisplay) {
				if (toggle) {
					sb.append("[");
					if(!dq.isEmpty())
						sb.append(dq.pollLast());
					while (!dq.isEmpty()) {
						sb.append(",").append(dq.pollLast());
					}
					sb.append("]\n");

				} else {
					sb.append("[");
					if(!dq.isEmpty())
						sb.append(dq.poll());
					while (!dq.isEmpty()) {
						sb.append(",").append(dq.poll());
					}
					sb.append("]\n");
				}
			}

		}

		System.out.print(sb);

	}

}
