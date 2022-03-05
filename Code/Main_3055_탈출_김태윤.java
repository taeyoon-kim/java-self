package githubtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 11840kb
//시간 : 80ms

public class Main_3055_탈출_김태윤 {

	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int R,C;
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[R][C];
		boolean[][] isChecked = new boolean[R][C];
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		int a=-2;
		int b=-2;
		
		for(int i = 0; i<R; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j = 0; j<C; j++) {
				board[i][j] = arr[j];
				
				if(board[i][j] == '*') {
					q.offer(new int[] {i,j,0});
					isChecked[i][j] = true;
				}
				
				if(board[i][j] == 'S') {
					a = i;
					b = j;
					isChecked[i][j] = true;
				}
			}
		}
		
		q.offer(new int[] {a,b,1});
		
		
		int answer = 0;
		LOOP:while(!q.isEmpty()) {
			answer--;
			int cnt = q.size();
			
			while(cnt-- > 0) {
				for(int i =0; i<4; i++) {
					int x = q.peek()[0] + dx[i];
					int y = q.peek()[1] + dy[i];
					
					if(x<0 || y<0 || x>=R || y>=C)
						continue;
					
					if(board[x][y] == 'X')
						continue;
					
					if(isChecked[x][y])
						continue;
					
					if(board[x][y] == 'D') {
						if(q.peek()[2] == 0)
							continue;
						else {
							answer *= -1;
							break LOOP;
						}
					}
					
					q.offer(new int[] {x,y,q.peek()[2]});
					isChecked[x][y] = true;
				}
				q.poll();
			}
		}
		
		if(answer<0)
			System.out.println("KAKTUS");
		else
			System.out.println(answer);
	}

}
