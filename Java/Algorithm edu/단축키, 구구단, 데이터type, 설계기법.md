# 단축키, 구구단, 데이터type, 설계기법

## 이클립스 단축키

- main method 생성: m -> ctrl+space+enter
- for문 생성 : for -> ctrl+space+enter
- 주석처리 :  ctrl+/
- 자동완성 : Ctrl+spacebar
- 컴파일 : Ctrl+F11
- 디버깅 : 
- 네이게이션



## 구구단 코드

```java
// 한줄 주석

/* 여러줄 주석, 부분주석 */

/** 문서주석
 * 클래스, 메서드, 변수의 선언부 앞에 작성해서
 * 부가적인 설명을 달아줌
 */

public class Z01_Test {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] Gugudan = new String[10][10];
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				Gugudan[i][j] = String.format("%d*%d=%2d",i,j,i*j);
			}
		}
		
		for(int i=2; i<=9; i = i+2) {
			for(int j=1; j<=9; j++) {
				System.out.print(Gugudan[i][j] + "  " + Gugudan[i+1][j]);
				System.out.println();
			}	
		}
	}*/
	
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i+=2) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d*%d=%2d  ", i, j, i*j);
				System.out.printf("%d*%d=%2d\n", i+1, j, (i+1)*j);
			}
		}
	}//end of main
	
}// end of class

```



## 기본형, 참조형

- 기본형 타입 8가지
  - 정수형: byte(1), short(2), "int"(4):21억, long(8)
  - 실수형: float(4), "double"(8)
  - 문자형: char(2)
  - 논리형: boolean(1)



## 문자열 String

```java
String s = "a";
		System.out.println(s);
		s="hi"+"hello"; // 문자열 끼리의 덧셈연산은 이어붙여준다
		System.out.println(s);
		s="hi"+3; // 문자열 + 비문자열 : 비문자열을 문자열로 변경해줌
		System.out.println(s); // hi3
		s = 3 + 4 + "hi"; // 7hi
		System.out.println(s);
		s = 3 + 4 + "hi" + 3 + 4;
		System.out.println(s); // 7hi34
		
		String str = "abcdefghij";
		System.out.println(str.length());
		System.out.println(str.charAt(4));
```



## 알고리즘 설계 기법

- BruteForce 완전탐색
- Greedy 탐욕기법
- Backtracking 가지치기

---------------------------------- 답을 못 구할 수 있지만 빠르다 -----------------------------------

- Divide&Conquer 분할정복
- Dp 동적계획법



```Test1
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
```

```Test2
import java.util.Scanner;
import java.util.Vector;

public class Swexpert5215 {
	
	static int visited[] = new int[21];
	static int[] score;
	static int[] K;
	static Vector<Integer> v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int L = sc.nextInt();

			score = new int[N];
			K = new int[N];
			v = new Vector<Integer>();
			
			for(int i=0; i<N; i++) {
				score[i] = sc.nextInt();
				K[i] = sc.nextInt();
			}
						
			for(int i=0; i<N; i++) {
				visited[i] = 1;
				v.add(score[i]);
				makeBurger(N, L, score[i], K[i], i);
				visited[i] = 0;
			}
			
			int answer = 0;
			for(int i : v) {
				if(answer < i)
					answer = i;
			}
						
						
			System.out.println("#" + test_case + " " + answer);
		}
		
	} // end of main
	
	static void makeBurger(int N, int L, int sum, int cal, int index) {
		for(int i=index; i<N; i++) {
			if(visited[i] == 0) {
				if(cal+K[i] <= L) {
					visited[i] = 1;
					v.add(sum+score[i]);
					makeBurger(N,L, sum+score[i], cal+K[i], i);
					visited[i] = 0;
				}
			}
		}
	}

} // end of class
```

```Test3
import java.util.Scanner;
import java.util.Vector;

public class Swexpert3307 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			int[] dp = new int[N+1];
			arr[N] = -1;
			
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			
			for(int i=N-1; i>=0; i--) {
				int cur = 1;
				for(int j=i+1; j<N; j++) {
					if(arr[i] < arr[j]) {
						cur = Math.max(cur, dp[j]+1);
					}
				}
				dp[i] = cur;
			}
			
			int answer = 0;
			for(int i=0; i<N; i++) {
				if(answer < dp[i])
					answer = dp[i];
			}
			
						
			System.out.println("#" + test_case + " " + answer);
		}
		
	} // end of main

} // end of class
```

- 정렬

  - 카운팅(O[n])
  - 힙,쉘,병합,퀵(O[nlogn])
  - 삽입, 선택, 거품(O[n^2])

  

- 배열이 가장 빠르다



## SWAP, ROTATE, MAX, CNT

```java
import java.util.Arrays;

/**연습문제*/
public class Z02_Gravity {

	public static void main(String[] args) {
		// TODO Auto-generated method s
		int[] box = {7,4,2,0,0,6,0,7,0};
		
// 1=> 2차원 배열 박스1, 빈공간0, 회전, 중력, 낙차(최대값)

		int[][] map = new int[8][9];
		
		for(int c=0; c < box.length; c++) {
			for(int r = map.length-1; r >= 0 ; r--) {
				if(box[c] <= 0)
					break;
				
				map[r][c] = 1;
				box[c]--;
			}
		}
		
		
	
		
		// 회전
		int[][] room = new int[9][8];
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				room[i][j] = map[map.length-1-j][i];
			}
		}
		
		
		
		//중력=> 박스를 아래쪽(바닥으로 옮기기)
		// 아래쪽 박스부터 떨어뜨리자: 현재칸은 박스이고, 아래칸이 비어있으면, 값을 바꿈
		int answer=0;
		for(int r=room.length-2; r>= 0; r--) {
			for (int c = 0; c < room[r].length; c++) {
				int cnt=0;
				for (int i = 0; r+1+i<room.length; i++) { // 바닥에 닿을때까지 or 박스에 닿을 때까지 내리기
					if(room[r+i][c] == 1 && room[r+i+1][c] == 0) { // 내릴 수 있는 상황이면 = 나는 상자, 아래칸은 빈칸
						room[r+i][c] = 0;
						room[r+i+1][c] = 1;
						cnt++;
					}
				}
				if(answer < cnt)
					answer = cnt;
			}
		}
		
		
		for(int r=0; r<9; r++) {
			System.out.println(Arrays.toString(room[r])); // 1차원 배열의 원소를 문자열로 표시
		}

				
		System.out.println(answer);


	}

}
```

