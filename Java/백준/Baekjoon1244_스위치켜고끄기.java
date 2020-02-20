import java.util.Scanner;

public class Baekjoon1244_스위치켜고끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] Switch = new int[N+1];
		for (int i = 1; i <= N; i++)
			Switch[i] = sc.nextInt();
		
		Switch[0] = -1;
		
		int sNum = sc.nextInt();
		for (int i = 0; i < sNum; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			//int count = 1;
			if(gender == 1) {
				while(num <= N) {
					Switch[num] = (Switch[num]+1)%2;
					num += num;
				}			
			}
			else {
				int front = num;
				int end = num;
				while(true) {
					if(front > 0 && end <= N) {
						if(Switch[front] != Switch[end]) {
							break;
						}
						front--;
						end++;
					}
					else {
						front++;
						end--;
						break;
					}
				}
				for(int j = front; j<=end; j++) {
					Switch[j] = (Switch[j]+1)%2;
				}
			}
			
		}
		
		for (int i = 1; i < Switch.length; i++) {
			System.out.print(Switch[i] + " ");
		}
		
	}
}
