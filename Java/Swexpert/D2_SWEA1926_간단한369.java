import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

class Swexpert1926
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int N;
		N=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int i=1; i<=N; i++) {
			int temp = i;
			String str = "";
			while(true) {
				if(temp%10 == 3 || temp%10 == 6 || temp%10 == 9) {
					str = str+"-";
				}
				if(temp/10 == 0)
					break;
				else {
					temp = temp/10;
				}
			}
			
			if(str.length() > 0) {
				System.out.print(str);
				System.out.print(" ");
			}
			else {
				System.out.print(i);
				System.out.print(" ");
			}
		}
		
		
	}
}