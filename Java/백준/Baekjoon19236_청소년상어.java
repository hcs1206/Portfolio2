//package SW;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Baekjoon19236_청소년상어 {
//
//	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
//	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
//	static int answer;
//
//	static int[][] dir = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };
//
//	static class Fish {
//		int num;
//		int dest;
//		int r;
//		int c;
//
//		public int getDest() {
//			return dest;
//		}
//
//		public void setDest(int dest) {
//			this.dest = dest;
//		}
//
//		public int getNum() {
//			return num;
//		}
//
//		public void setNum(int num) {
//			this.num = num;
//		}
//
//		public int getR() {
//			return r;
//		}
//
//		public void setR(int r) {
//			this.r = r;
//		}
//
//		public int getC() {
//			return c;
//		}
//
//		public void setC(int c) {
//			this.c = c;
//		}
//
//		public Fish(int num, int dest, int r, int c) {
//			super();
//			this.num = num;
//			this.dest = dest;
//			this.r = r;
//			this.c = c;
//		}
//
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		Fish[][] originalMap = new Fish[4][4];
//
//		for (int i = 0; i < originalMap.length; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < originalMap[i].length; j++) {
//				int fishNum = Integer.parseInt(st.nextToken());
//				int fishDest = Integer.parseInt(st.nextToken()) - 1;
//				originalMap[i][j] = new Fish(fishNum, fishDest, i, j);
//			}
//		}
//
//		answer = originalMap[0][0].getNum();
//		Fish shark = new Fish(-1, originalMap[0][0].getDest(), 0, 0);
//		originalMap[0][0] = shark;
//
//		Fish[][] copyMap = new Fish[4][4];
//		for (int i = 0; i < originalMap.length; i++) {
//			System.arraycopy(originalMap[i], 0, copyMap[i], 0, originalMap[i].length);
//		}
//
//		for (int fishNum = 1; fishNum <= 16; fishNum++) {
//			loop: for (int i = 0; i < 4; i++) {
//				for (int j = 0; j < 4; j++) {
//					if (copyMap[i][j].getNum() == fishNum) {
//						for (int d = 0; d < 8; d++) {
//							int nextR = i + dir[copyMap[i][j].getDest()][0];
//							int nextC = j + dir[copyMap[i][j].getDest()][1];
//
//							if (nextR < 0 || nextC < 0 || nextR > 3 || nextC > 3
//									|| copyMap[nextR][nextC].getNum() < 0) {
//								copyMap[i][j].setDest((copyMap[i][j].getDest() + 1) % 8);
//								continue;
//							}
//
//							Fish temp = copyMap[nextR][nextC];
//							copyMap[nextR][nextC] = copyMap[i][j];
//							copyMap[i][j] = temp;
//							break loop;
//
//						}
//						break loop;
//					}
//				}
//			}
//
//		}
//
//		int temp = answer;
//
//		sharkMove(shark, copyMap, 1, temp);
//		sharkMove(shark, copyMap, 2, temp);
//		sharkMove(shark, copyMap, 3, temp);
//
//		System.out.println(answer);
//
//	}
//
//	private static void sharkMove(Fish shark, Fish[][] tempMap, int moveNum, int sum) {
//		int nextR = shark.getR() + dir[shark.getDest()][0] * moveNum;
//		int nextC = shark.getC() + dir[shark.getDest()][1] * moveNum;
//
//		if (moveNum > 3)
//			return;
//
//		if (nextR < 0 || nextC < 0 || nextR > 3 || nextC > 3 || tempMap[nextR][nextC].getNum() < 0) {
//			sharkMove(shark, tempMap, moveNum + 1, sum);
//			return;
//		}
//
//		Fish[][] copyMap = new Fish[4][4];
//		for (int i = 0; i < copyMap.length; i++) {
//			System.arraycopy(tempMap[i], 0, copyMap[i], 0, tempMap[i].length);
//		}
//
//		sum += copyMap[nextR][nextC].getNum();
//		shark.setDest(copyMap[nextR][nextC].getDest());
//		shark.setR(nextR);
//		shark.setC(nextC);
//		copyMap[nextR][nextC] = shark;
//
//		if (sum > answer) {
//			answer = sum;
//		}
//
//		for (int fishNum = 1; fishNum <= 16; fishNum++) {
//			loop: for (int i = 0; i < 4; i++) {
//				for (int j = 0; j < 4; j++) {
//					if (copyMap[i][j].getNum() == fishNum) {
//						for (int d = 0; d < 8; d++) {
//							int nextFishR = i + dir[copyMap[i][j].getDest()][0];
//							int nextFishC = j + dir[copyMap[i][j].getDest()][1];
//
//							if (nextFishR < 0 || nextFishC < 0 || nextFishR > 3 || nextFishC > 3
//									|| copyMap[nextFishR][nextFishC].getNum() < 0) {
//								copyMap[i][j].setDest((copyMap[i][j].getDest() + 1) % 8);
//								continue;
//							}
//
//							Fish temp = copyMap[nextFishR][nextFishC];
//							copyMap[nextFishR][nextFishC] = copyMap[i][j];
//							copyMap[i][j] = temp;
//							break loop;
//						}
//						break loop;
//					}
//				}
//			}
//
//		}
//
//		sharkMove(shark, copyMap, 1, sum);
//		sharkMove(shark, tempMap, 2, sum);
//		sharkMove(shark, tempMap, 3, sum);
//	}
//
//}
