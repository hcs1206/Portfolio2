import java.util.Arrays;
import java.util.Scanner;

public class SWEA4408_자기방으로돌아가기 {

	static class Room implements Comparable<Room> {
		Room(int s, int d) {
			start = s;
			dest = d;
		}

		int start;
		int dest;

		public int compareTo(Room r) {
			return this.start - r.start;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			Room[] r = new Room[N];
			for (int i = 0; i < r.length; i++) {
				int cur = sc.nextInt();
				int des = sc.nextInt();
				if(cur%2 == 1) {
					cur++;
				}
				if(des%2 == 1) {
					des++;
				}
				if (cur > des) {
					r[i] = new Room(des / 2, cur / 2);
				} else {
					r[i] = new Room(cur / 2, des / 2);
				}

			}

			int[] arr = new int[201];
			int answer = 0;
			for (int i = 0; i < r.length; i++) {
				for (int j = r[i].start; j <= r[i].dest; j++) {
					arr[j]++;
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] > answer)
					answer = arr[i];
			}
			
			System.out.println("#" + test_case + " " + answer);

		}
	}

}
