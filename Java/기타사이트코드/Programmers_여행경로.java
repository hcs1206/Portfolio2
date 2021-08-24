package SW;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Programmers_여행경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[][] str = {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}};

		solution(str);

	}

	static boolean[] visited;
	static boolean escape;

	public static String[] solution(String[][] tickets) {
		String[] answer = {};

		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(!o1[0].equals(o2[0])) {
					return o1[0].compareTo(o2[0]);
				}
				else {
					return o1[1].compareTo(o2[1]);
				}
				
			}

		});

		visited = new boolean[tickets.length];

		answer = new String[tickets.length + 1];

		makeTravel(tickets, 0, answer);

		return answer;
	}

	private static void makeTravel(String[][] tickets, int cnt, String[] answer) {
		if (tickets.length == cnt) {
			escape = true;
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (cnt == 0 && !tickets[i][0].equals("ICN"))
				continue;
			
			if (!visited[i] && cnt == 0) {
				visited[i] = true;
				answer[cnt] = tickets[i][0];
				answer[cnt + 1] = tickets[i][1];
				makeTravel(tickets, cnt + 1, answer);
				if (escape)
					return;
				visited[i] = false;
			} else if (!visited[i] && tickets[i][0].equals(answer[cnt])) {
				visited[i] = true;
				answer[cnt] = tickets[i][0];
				answer[cnt + 1] = tickets[i][1];
				makeTravel(tickets, cnt + 1, answer);
				if (escape)
					return;
				visited[i] = false;
			}

		}

	}

}
