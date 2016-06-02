package mapGeneration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileActions {
	/**
	 * This changed the file so that the user can start in different location
	 * @param startX
	 * @param startY
	 * @throws IOException
	 */
	public static void changeMapFile(int startX, int startY) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		File f1 = new File("C:/Users/midevilw0rm/_git/CS387-Game-AI/Project5/games/example/baseExample.xml");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		
		while ((line = br.readLine()) != null) {
		    if (line.contains("STARTX"))
		    	line = line.replace("STARTX", Integer.toString(startX));
		    if (line.contains("STARTY"))
		    	line = line.replace("STARTY", Integer.toString(startY));
		    lines.add(line+"\n");
		}
		fr.close();
		br.close();
		
		File f2 = new File("C:/Users/midevilw0rm/_git/CS387-Game-AI/Project5/games/example/example.xml");
		FileWriter fw = new FileWriter(f2);
		BufferedWriter out = new BufferedWriter(fw);
		for(String s : lines)
		     out.write(s);
		out.flush();
		out.close();
	}
	
	/**
	 * This creates the actual map file
	 * @param startX
	 * @param startY
	 * @param width
	 * @param height
	 * @param map
	 * @throws IOException
	 */
	public static void createFile(int startX, int startY, int width, int height, int[][] map) throws IOException {
		changeMapFile(startX, startY);
		
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
		writer.println("<layer name=\"Base Layer\" width=\"" + width + "\" height=\"" + height +"\">");
		writer.println("<data>");
		
		//Loop for Map
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				writer.println("<tile gid=\"31\"/>");
			}
		}
		
		//Closing
		writer.println("</data>");
		writer.println("</layer>");
		writer.println("<layer name=\"Tile Layer 1\" width=\"" + width + "\" height=\"" + height +"\">");
		writer.println("<data>");
		
		//Loop for Map
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				writer.println("<tile gid=\""+map[i][j]+"\"/>");
			}
		}
		
		//Closing
		writer.println("</data>");
		writer.println("</layer>");
		writer.println("</map>");
		writer.close();
	}
}
