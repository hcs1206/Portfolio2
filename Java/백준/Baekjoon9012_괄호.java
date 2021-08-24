package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int flag = 0;
			
			for (int j = 0; j < str.length(); j++) {
				
				flag = str.charAt(j) == '(' ? flag+1 : flag-1;
				
				if(flag < 0)
					break;
				
			}
			
			if(flag == 0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}

	}

}
