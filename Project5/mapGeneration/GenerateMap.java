package mapGeneration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GenerateMap {
	private static ArrayList<Integer> walls = new ArrayList<Integer>() {{
	    add(67);
	}};
	
	private static ArrayList<Integer> floors = new ArrayList<Integer>() {{
	    add(57);
	}};
	
	public static void main(String[] args) throws IOException {
		/*int[][] map = new int[width][height];
		
		map[0][0] = wall(0);
		map[0][1] = wall(0);
		map[0][2] = wall(0);
		map[0][3] = wall(0);
		map[0][4] = wall(0);
		map[0][5] = wall(0);
		
		map[1][0] = wall(0);
		map[1][1] = floor(0);
		map[1][2] = floor(0);
		map[1][3] = floor(0);
		map[1][4] = floor(0);
		map[1][5] = wall(0);
		
		map[2][0] = wall(0);
		map[2][1] = floor(0);
		map[2][2] = floor(0);
		map[2][3] = floor(0);
		map[2][4] = floor(0);
		map[2][5] = wall(0);
		
		map[3][0] = wall(0);
		map[3][1] = floor(0);
		map[3][2] = floor(0);
		map[3][3] = floor(0);
		map[3][4] = floor(0);
		map[3][5] = wall(0);
		
		map[4][0] = wall(0);
		map[4][1] = floor(0);
		map[4][2] = floor(0);
		map[4][3] = floor(0);
		map[4][4] = floor(0);
		map[4][5] = wall(0);
		
		map[5][0] = wall(0);
		map[5][1] = wall(0);
		map[5][2] = wall(0);
		map[5][3] = wall(0);
		map[5][4] = wall(0);
		map[5][5] = wall(0);
		
		FileActions.createFile(3, 3, 4, 4, map);
		
		System.out.println("Map Created");*/
		
		int width = 3;
		int height = 3;
		int[][] map = new int[width][height];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		map[0][0] = 0;map[0][1] = 1;map[0][2] = 2;
		map[1][0] = 3;map[1][1] = 4;map[1][2] = 5;
		map[2][0] = 6;map[2][1] = 7;map[2][2] = 8;
		
		/*
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width - 1; j++) {
				Edge e = new Edge(map[i][j], map[i][j+1]);
				edges.add(e);
			}
		}
		
		for(int i = 0; i < height - 1; i++) {
			for(int j = 0; j < width; j++) {
				Edge e = new Edge(map[i][j], map[i + 1][j]);
				edges.add(e);
			}
		}*/
		
		edges.add(new Edge(0, 1, 2));
		edges.add(new Edge(0, 2, 3));
		edges.add(new Edge(0, 3, 3));
		edges.add(new Edge(3, 2, 5));
		edges.add(new Edge(3, 5, 7));
		edges.add(new Edge(2, 4, 1));
		edges.add(new Edge(1, 4, 3));
		edges.add(new Edge(1, 2, 4));
		edges.add(new Edge(4, 5, 8));
		edges.add(new Edge(5, 6, 9));
		
		Collections.sort(edges, new EdgeComparator());
		
		//Edge.printEdgeList(edges);
		
		ArrayList<Edge> tree = new ArrayList<Edge>();
		for(int i = 0; i < edges.size(); i++) {
			Edge cur = edges.get(i);
			//if not cycle
			if(!Edge.causeCycle(tree, cur)) {
				tree.add(cur);
			}
		}
		
		Edge.printEdgeList(tree);
		Edge.calculateWeight(tree);
	}
	
	public int[][] kruskalMap(int width, int height) {
		int[][] map = new int[width][height];
		
		return map;
	}
	
	public static int floor(int type) {
		return floors.get(type);
	}
	
	public static int wall(int type) {
		return walls.get(type);
	}
}
/*
2 2 2 2 2 2 2 2
2 1 1 1 0 0 0 2
2 0 0 1 0 0 0 2 
2 1 1 1 1 0 0 2
2 0 1 0 1 0 0 2
2 0 1 1 1 1 1 2
2 0 1 0 0 1 0 2
2 2 2 2 2 2 2 2
*/
