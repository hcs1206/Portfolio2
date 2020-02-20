import java.util.LinkedList;
import java.util.Scanner;

public class Solution_SWEA_1228_암호문1_황창섭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			LinkedList<Integer> str = new LinkedList<Integer>();
			for (int i = 0; i < N; i++) {
				str.add(sc.nextInt());
			}
			int C = sc.nextInt();
			
			for (int i = 0; i < C; i++) {
				char c = sc.next().charAt(0);
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int j=0; j<y; j++) {
					if(x > 9) {
						sc.nextInt();
					}
					else {
						str.add(x++,sc.nextInt());
					}
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(str.get(i)+ " ");
			}
			System.out.println();
		}
	}
}
