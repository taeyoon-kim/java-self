package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_트리의_부모_찾기_김태윤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<LinkedList<Integer>> arr = new ArrayList<LinkedList<Integer>>(N+1);
		int[] parent = new int[N+1];
		parent[1] = 1;
		
		for(int i = 0; i<N+1; i++) {
			arr.add(new LinkedList<Integer>());
		}
				
		StringTokenizer st = null;
		for(int i = 0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
//			System.out.println(x+" "+y);
			arr.get(x).push(y);
			arr.get(y).push(x);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i = 0; i<arr.get(num).size(); i++) {
				int temp = arr.get(num).get(i);
				if(parent[temp] == 0) {
					parent[temp] = num;
					q.offer(temp);
				}
			}
		}
		
		for(int i = 2; i<=N; i++) {
			System.out.println(parent[i]);
		}
		
	}

}
