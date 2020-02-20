import java.util.Scanner;

public class Swexpert2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();

			int answer = 0;
			for (int i = 1; i <= 10; i++) {
				boolean toggle = true;
				String temp = str.substring(0, i);
				for (int j = 0; j < str.length(); j = j + i) {
					if (j + i < str.length()) {
						if (!temp.equals(str.substring(j, j + i))) {
							toggle = false;
							break;
						}
					}
				}
				if (toggle) {
					answer = i;
					break;
				}

			}
			System.out.println("#" + test_case + " " + answer);
			
			
/*			
			// 잘못된 풀이
			String s = sc.next();
//			1글자, 0<= <1		1<= <2
//			2글자, 0<= <2		2<= <4
//			3글자, 0<= <3		3<= <6
//			...
//			10글자, 0<= <10		10<= <20
			
			int answer=0;
			for (int i = 1; i <= 10; i++) {
				String sub1 = s.substring(0,i);
				String sub2 = s.substring(i,i*2);
				if(sub1.equals(sub2)) {
					answer = i;
					break;
				}
			}
			System.out.println("#" + test_case + " " + answer);
*/
			

			
		}
	}
}
