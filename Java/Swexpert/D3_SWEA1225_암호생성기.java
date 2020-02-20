import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_SWEA_1225_암호생성기_황창섭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 0; test_case < 10; test_case++) {
			int T = sc.nextInt();
//			Queue<Integer> q = new LinkedList<Integer>();
//			for (int i = 0; i < 8; i++) {
//				q.offer(sc.nextInt());
//			}
//			
//			boolean toggle = true;
//			while(toggle) {
//				for(int j=1; j<=5; j++) {
//					int cur = q.poll()-j;
//					if(cur <= 0) {
//						cur = 0;
//						q.offer(cur);
//						toggle = false;
//						break;
//					}
//					q.offer(cur);
//				}
//			}
//			
//			System.out.print("#" + T + " ");
//			while(!q.isEmpty()) {
//				System.out.print(q.poll() + " ");
//			}
//			System.out.println();

			int[] q = new int[8];
			int front = -1;
			int rear = -1;
			int minVal = Integer.MAX_VALUE;

			for (int i = 0; i < 8; i++) {
				q[++rear] = sc.nextInt();
				if(minVal > q[rear])
					minVal = q[rear];
			}

			boolean toggle = true;
			while (toggle) {
				for (int j = 1; j <= 5; j++) {
					q[++front % 8] = q[front % 8] - j;
					if (q[front % 8] <= 0) {
						q[front % 8] = 0;
						toggle = false;
						break;
					}
				}
			}
			
			System.out.print("#" + T + " ");
			for (int i = 0; i < q.length; i++) {
				System.out.print(q[++front % 8] + " ");
			}
			System.out.println();
			
		}
	}
}
