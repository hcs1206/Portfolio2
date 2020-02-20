import java.util.Arrays;
import java.util.Scanner;

public class Jungol1828_냉장고 {

	static class Refrigerator implements Comparable<Refrigerator> {
		Refrigerator(int s, int e) {
			start = s;
			end = e;
		}
		int start;
		int end;
		public int compareTo(Refrigerator r) {
			return this.start - r.start;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Refrigerator[] r = new Refrigerator[N];
		int answer = 1;
		for (int i = 0; i < N; i++) {
			r[i] = new Refrigerator(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(r);

		int curEnd = r[0].end;
		for (int i = 1; i < r.length; i++) {
			if (r[i].start <= curEnd) {
				if(curEnd > r[i].end)
					curEnd = r[i].end;
			} else {
				curEnd = r[i].end;
				answer++;
			}
		}

		System.out.println(answer);
	}
}
