# Operations



## Operations

- Java는 모든 것이 클래스 내에서 구현, 단 2가지를 제외
  - package : 현재 파일의 위치(폴더 구조)
  - import : 현재 파일이 사용하는 class의 위치(폴더 구조)

```java
// package : 현재 파일의 위치(폴더 구조)
// import : 현재 파일이 사용하는 class의 위치(폴더 구조)
public class Operations {
	int memberTest;
	
	// 데이터 요소 - member variable
	// 기능 요소 - member method
	// 메소드의 구성 - access modifier + return type + method name + parameter list
	// public - 누구나 사용할 수 있는
	// parameter list - 메소드에 일을 시킬 때, 필요한 외부 데이터를 명시
	public void plus() {
		System.out.println(7+8);
	}
	
	public void plus2(int a, int b) {
		System.out.println(a+b);
	}
	
	public void plus2(float a, int b) {
		System.out.println(a+b);
	} // overload - parameter가 다르면 같은 이름의 메소드라도 중복 선언 가능.
	// override - 재정의, overload - 중복 정의
	
	public float plus3(int a, int b) {
		return a+b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
```



## 실습문제1-로봇 이동거리

```java
import java.util.Arrays;
import java.util.Scanner;

public class Practice1_Robot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			char[][] map = new char[N+2][N+2];
			int answer = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					
					if(map[i][j] == 'A') {
						int k=1;
						while(map[i][j+k] == 'S') {
							k++;
							answer++;
						}
					}
					
					else if(map[i][j] == 'B') {
						int k=1;
						while(map[i][j+k] == 'S') {
							k++;
							answer++;
						}
						k=1;
						while(map[i][j-k] == 'S') {
							k++;
							answer++;
						}
					}
					
					else if(map[i][j] == 'C') {
						int k=1;
						while(map[i][j+k] == 'S') {
							k++;
							answer++;
						}
						k=1;
						while(map[i][j-k] == 'S') {
							k++;
							answer++;
						}
						k=1;
						while(map[i+k][j] == 'S') {
							k++;
							answer++;
						}
						k=1;
						while(map[i-k][j] == 'S') {
							k++;
							answer++;
						}
					}
					
					
				}
			} // end of for
			
			System.out.println("#" + test_case + " " + answer);
		} // end of testcase
		
	}
}
```



## 실습문제2-소금쟁이

```java
import java.util.Arrays;
import java.util.Scanner;

public class Practice2_sogeum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int bug = sc.nextInt();
			boolean[][] map = new boolean[N][N];
			boolean toggle = false;
			int[] indexR = new int[bug]; 
			int[] indexC = new int[bug];
			int[] dest = new int[bug];
			int answer = 0;
			
			for (int i = 0; i < bug; i++) {
				indexR[i] = sc.nextInt();
				indexC[i] = sc.nextInt();
				dest[i] = sc.nextInt();
			}
			
			
			for (int i = 0; i < bug; i++) {
				if(toggle)
					break;
				
				if(dest[i] == 1) {
					int curR = indexR[i];
					int curC = indexC[i];
					
					for (int jump = 3; jump >= 0; jump--) {
						if(map[curR][curC]) {
							answer = i+1;
							toggle = true;
							break;
						}
						if(jump != 3) {
							map[curR][curC] = true;
						}
						curR += jump;
						
						if(curR >= N)
							break;	
					}
				}
				else {
					int curR = indexR[i];
					int curC = indexC[i];
					
					for (int jump = 3; jump >= 0; jump--) {
						if(map[curR][curC]) {
							answer = i+1;
							toggle = true;
							break;
						}
						if(jump != 3) {
							map[curR][curC] = true;
						}
						curC += jump;
						
						if(curC >= N)
							break;	
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		} // end of testcase
		
	}
}
```



## 실습문제3-미로

```java
import java.util.Arrays;
import java.util.Scanner;

public class Practice3_mirro {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] mirro = new int[N + 2][N + 2];
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			int jumperNum = sc.nextInt();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					mirro[i][j] = 1;
				}
			}

			for (int i = 0; i < jumperNum; i++) {
				int jumperR = sc.nextInt();
				int jumperC = sc.nextInt();
				mirro[jumperR][jumperC] = 5;
			}

			int commandNum = sc.nextInt();
			int[] dest = new int[commandNum];
			int[] move = new int[commandNum];
			for (int i = 0; i < commandNum; i++) {
				dest[i] = sc.nextInt();
				move[i] = sc.nextInt();
			}
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			int answerR = 1;
			int answerC = 1;

			for (int i = 0; i < commandNum; i++) {
				int curDest = dest[i]-1;
				int curMove = move[i];
				for (int j = 0; j < curMove; j++) {
					startR += dr[curDest];
					startC += dc[curDest];
					if (mirro[startR][startC] != 1) {
						answerR = 0;
						answerC = 0;
						break;
					}
					else {
						answerR = startR;
						answerC = startC;
					}
				}
				if(answerR == 0 && answerC == 0)
					break;
			}

			System.out.println("#" + test_case + " " + answerR + " " + answerC);
		} // end of testcase

	} // end of main
} // end of class
```

## Workshop_빌딩

```java
package com.ssafy.algo;

import java.util.Scanner;

public class Solution13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int answer = 0;
			
			char[][] map = new char[N+2][N+2];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			int[] dr = {-1,-1,-1,0,1,1,1,0};
			int[] dc = {-1,0,1,1,1,0,-1,-1};
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 'B') {
						boolean hasGarden = false;
						for (int k = 0; k < dc.length; k++) {
							if(map[i+dr[k]][j+dc[k]] == 'G') {
								hasGarden = true;
								break;							
							}
								
						}
						if(hasGarden) {
							if(answer < 2)
								answer = 2;
						}
						else {
							int height = 1;
							for (int k = 1; k <= N; k++) {
								if(map[i][k] == 'B')
									height++;
							}
							for (int k = 1; k <= N; k++) {
								if(map[k][j] == 'B')
									height++;
							}
							if(answer < height)
								answer = height-2;
						}
					} // end of map if
				}
			}
		
			System.out.println("#"+test_case+" "+answer);
		} // end of testcase
	}
}
```

## Homework_소금쟁이중첩

```java
package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int bug = sc.nextInt();
			int[][] map = new int[N][N];
			int[] indexR = new int[bug];
			int[] indexC = new int[bug];
			int[] dest = new int[bug];
			int answer = bug;

			for (int i = 0; i < bug; i++) {
				indexR[i] = sc.nextInt();
				indexC[i] = sc.nextInt();
				map[indexR[i]][indexC[i]]++;
				dest[i] = sc.nextInt();
			}

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			
			for (int i = 0; i < map.length; i++) {
				System.out.println(Arrays.toString(map[i]));
			}

			for (int i = 0; i < bug; i++) {

				int curR = indexR[i];
				int curC = indexC[i];
				int curDest = dest[i];
				
				if (map[curR][curC] > 1) { // 시작위치에 다른 소금쟁이가 있으면
					map[curR][curC]--;
					answer--;
					break;
				}

				for (int jump = 3; jump >= 0; jump--) {
					
					map[curR][curC]--; // 기존 위치 소금쟁이 삭제
					
					curR += jump*dr[curDest-1];
					curC += jump*dc[curDest-1];
					
					if (curR >= N || curC >= N || curR < 0 || curC < 0) { 
						answer--;
						break;
					} // 맵 밖으로 벗어나면 브레이크
					
					if (map[curR][curC] > 0) { // 밟았을 때
						answer--;
						break;
					}
					
					map[curR][curC]++; // 새로운 위치 소금쟁이 표시
					
				}

				
			}
			
			for (int i = 0; i < map.length; i++) {
				System.out.println(Arrays.toString(map[i]));
			}

			System.out.println("#" + test_case + " " + answer);
		} // end of testcase
	} // end of main
}
```

