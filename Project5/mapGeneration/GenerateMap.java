package mapGeneration;

import java.io.IOException;
import java.util.ArrayList;

public class GenerateMap {
	private static ArrayList<Integer> walls = new ArrayList<Integer>() {{
	    add(67);
	}};
	
	private static ArrayList<Integer> floors = new ArrayList<Integer>() {{
	    add(57);
	}};
	
	public static void main(String[] args) throws IOException {
		int width = 6;
		int height = 6;
		int[][] map = new int[width][height];
		
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
		
		FileActions.createFile(3, 3, 6, 6, map);
		
		System.out.println("Map Created");
	}
	
	public static int floor(int type) {
		return floors.get(type);
	}
	
	public static int wall(int type) {
		return walls.get(type);
	}
}
