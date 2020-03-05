import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon18513_ป๙ลอ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long answer = 0;

		ArrayList<Integer> home = new ArrayList<Integer>();
		HashSet<Integer> hs = new HashSet<Integer>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			home.add(Integer.parseInt(st.nextToken()));
			hs.add(home.get(i));
		}

		int cnt = 1;
		int homePos;
		boolean check;
		
		startLoop: while (K > 0) {
			for (int i = 0; i < home.size(); i++) {
				check = false;

				homePos = home.get(i) - cnt;
				if (K > 0 && !hs.contains(homePos)) {
					answer += cnt;
					hs.add(homePos);
					K--;
					check = true;
				}

				homePos = home.get(i) + cnt;
				if (K > 0 && !hs.contains(homePos)) {
					answer += cnt;
					hs.add(homePos);
					K--;
					check = true;
				}

				if (K == 0)
					break startLoop;

				if (!check) {
					home.remove(i);
					i--;
				}
			}
			cnt++;
		}

		System.out.print(answer);
	}

}
