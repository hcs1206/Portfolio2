import java.util.Arrays;
import java.util.Scanner;

public class Swexpert1289 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 0; test_case <= T; test_case++) {
			String str = sc.next();
			String firstState = "";
			for(int i=0; i<str.length(); i++)
				firstState += "0";
	
			int answer = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '1') {
					answer++;
					if(i+1 >= str.length()) {
						break;
					}
					else {
						if(str.charAt(i+1) == '0')
							answer++;
						else {
							int k = i+1;
							while(true) {
								k++;
								if(k >= str.length())
									break;
								
								if(str.charAt(k) == '0') {
									answer++;
									break;
								}
							}
							i = k;
						}
					}
				}
			}
			
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		
	} // end of main

} // end of class