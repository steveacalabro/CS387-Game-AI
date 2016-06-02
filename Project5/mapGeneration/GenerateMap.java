package mapGeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class GenerateMap {
	private static ArrayList<Integer> walls = new ArrayList<Integer>() {{
	    add(67);
	}};
	
	private static ArrayList<Integer> floors = new ArrayList<Integer>() {{
	    add(57);
	}};
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
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
		
		createFile(2, 2, 6, 6, map);
	}
	
	public static void createFile(int startX, int startY, int width, int height, int[][] map) throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File("C:/Users/midevilw0rm/_git/CS387-Game-AI/Project5/games/example/newMap.tmx");
		PrintWriter writer = new PrintWriter(file, "UTF-8");
		
		//Header to XML
		writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.println("<map version=\"1.0\" orientation=\"orthogonal\" width=\"" + width + "\" height=\"" + height + "\" tilewidth=\"64\" tileheight=\"64\">");
		writer.println("<properties>");
		writer.println("<property name=\"name\" value=\"Steve's Map\"/>");
		writer.println("</properties>");
		writer.println("<tileset firstgid=\"1\" name=\"graphics\" tilewidth=\"64\" tileheight=\"64\">");
		writer.println("<image source=\"graphics2x-basic.png\" width=\"640\" height=\"1344\"/>");
		writer.println("</tileset>");
		writer.println("<tileset firstgid=\"211\" name=\"walls\" tilewidth=\"64\" tileheight=\"64\">");
		writer.println("<image source=\"graphics2x-walls.png\" width=\"128\" height=\"1024\"/>");
		writer.println("</tileset>");
		writer.println("<layer name=\"Tile Layer 1\" width=\"" + width + "\" height=\"" + height +"\">");
		writer.println("<data>");
		
		//Loop for Map
		writer.println("<tile gid=\"67\"/><tile gid=\"67\"/><tile gid=\"67\"/><tile gid=\"67\"/><tile gid=\"67\"/><tile gid=\"67\"/>");
		writer.println("<tile gid=\"67\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"67\"/>");
		writer.println("<tile gid=\"67\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"67\"/>");
		writer.println("<tile gid=\"67\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"67\"/>");
		writer.println("<tile gid=\"67\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"57\"/><tile gid=\"67\"/>");
		writer.println("<tile gid=\"67\"/><tile gid=\"67\"/><tile gid=\"67\"/><tile gid=\"67\"/><tile gid=\"67\"/><tile gid=\"67\"/>");

		//Closing
		writer.println("</data>");
		writer.println("</layer>");
		writer.println("</map>");
		writer.close();
	}
	
	
	public static int floor(int type) {
		return floors.get(type);
	}
	
	public static int wall(int type) {
		return walls.get(type);
	}
}
