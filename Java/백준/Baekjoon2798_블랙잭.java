import java.util.Scanner;

public class Baekjoon2798 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int answer = 0;

		int[] card = new int[N];
		for (int i = 0; i < card.length; i++) {
			card[i] = sc.nextInt();
		}
		
		for (int i = 0; i < card.length-2; i++) {
			for (int j = i+1; j < card.length-1; j++) {
				for (int k = j+1; k < card.length; k++) {
					if(card[i]+card[j]+card[k] > M)
						continue;
					if(M - (card[i]+card[j]+card[k]) < M-answer) {
						answer = card[i]+card[j]+card[k];
					}
					if(M == answer)
						break;
				}
				if(M == answer)
					break;
			}
			if(M == answer)
				break;
		}
		
		
		System.out.println(answer);

	}
}
