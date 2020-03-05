import java.io.IOException;
import java.util.Scanner;

public class SWEA4796_의석이의우뚝선산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			
			int[] mount = new int[N];
						
			for (int i = 0; i < N; i++) {
				mount[i] = sc.nextInt();
			}
			
			int ans = 0;
			
			for (int i = 0; i < N; i++) {
				int cnt = 1;
				boolean check = false;
				for (int j = i; j < N-1; j++) {
					if(mount[j] < mount[j+1] && !check) {
						cnt++;
						i = j;
					}
					else if(mount[j] < mount[j+1] && check) {
						i = j-1;
						break;
					}
					if(mount[j] > mount[j+1]) {
						if(!check) cnt--;
						ans+= cnt;
						i=j;
						check = true;
					}
				}
			}
			

			System.out.println("#" + test_case + " " + ans);
			
		}
	}
}
