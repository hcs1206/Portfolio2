package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2174_로봇시뮬레이션 {

	static class Robot {
		int x;
		int y;
		int dest;

		public Robot(int x, int y, int dest) {
			super();
			this.x = x;
			this.y = y;
			this.dest = dest;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int[] dy = { 0, 1, 0, -1 }; // ENWS
		int[] dx = { 1, 0, -1, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] map = new int[B + 1][A + 1];

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Robot> rb = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);

			map[y][x] = i+1;
			rb.add(new Robot(x, y, d == 'E' ? 0 : d == 'N' ? 1 : d == 'W' ? 2 : 3));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int robotNum = Integer.parseInt(st.nextToken());
			char command = st.nextToken().charAt(0);
			int repeat = Integer.parseInt(st.nextToken());
			
			Robot robot = rb.get(robotNum-1);
			
			for (int j = 0; j < repeat; j++) {
				if(command == 'L') {
					rb.get(robotNum-1).dest = (robot.dest+1)%4;
				} else if(command == 'R') {
					rb.get(robotNum-1).dest = (robot.dest+3)%4;
				} else {
					int nX = robot.x + dx[robot.dest];
					int nY = robot.y + dy[robot.dest];
					
					if(nX < 1 || nY < 1 || nX >  A || nY > B) {
						System.out.println("Robot " + robotNum + " crashes into the wall");
						return;
					} else if(map[nY][nX] > 0) {
						System.out.print("Robot " + robotNum +" crashes into robot " + map[nY][nX]);
						return;
					}
					
					map[robot.y][robot.x] = 0;
					map[nY][nX] = robotNum;
					rb.get(robotNum-1).x = nX;
					rb.get(robotNum-1).y = nY;
					
				}
			}
			
		}

		System.out.print("OK");

	}

}
